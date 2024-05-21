package com.donhat.se330.flower_shop_management.frontend.features.customer.cart.entities;

public class ProductCart {
    private int id;
    private String productName;
    private String imgURL;
    private double price;
    private int quantity;

    // Constructors
    public ProductCart() {
    }

    public ProductCart(int id, String productName, String imgURL, double price, int quantity) {
        this.id = id;
        this.productName = productName;
        this.imgURL = imgURL;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
