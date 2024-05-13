package com.donhat.se330.flower_shop_management.frontend.models;

import com.donhat.se330.flower_shop_management.frontend.constants.enums.Size;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Product {
    private final int id;
    private final String name;
    private final double price;
    private final double salePrice;
    private final double salePercentage;
    private final String detailDescription;
    private final Size size;
    private final float weight;
    private final String color;
    private final String material;
    private final int stock;
    private final int sold;
    private final float ratingAvg;
    private final int totalRating;
    private final List<String> imageUrls;

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

    Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("price", price);
        map.put("sale_price", salePrice);
        map.put("sale_percentage", salePercentage);
        map.put("detail_description", detailDescription);
        map.put("size", size.getValue());
        map.put("weight", weight);
        map.put("color", color);
        map.put("material", material);
        map.put("stock", stock);
        map.put("sold", sold);
        map.put("rating_avg", ratingAvg);
        map.put("total_rating", totalRating);
        map.put("image_urls", imageUrls);
        return map;
    }

    public static Product fromMap(Map<String, Object> map) {
        Size size = Size.STANDARD;
        for (Size s : Size.values()) {
            if (s.getValue().equals(map.get("size"))) {
                size = s;
            }
        }

        return new Product(
                map.get("id") != null ? (int) map.get("id") : 0,
                map.get("name") != null ? (String) map.get("name") : "",
                map.get("price") != null ? (double) map.get("price") : 0,
                map.get("sale_price") != null ? (double) map.get("sale_price") : 0,
                map.get("sale_percentage") != null ? (double) map.get("sale_percentage") : 0,
                map.get("detail_description") != null ? (String) map.get("detail_description") : "",
                size,
                map.get("weight") != null ? (float) map.get("weight") : 0,
                map.get("color") != null ? (String) map.get("color") : "",
                map.get("material") != null ? (String) map.get("material") : "",
                map.get("stock") != null ? (int) map.get("stock") : 0,
                map.get("sold") != null ? (int) map.get("sold") : 0,
                map.get("rating_avg") != null ? (float) map.get("rating_avg") : 0,
                map.get("total_rating") != null ? (int) map.get("total_rating") : 0,
                map.get("image_urls") != null ? (List<String>) map.get("image_urls") : new ArrayList<>()
                );
    }

    String toJson() {
        return (new JSONObject(toMap())).toString();
    }

    public static Product fromJson(String source) {
        Map<String, Object> map = new HashMap<>();

        try {
            JSONObject jsonObject = new JSONObject(source);
            Iterator<String> keys = jsonObject.keys();

            while (keys.hasNext()) {
                String key = keys.next();
                String value = jsonObject.getString(key);
                map.put(key, value);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return fromMap(map);
    }
}
