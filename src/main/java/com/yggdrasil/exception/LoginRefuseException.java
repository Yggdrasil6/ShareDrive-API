package com.yggdrasil.exception;

public class LoginRefuseException extends RuntimeException {
    public LoginRefuseException(String message) {
        super(message);
    }
}
