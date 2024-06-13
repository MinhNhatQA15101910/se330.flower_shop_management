package com.se330.flower_shop_management.backend.exception;

public class UserEmailNotExistsException extends RuntimeException{
    public UserEmailNotExistsException(String message) {
        super(message);
    }
}
