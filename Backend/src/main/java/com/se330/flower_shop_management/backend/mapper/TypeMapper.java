package com.se330.flower_shop_management.backend.mapper;

import com.se330.flower_shop_management.backend.dto.TypeDTO;
import com.se330.flower_shop_management.backend.entity.Category;
import com.se330.flower_shop_management.backend.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TypeMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    public TypeDTO toDto(Type type) {
        TypeDTO dto = new TypeDTO();
        dto.setId(type.getId());
        dto.setName(type.getName());
        dto.setImageUrl(type.getImageUrl());
        dto.setDescription(type.getDescription());

        if (type.getCategory() != null) {
            dto.setCategoryId(type.getCategory().getId());
            dto.setCategoryName(type.getCategory().getName());
        }

        return dto;
    }

    public Type toEntity(TypeDTO dto) {
        Type type = new Type();
        type.setId(dto.getId());
        type.setName(dto.getName());
        type.setImageUrl(dto.getImageUrl());
        type.setDescription(dto.getDescription());

        // Mapping category information
        Category category = new Category();
        category.setId(dto.getCategoryId());
        category.setName(dto.getCategoryName());
        type.setCategory(category);

        return type;
    }
}
