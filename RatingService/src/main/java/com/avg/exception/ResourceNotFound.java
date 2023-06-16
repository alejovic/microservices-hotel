package com.avg.exception;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound() {
        this("Resource not found!!");
    }

    public ResourceNotFound(String message) {
        super(message);
    }

}
