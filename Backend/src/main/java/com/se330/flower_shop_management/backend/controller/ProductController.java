package com.se330.flower_shop_management.backend.controller;

import com.se330.flower_shop_management.backend.dto.RecommendedProductsDto;
import com.se330.flower_shop_management.backend.entity.Product;
import com.se330.flower_shop_management.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/customer/recommended-products")
    public ResponseEntity<RecommendedProductsDto> getALlRecommendedProducts() {
        try {
            return ResponseEntity.ok(productService.getAllRecommendedProducts());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
