package com.graphqldocs.service;

import com.graphqldocs.converter.BlogPostConverter;
import com.graphqldocs.dto.BlogPostDto;
import com.graphqldocs.graphql.GraphQLService;
import com.graphqldocs.repository.BlogPostRepository;
import com.graphqldocs.security.GraphQLSecured;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLNonNull;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class SecuredBlogPostService implements GraphQLService {

    private final BlogPostRepository blogPostRepository;
    private final BlogPostConverter converter;

    @GraphQLSecured
    @GraphQLQuery(
            name = "securedAllBlogPosts",
            description = "Secured call to get all blog posts."
    )
    public List<BlogPostDto> getAllBlogPosts() {
        log.info("Secured request to get all blog posts.");
        return blogPostRepository.findAll().stream()
                .map(converter::toDto)
                .collect(Collectors.toList());
    }

    @GraphQLSecured
    @GraphQLQuery(
            name = "securedBlogPostById",
            description = "Secured call to get blog post by id."
    )
    public BlogPostDto getBlogPostById(
            @GraphQLArgument(name = "id", description = "Blog post id in the UUID format.") @GraphQLNonNull UUID id
    ) {
        log.info("Secured request to get blog post: " + id);
        return Optional.ofNullable(blogPostRepository.findOne(id))
                .map(converter::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Post not found: " + id));
    }
}
