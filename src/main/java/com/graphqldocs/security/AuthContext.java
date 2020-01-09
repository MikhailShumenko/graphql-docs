package com.graphqldocs.security;

import org.springframework.stereotype.Component;


/**
 * Imitates WKDA AuthContext
 */
@Component
public class AuthContext {

    private static final ThreadLocal<Boolean> IS_AUTHORIZED = new InheritableThreadLocal<>();

    public boolean isAuthorized() {
        return IS_AUTHORIZED.get();
    }

    public void setAuthorized(boolean value) {
        IS_AUTHORIZED.set(value);
    }
}
