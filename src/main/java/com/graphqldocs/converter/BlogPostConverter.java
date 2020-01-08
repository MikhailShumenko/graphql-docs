package com.graphqldocs.converter;

import com.graphqldocs.dto.BlogPostDto;
import com.graphqldocs.model.BlogPost;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BlogPostConverter {

    public BlogPostDto toDto(BlogPost entity) {
        BlogPostDto dto = new BlogPostDto();
        BeanUtils.copyProperties(entity, dto, "id");
        return dto;
    }

    public BlogPost toEntity(BlogPostDto dto) {
        BlogPost entity = new BlogPost();
        BeanUtils.copyProperties(dto, entity, "id");
        return entity;
    }
}
