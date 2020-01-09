package com.graphqldocs.graphql;

import graphql.ExecutionInput;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class ExecutionInputCreator {

    public ExecutionInput create(Map<String, Object> request) {
        return ExecutionInput.newExecutionInput()
                .query((String) request.get("query"))
                .operationName((String) request.get("operationName"))
                .build();
    }
}
