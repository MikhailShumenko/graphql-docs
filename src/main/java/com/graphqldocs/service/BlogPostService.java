package com.graphqldocs.service;


import com.graphqldocs.model.BlogPost;
import com.graphqldocs.repository.BlogPostRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class BlogPostService {

    private final BlogPostRepository blogPostRepository;

    public List<BlogPost> allBlogPosts() {
        log.info("Requested all blog posts.");
        return blogPostRepository.findAll();
    }

    public BlogPost getBlogPostById(UUID id) {
        log.info("Requested blog post: " + id);
        return blogPostRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found: " + id));
    }

    public BlogPost getBlogPostByTitle(String title) {
        log.info("Requested blog post: " + title);
        return blogPostRepository.findByTitle(title)
                .orElseThrow(() -> new IllegalArgumentException("Post not found: " + title));
    }

    public BlogPost savePost(BlogPost post) {
        log.info("Requested to save blog post.");
        return blogPostRepository.save(post);
    }

    public void deleteById(UUID id) {
        log.info("Requested to save blog post.");
        blogPostRepository.deleteById(id);
    }
}
