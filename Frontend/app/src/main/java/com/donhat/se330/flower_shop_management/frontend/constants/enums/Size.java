package com.donhat.se330.flower_shop_management.frontend.constants.enums;

public enum Size {
    SMALL("Small"), MEDIUM("Medium"), STANDARD("Standard"), LARGE("Large"), EXTRA_LARGE("Extra Large"), JUMBO("Jumbo");

    private final String value;

    public String getValue() {
        return value;
    }

    private Size(String value) {
        this.value = value;
    }
}
