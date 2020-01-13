package com.graphqldocs.config;

import com.graphqldocs.graphql.GraphQLService;
import graphql.GraphQL;
import graphql.execution.AsyncExecutionStrategy;
import graphql.execution.AsyncSerialExecutionStrategy;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.execution.ResolverInterceptor;
import io.leangen.graphql.generator.mapping.AbstractTypeAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class GraphQLConfiguration {

    private final ResolverInterceptor[] resolverInterceptors;
    private final AbstractTypeAdapter[] adapters;

    @Bean
    public GraphQL graphQL(GraphQLSchema schema) {
        return GraphQL.newGraphQL(schema)
                .queryExecutionStrategy(new AsyncExecutionStrategy())
                .mutationExecutionStrategy(new AsyncSerialExecutionStrategy())
                .build();
    }

    @Bean
    public GraphQLSchema generateSchema(List<GraphQLService> services) {
        GraphQLSchemaGenerator builder = new GraphQLSchemaGenerator()
                .withBasePackages("com.graphqldocs", "com.common")
                .withTypeAdapters(adapters)
                .withResolverInterceptors(resolverInterceptors);

        services.forEach(builder::withOperationsFromSingleton);

        return builder.generate();
    }
}
