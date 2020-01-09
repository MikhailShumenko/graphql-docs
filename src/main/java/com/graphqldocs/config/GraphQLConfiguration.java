package com.graphqldocs.config;

import com.graphqldocs.graphql.GraphQLService;
import graphql.GraphQL;
import graphql.analysis.MaxQueryComplexityInstrumentation;
import graphql.analysis.MaxQueryDepthInstrumentation;
import graphql.execution.batched.BatchedExecutionStrategy;
import graphql.execution.instrumentation.ChainedInstrumentation;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import io.leangen.graphql.execution.ResolverInterceptor;
import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
import io.leangen.graphql.metadata.strategy.query.PublicResolverBuilder;
import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Configuration
public class GraphQLConfiguration {

    private final ResolverInterceptor[] resolverInterceptors;

    @Bean
    public GraphQL graphQL(GraphQLSchema schema) {
        return GraphQL.newGraphQL(schema)
                .queryExecutionStrategy(new BatchedExecutionStrategy())
                .instrumentation(new ChainedInstrumentation(Arrays.asList(
                        new MaxQueryComplexityInstrumentation(200),
                        new MaxQueryDepthInstrumentation(20)
                )))
                .build();
    }

    @Bean
    public GraphQLSchema generateSchema(List<GraphQLService> services) {
        GraphQLSchemaGenerator builder = new GraphQLSchemaGenerator()
                .withResolverInterceptors(resolverInterceptors)
                .withResolverBuilders(
                        new PublicResolverBuilder("com.graphqldocs"),
                        new AnnotatedResolverBuilder()
                );

        services.forEach(builder::withOperationsFromSingleton);

        return builder
                .withValueMapperFactory(new JacksonValueMapperFactory())
                .generate();
    }
}
