package com.se330.flower_shop_management.backend.controller;

import com.se330.flower_shop_management.backend.dto.RecommendedProductsDto;
import com.se330.flower_shop_management.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/customer/recommended-products")
    public ResponseEntity<RecommendedProductsDto> getALlRecommendedProducts() {
        try {
            RecommendedProductsDto response = productService.getAllRecommendedProducts();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
