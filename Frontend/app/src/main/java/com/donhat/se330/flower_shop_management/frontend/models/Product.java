package com.donhat.se330.flower_shop_management.frontend.models;

import com.donhat.se330.flower_shop_management.frontend.constants.enums.Size;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int id;
    private String name;
    private String price;
    @SerializedName("sale_price")
    private String salePrice;
    @SerializedName("sale_percentage")
    private String salePercentage;
    @SerializedName("detail_description")
    private String detailDescription;
    private String size;
    private String weight;
    private String color;
    private String material;
    private int stock;
    private int sold;
    @SerializedName("rating_avg")
    private String ratingAvg;
    @SerializedName("total_rating")
    private int totalRating;
    @SerializedName("image_urls")
    private List<String> imageUrls;

    public Product() {
        id = 0;
        name = "";
        price = "0";
        salePrice = "0";
        salePercentage = "0";
        detailDescription = "";
        size = "Standard";
        weight = "0";
        color = "";
        material = "";
        stock = 0;
        sold = 0;
        ratingAvg = "0";
        totalRating = 0;
        imageUrls = new ArrayList<>();
    }

    public Product(int id, String name, String price, String salePrice, String salePercentage, String detailDescription, String size, String weight, String color, String material, int stock, int sold, String ratingAvg, int totalRating, List<String> imageUrls) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
    }

    public String getSalePercentage() {
        return salePercentage;
    }

    public void setSalePercentage(String salePercentage) {
        this.salePercentage = salePercentage;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
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

    public String getRatingAvg() {
        return ratingAvg;
    }

    public void setRatingAvg(String ratingAvg) {
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
