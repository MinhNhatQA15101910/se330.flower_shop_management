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
    @SerializedName(value = "category_id")
    private Long categoryId;
    private String name;
    @SerializedName(value = "image_url")
    private String imageUrl;
    private String description;
}