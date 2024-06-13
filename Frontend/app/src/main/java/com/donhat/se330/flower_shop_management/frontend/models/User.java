package com.donhat.se330.flower_shop_management.frontend.models;

import androidx.lifecycle.MutableLiveData;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    @SerializedName("image_url")
    private String imageUrl;
    private String role;
    private String token;
    private List<Product> products;
    private final MutableLiveData<String> _title = new MutableLiveData<>();
    private List<Integer> quantities;

    public User() {
        id = 0;
        username = "";
        email = "";
        password = "";
        imageUrl = "";
        role = "";
        token = "";
        products = new ArrayList<>();
        quantities = new ArrayList<>();
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<Integer> quantities) {
        this.quantities = quantities;
    }
}
