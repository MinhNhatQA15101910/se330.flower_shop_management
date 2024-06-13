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
public class TypeDTO {
    private Long id;
    private String name;
    @SerializedName("image_url")
    private String imageUrl;
    private String description;

    @SerializedName("category_id")
    private Long categoryId;
    @SerializedName("category_name")
    private String categoryName;
    @SerializedName("category_description")
    private String categoryDescription;
}