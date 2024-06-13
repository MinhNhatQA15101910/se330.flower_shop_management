package com.se330.flower_shop_management.backend.service;

import com.se330.flower_shop_management.backend.dto.TypeDTO;
import com.se330.flower_shop_management.backend.entity.Type;
import com.se330.flower_shop_management.backend.mapper.TypeMapper;
import com.se330.flower_shop_management.backend.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private TypeMapper typeMapper;

    public List<TypeDTO> getAllTypes() {
        List<Type> types = typeRepository.findAll();
        return types
                .stream()
                .map(type -> new TypeDTO())
                .collect(Collectors.toList());
    }

    public List<TypeDTO> getTypesByCategoryId(Long categoryId) {
        return typeRepository.findByCategoryId(categoryId).stream()
                .map(typeMapper::toDto)
                .collect(Collectors.toList());
    }
}
