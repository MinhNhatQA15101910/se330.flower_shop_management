package com.donhat.se330.flower_shop_management.frontend.models;

import com.google.gson.annotations.SerializedName;

public class Type {
    private int id;
    private String name;
    @SerializedName("image_url")
    private String imageUrl;

    public Type() {
        id = 0;
        name = "";
        imageUrl = "";
    }

    public Type(int id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
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
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
