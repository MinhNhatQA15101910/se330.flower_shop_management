package com.se330.flower_shop_management.backend.service;

import com.se330.flower_shop_management.backend.entity.Category;
import com.se330.flower_shop_management.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

}
