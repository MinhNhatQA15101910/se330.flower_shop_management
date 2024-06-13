package com.se330.flower_shop_management.backend.controller;

import com.se330.flower_shop_management.backend.dto.AddToCartRequestDto;
import com.se330.flower_shop_management.backend.dto.UserResponseDto;
import com.se330.flower_shop_management.backend.service.CartService;
import com.se330.flower_shop_management.backend.service.JwtService;
import com.se330.flower_shop_management.backend.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/customer/add-to-cart")
    public ResponseEntity<?> addToCart(@RequestHeader("x-auth-token") String token, @RequestBody AddToCartRequestDto addToCartRequestDto) {
        try {
            Long userId = jwtService.extractUserId(token);
            UserResponseDto userResponseDto = cartService.addToCart(addToCartRequestDto.getProductId(), userId, token);
            return ResponseEntity.ok(userResponseDto);
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @DeleteMapping("/customer/remove-from-cart/{product_id}")
    public ResponseEntity<?> deleteProductInCart(@RequestHeader("x-auth-token") String token, @PathVariable("product_id") Long productId) {
        try {
            UserResponseDto userResponseDto = cartService.removeFromCart(productId, token);
            return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JsonResponse(e.getMessage()));
        }
    }
}
