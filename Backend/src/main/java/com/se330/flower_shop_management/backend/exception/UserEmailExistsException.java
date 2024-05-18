package com.se330.flower_shop_management.backend.exception;

public class UserEmailExistsException extends RuntimeException{
    public UserEmailExistsException(String message) {
        super(message);
    }
}
