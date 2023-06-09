package com.avg.exception;

import com.avg.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public class ResourceNotFound extends RuntimeException {

    public ResourceNotFound() {
        this("Resource not found!!");
    }

    public ResourceNotFound(String message) {
        super(message);
    }

}
