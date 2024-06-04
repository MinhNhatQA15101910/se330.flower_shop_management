package com.donhat.se330.flower_shop_management.frontend.models;

public class Occasion {
    private int id;
    private int category_id;
    private String name;
    private String image_url;

    public Occasion(int id, int category_id, String name, String image_url) {
        this.id = id;
        this.name = name;
        this.image_url = image_url;
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
