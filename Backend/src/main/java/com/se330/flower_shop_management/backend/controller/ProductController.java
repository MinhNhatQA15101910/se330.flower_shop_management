package com.se330.flower_shop_management.backend.controller;

import com.se330.flower_shop_management.backend.dto.ProductDto;
import com.se330.flower_shop_management.backend.dto.RecommendedProductsDto;
import com.se330.flower_shop_management.backend.entity.Product;
import com.se330.flower_shop_management.backend.entity.ProductImage;
import com.se330.flower_shop_management.backend.service.ProductService;
import com.se330.flower_shop_management.backend.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/customer/products/all")
    public ResponseEntity<List<ProductDto>> getAllProductsNoPage() {
        try {
            return ResponseEntity.ok(productService.getAllProductsNoPage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/customer/products")
    public ResponseEntity<RecommendedProductsDto> getAllProducts() {
        try {
            return ResponseEntity.ok(productService.getAllProducts());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/customer/products/{id}")
    public ResponseEntity<?> getProductDetail(@PathVariable("id") Long id) {
        try {
            ProductDto product = productService.getProductById(id);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JsonResponse("Failed to delete product as" + e.getMessage()));
        }
    }
}
