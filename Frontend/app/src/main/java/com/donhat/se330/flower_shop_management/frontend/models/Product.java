package com.donhat.se330.flower_shop_management.frontend.models;

import com.donhat.se330.flower_shop_management.frontend.constants.enums.Size;

import java.util.List;

public class Product {
    private int id;
    private String name;
    private double price;
    private double salePrice;
    private double salePercentage;
    private String detailDescription;
    private Size size;
    private float weight;
    private String color;
    private String material;
    private int stock;
    private int sold;
    private float ratingAvg;
    private int totalRating;
    private List<String> imageUrls;

    public Product() {
    }

    public Product(int id, String name, double price, double salePrice, double salePercentage, String detailDescription, Size size, float weight, String color, String material, int stock, int sold, float ratingAvg, int totalRating, List<String> imageUrls) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.salePrice = salePrice;
        this.salePercentage = salePercentage;
        this.detailDescription = detailDescription;
        this.size = size;
        this.weight = weight;
        this.color = color;
        this.material = material;
        this.stock = stock;
        this.sold = sold;
        this.ratingAvg = ratingAvg;
        this.totalRating = totalRating;
        this.imageUrls = imageUrls;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getSalePercentage() {
        return salePercentage;
    }

    public void setSalePercentage(double salePercentage) {
        this.salePercentage = salePercentage;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public float getRatingAvg() {
        return ratingAvg;
    }

    public void setRatingAvg(float ratingAvg) {
        this.ratingAvg = ratingAvg;
    }

    public int getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(int totalRating) {
        this.totalRating = totalRating;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
}
