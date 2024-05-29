package com.donhat.se330.flower_shop_management.frontend.models;

public class Order {
    String Id;

    String ProductName;

    public Order(String id, String productName) {
        Id = id;
        ProductName = productName;
    }

    public String getId() {
        return Id;
    }

    public String getProductName() {
        return ProductName;
    }
}
