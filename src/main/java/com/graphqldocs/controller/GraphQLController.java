package com.graphqldocs.controller;

import com.graphqldocs.graphql.ExecutionInputCreator;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class GraphQLController {

    private final GraphQL graphQL;
    private final ExecutionInputCreator inputCreator;

    @PostMapping(
            value = "/graphql",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ExecutionResult execute(@RequestBody Map<String, Object> request) {
        ExecutionInput executionInput = inputCreator.create(request);
        return graphQL.execute(executionInput);
    }
}
