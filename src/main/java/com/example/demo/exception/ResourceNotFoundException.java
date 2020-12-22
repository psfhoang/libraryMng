package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Long resourceId) {
        super("Could not find resource with resourceId= " + resourceId);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(Long resourceId, String message) {
        super("Could not find resource with resourceId= " + resourceId + ", Message=" + message);
    }

}
