package com.donhat.se330.flower_shop_management.frontend.models;


public class Product {

    private String name;
    private float ratingAvg;
    private String ratingCount;
    private String price;
    //private String imageUrl;

    public Product(String name, float ratingAvg, String ratingCount, String price) {
        this.name = name;
        this.ratingAvg = ratingAvg;
        this.ratingCount = ratingCount;
        this.price = price;
        //this.imageUrl = imageUrl;
    }
    public String getName() {
        return name;
    }

    public float getRatingAvg() {
        return ratingAvg;
    }

    public String getRatingCount() {
        return ratingCount;
    }

    public String getPrice() {
        return price;
    }

    /*public String getImageUrl() {
        return imageUrl;
    }*/
}