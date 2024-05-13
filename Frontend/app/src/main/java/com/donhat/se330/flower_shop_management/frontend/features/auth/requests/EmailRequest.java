package com.donhat.se330.flower_shop_management.frontend.features.auth.requests;

public class EmailRequest {
    private String email;

    public EmailRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
