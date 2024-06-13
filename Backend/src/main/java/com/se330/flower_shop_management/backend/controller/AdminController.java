package com.se330.flower_shop_management.backend.controller;

import com.se330.flower_shop_management.backend.dto.AddProductDto;
import com.se330.flower_shop_management.backend.dto.DeleteProductDto;
import com.se330.flower_shop_management.backend.dto.TypeDTO;
import com.se330.flower_shop_management.backend.dto.UpdateProductDto;
import com.se330.flower_shop_management.backend.entity.Product;
import com.se330.flower_shop_management.backend.service.ProductService;
import com.se330.flower_shop_management.backend.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        try {
            List<Product> prods = productService.getAllProd();
            return new ResponseEntity<>(prods, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestBody AddProductDto addProductDto) {
        try {
            productService.addProduct(addProductDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Product created.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResponse(e.getMessage()));
        }
    }

    @PatchMapping("/products/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") Long id, @RequestBody UpdateProductDto updateProductDto) {
        try {
            productService.updateProduct(id, updateProductDto);
            return ResponseEntity.status(HttpStatus.OK).body("Product updated.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JsonResponse(e.getMessage()));
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<JsonResponse> deleteProduct(
            @PathVariable("id") Long id,
            @RequestBody DeleteProductDto deleteProductDto) {
        try {
            productService.deleteProduct(id, deleteProductDto);
            return ResponseEntity.ok(new JsonResponse("Product deleted successfully."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new JsonResponse("Failed to delete product as" + e.getMessage()));
        }
    }
}
