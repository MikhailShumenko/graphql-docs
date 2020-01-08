package com.graphqldocs.dto;

import io.leangen.graphql.annotations.types.GraphQLType;
import lombok.Data;

@GraphQLType(description = "Contains information about blog post.")
@Data
public class BlogPostDto {

    private String title;
}
