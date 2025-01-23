package com.brasileirao.championship.Services.Exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
