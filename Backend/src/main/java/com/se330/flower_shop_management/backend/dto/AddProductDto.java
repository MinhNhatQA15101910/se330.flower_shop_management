package com.se330.flower_shop_management.backend.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductDto {
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
    private String material = "unknown";
    private Integer stock = 0;
    private Integer sold = 0;
    @SerializedName("rating_avg")
    private String ratingAvg = "0";
    @SerializedName("total_rating")
    private Integer totalRating = 0;
    @SerializedName("is_available")
    private Boolean isAvailable = true;
    @SerializedName("image_urls")
    private List<String> imageUrls = null;
}
