package com.se330.flower_shop_management.backend.mapper;

import com.se330.flower_shop_management.backend.dto.ProductDto;
import com.se330.flower_shop_management.backend.entity.Product;

import java.util.List;

public class ProductMapper {
    public static ProductDto toDto(Product product, List<String> imageUrls) {
        ProductDto dto = new ProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setSalePrice(product.getSalePrice());
        dto.setSalePercentage(product.getSalePercentage());
        dto.setDetailDescription(product.getDetailDescription());
        dto.setSize(product.getSize());
        dto.setWeight(product.getWeight());
        dto.setColor(product.getColor());
        dto.setMaterial(product.getMaterial());
        dto.setStock(product.getStock());
        dto.setSold(product.getSold());
        dto.setRatingAvg(product.getRatingAvg());
        dto.setTotalRating(product.getTotalRating());
        dto.setIsAvailable(product.getIsAvailable());
        dto.setImageUrls(imageUrls);
        return dto;
    }
}
