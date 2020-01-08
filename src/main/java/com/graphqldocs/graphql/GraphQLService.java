package com.graphqldocs.graphql;

import io.leangen.graphql.GraphQLSchemaGenerator;

/**
 * Marker interface for all Graph QL services.
 * All beans marked with this annotation will bi registered in {@link GraphQLSchemaGenerator#withOperationsFromSingleton}
 */
public interface GraphQLService {
}
