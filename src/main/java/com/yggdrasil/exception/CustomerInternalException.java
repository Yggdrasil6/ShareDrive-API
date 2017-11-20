package com.yggdrasil.exception;

public class CustomerInternalException extends RuntimeException {
    public CustomerInternalException() {
        super("内部异常");
    }

    public CustomerInternalException(String message) {
        super("message");
    }
}
