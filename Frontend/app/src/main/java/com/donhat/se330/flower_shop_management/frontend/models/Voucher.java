package com.donhat.se330.flower_shop_management.frontend.models;

public class Voucher {
    int id;
    String codeNane;
    String percentage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeNane() {
        return codeNane;
    }

    public void setCodeNane(String codeNane) {
        this.codeNane = codeNane;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}
