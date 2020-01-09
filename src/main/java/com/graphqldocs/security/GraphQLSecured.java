package com.graphqldocs.security;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Imitates WKDA GraphQLSecured annotation
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface GraphQLSecured {
}
