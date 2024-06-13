package com.se330.flower_shop_management.backend.controller;

import com.se330.flower_shop_management.backend.dto.AddOrderDto;
import com.se330.flower_shop_management.backend.dto.OrderResponseDto;
import com.se330.flower_shop_management.backend.entity.Order;
import com.se330.flower_shop_management.backend.service.OrderService;
import com.se330.flower_shop_management.backend.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/customer/orders")
    public ResponseEntity<?> getAllOrders() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(orderService.getAllOrders());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JsonResponse(e.getMessage()));
        }
    }

    @GetMapping("/customer/orders/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable("id") Long id) {
        try {
            Order order = orderService.getOrderById(id);
            return ResponseEntity.status(HttpStatus.OK).body(order);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JsonResponse(e.getMessage()));
        }
    }

    @PostMapping("/customer/create-order-from-cart")
    public ResponseEntity<?> createOrderFromCart(@RequestHeader("x-auth-token") String token, @RequestBody AddOrderDto addOrderDto) {
        try {
            OrderResponseDto orderResponseDto= orderService.createOrder(addOrderDto, token);
            return ResponseEntity.status(HttpStatus.OK).body(orderResponseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JsonResponse(e.getMessage()));
        }
    }

    @PostMapping("/customer/create-order-from-product")
    public ResponseEntity<?> createOrderFromProduct(@RequestHeader("x-auth-token") String token, @RequestBody AddOrderDto addOrderDto) {
        try {
            OrderResponseDto orderResponseDto= orderService.createOrder(addOrderDto, token);
            return ResponseEntity.status(HttpStatus.OK).body(orderResponseDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JsonResponse(e.getMessage()));
        }
    }
}
