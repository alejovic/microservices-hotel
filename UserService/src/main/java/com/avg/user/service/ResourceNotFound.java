package com.avg.user.service;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound() {
        this("Resource not found!!");
    }

    public ResourceNotFound(String message) {
        super(message);
    }
}
