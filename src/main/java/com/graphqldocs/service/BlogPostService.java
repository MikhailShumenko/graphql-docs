package com.graphqldocs.service;


import com.graphqldocs.converter.BlogPostConverter;
import com.graphqldocs.dto.BlogPostDto;
import com.graphqldocs.dto.CreateBlogPostDto;
import com.graphqldocs.graphql.GraphQLService;
import com.graphqldocs.model.BlogPost;
import com.graphqldocs.repository.BlogPostRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class BlogPostService implements GraphQLService {

    private final BlogPostRepository blogPostRepository;
    private final BlogPostConverter converter;

    @GraphQLQuery(
            name = "allBlogPosts",
            description = "Get all blog posts."
    )
    public List<BlogPostDto> getAllBlogPosts() {
        log.info("Requested all blog posts.");
        return blogPostRepository.findAll().stream()
                .map(converter::toDto)
                .collect(Collectors.toList());
    }

    @GraphQLQuery(
            name = "blogPostById",
            description = "Get blog post by id."
    )
    public BlogPostDto getBlogPostById(
            @GraphQLArgument(name = "id", description = "Blog post id in the UUID format.") @GraphQLNonNull UUID id
    ) {
        log.info("Requested blog post: " + id);
        return blogPostRepository.findById(id)
                .map(converter::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Post not found: " + id));
    }

    @GraphQLQuery(
            name = "blogPostByTitle",
            description = "Return blog post by tittle."
    )
    public BlogPostDto getBlogPostByTitle(
            @GraphQLArgument(name = "title", description = "Blog post tittle.") @GraphQLNonNull String title
    ) {
        log.info("Requested blog post: " + title);
        return blogPostRepository.findByTitle(title)
                .map(converter::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Post not found: " + title));
    }

    @GraphQLMutation(
            name = "savePost",
            description = "Save blog post."
    )
    public BlogPostDto savePost(CreateBlogPostDto dto) {
        log.info("Requested to save blog post.");
        BlogPost post = new BlogPost();
        BeanUtils.copyProperties(dto, post, "id");
        return converter.toDto(blogPostRepository.save(post));
    }

    @GraphQLMutation(
            name = "deleteById",
            description = "Delete blog post by id."
    )
    public void deleteById(UUID id) {
        log.info("Requested to save blog post.");
        blogPostRepository.deleteById(id);
    }
}
