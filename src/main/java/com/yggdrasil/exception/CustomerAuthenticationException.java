package com.yggdrasil.exception;

import org.springframework.security.core.AuthenticationException;

public class CustomerAuthenticationException extends AuthenticationException {
    public CustomerAuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }
}
