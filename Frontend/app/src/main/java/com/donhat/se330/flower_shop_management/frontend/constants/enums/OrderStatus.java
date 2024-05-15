package com.donhat.se330.flower_shop_management.frontend.constants.enums;

public enum OrderStatus {
    PENDING("Pending"), IN_DELIVERY("In Delivery"), RECEIVED("Received");

    private final String value;

    public String getValue() {
        return value;
    }

    private OrderStatus(String value) {
        this.value = value;
    }
}
