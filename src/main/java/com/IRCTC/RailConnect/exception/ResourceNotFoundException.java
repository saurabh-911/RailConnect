package com.IRCTC.RailConnect.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        System.out.println("Resource not found");
    }
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
