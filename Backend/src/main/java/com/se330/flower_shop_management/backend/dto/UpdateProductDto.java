package com.se330.flower_shop_management.backend.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductDto {
    @SerializedName("name")
    private String name;

    @SerializedName("price")
    private String price;

    @SerializedName("sale_price")
    private String salePrice;

    @SerializedName("sale_percentage")
    private String salePercentage;

    @SerializedName("detail_description")
    private String detailDescription;

    @SerializedName("size")
    private String size;

    @SerializedName("weight")
    private String weight;

    @SerializedName("color")
    private String color;

    @SerializedName("material")
    private String material;

    @SerializedName("stock")
    private Integer stock;

    @SerializedName("is_available")
    private Boolean isAvailable;
}
