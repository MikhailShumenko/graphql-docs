package com.graphqldocs.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Imitates the main WKDA Security filter
 */
@Slf4j
@RequiredArgsConstructor
@Component
@WebFilter
public class SecurityFilter extends OncePerRequestFilter {

    private static final String AUTH_HEADER_NAME = "WkdaAuthorization";
    private static final String AUTH_VALUE = "auth_me";

    private final AuthContext authContext;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws IOException, ServletException {

        authContext.setAuthorized(AUTH_VALUE.equals(request.getHeader(AUTH_HEADER_NAME)));

        filterChain.doFilter(request, response);
    }
}
