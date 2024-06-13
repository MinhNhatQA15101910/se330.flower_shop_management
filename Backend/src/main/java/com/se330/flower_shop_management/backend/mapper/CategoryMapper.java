package com.se330.flower_shop_management.backend.mapper;

import com.se330.flower_shop_management.backend.dto.CategoryDto;
import com.se330.flower_shop_management.backend.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryDto toDto(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        dto.setImageUrl(category.getImageUrl());

        return dto;
    }

    public Category toEntity(CategoryDto dto) {
        Category category = new Category();
        category.setId(dto.getId());
        category.setName(dto.getName());
        category.setImageUrl(dto.getImageUrl());

        return category;
    }
}
