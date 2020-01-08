package com.graphqldocs.dto;

import io.leangen.graphql.annotations.types.GraphQLType;
import lombok.Data;

@GraphQLType(description = "All data required for creating blog post.")
@Data
public class CreateBlogPostDto {

    private String title;
}
