package com.example.endpoint.exceptions;

public class IncrementServiceException extends RuntimeException {
    public IncrementServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
