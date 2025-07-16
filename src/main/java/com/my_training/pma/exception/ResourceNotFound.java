package com.my_training.pma.exception;

public class ResourceNotFound  extends RuntimeException{
    public ResourceNotFound(String message) {
        super(message);
    }
}
