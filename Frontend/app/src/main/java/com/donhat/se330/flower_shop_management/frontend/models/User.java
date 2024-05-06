package com.donhat.se330.flower_shop_management.frontend.models;

import java.util.HashMap;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String imageUrl;
    private String role;
    private String token;
    private List<Product> products;
    private List<Integer> quantities;

    public User(int id, String username, String email, String password, String imageUrl, String role, String token, List<Product> products, List<Integer> quantities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.imageUrl = imageUrl;
        this.role = role;
        this.token = token;
        this.products = products;
        this.quantities = quantities;
    }

    HashMap<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("username", username);
        map.put("email", email);
        map.put("password", password);
        map.put("image_url", imageUrl);
        map.put("role", role);
        map.put("token", token);
        map.put("products", products.stream().map((p) -> p.toMap()).toList());
        map.put("quantities", quantities);
        return map;
    }
}
