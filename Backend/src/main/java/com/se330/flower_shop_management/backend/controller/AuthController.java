package com.se330.flower_shop_management.backend.controller;

import com.se330.flower_shop_management.backend.service.JwtService;
import com.se330.flower_shop_management.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserService userService;

    @PostMapping("/tokenIsValid")
    public boolean isTokenValid(@RequestHeader("x-auth-token") String token) {
        try {
            return  jwtService.isValid(token, userService.loadUserByEmail(jwtService.extractUserEmail(token)));
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
