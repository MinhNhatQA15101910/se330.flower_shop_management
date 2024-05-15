package com.se330.flower_shop_management.backend.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException{
    public  ResourceNotFoundException(String message) {
        super(message);
    }
}
