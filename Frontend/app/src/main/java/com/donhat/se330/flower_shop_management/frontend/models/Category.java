package com.donhat.se330.flower_shop_management.frontend.models;

public class Category {
    private int id;
    private String name;
    private String image_url;

    public Category() {
    }

    public Category(int id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.image_url = image_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String imageUrl) {
        this.image_url = imageUrl;
    }
}
