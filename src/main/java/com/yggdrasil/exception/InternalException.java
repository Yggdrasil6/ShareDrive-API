package com.yggdrasil.exception;

public class InternalException extends RuntimeException {
    public InternalException() {
        super("内部错误");
    }

    public InternalException(String message) {
        super("message");
    }
}
