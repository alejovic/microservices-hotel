package com.avg.exception;

public class ConstraintNotValid extends RuntimeException {

    public ConstraintNotValid() {
        this("Constraint Validation failed!!");
    }

    public ConstraintNotValid(String message) {
        super(message);
    }
}
