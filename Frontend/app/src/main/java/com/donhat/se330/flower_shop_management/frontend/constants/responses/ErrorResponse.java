package com.donhat.se330.flower_shop_management.frontend.constants.responses;

public class ErrorResponse {
    private final String error;

    public ErrorResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
