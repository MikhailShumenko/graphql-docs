package com.graphqldocs.interceptor;

import com.graphqldocs.security.AuthContext;
import com.graphqldocs.security.GraphQLSecured;
import com.graphqldocs.security.NotAuthorizedException;
import io.leangen.graphql.execution.InvocationContext;
import io.leangen.graphql.execution.ResolverInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;

@Slf4j
@RequiredArgsConstructor
@Component
class GQLAuthResolverInterceptor implements ResolverInterceptor {

    private final AuthContext authContext;

    @Override
    public Object aroundInvoke(InvocationContext context, Continuation continuation) throws Exception {
        GraphQLSecured secured = context.getResolver()
                .getExecutable()
                .getDelegate()
                .getAnnotation(GraphQLSecured.class);

        if (nonNull(secured) && !authContext.isAuthorized()) {
            throw new NotAuthorizedException();
        }

        return continuation.proceed(context);
    }
}
