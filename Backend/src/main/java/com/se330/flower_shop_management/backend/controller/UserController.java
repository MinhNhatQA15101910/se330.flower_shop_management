package com.se330.flower_shop_management.backend.controller;

import com.se330.flower_shop_management.backend.dto.*;
import com.se330.flower_shop_management.backend.entity.User;
import com.se330.flower_shop_management.backend.exception.UserEmailExistsException;
import com.se330.flower_shop_management.backend.exception.UserNotFoundException;
import com.se330.flower_shop_management.backend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Validated @RequestBody SignupRequestDto signupRequestDto) {
        try {
            User user = userService.signup(signupRequestDto);
            return ResponseEntity.ok(user);
        } catch (UserEmailExistsException e) {
            return ResponseEntity.badRequest().body(new ErrorMessage(e.getMessage()));
        }
    }

    @PostMapping("/login")
    public HttpEntity<UserResponseDto> login(@Validated @RequestBody LoginRequestDto loginRequestDto) {
        try {
            UserResponseDto userWithToken = userService.login(loginRequestDto);
            return ResponseEntity.ok(userWithToken);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login/google")
    public HttpEntity<UserResponseDto> loginGoogle(@Validated @RequestBody LoginGoogleRequestDto loginGoogleRequestDto) {
        try {
            UserResponseDto userWithToken = userService.loginGoogle(loginGoogleRequestDto);
            return ResponseEntity.ok(userWithToken);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/email-exists")
    public boolean emailExists(@Validated @RequestBody EmailDto emailDto) {
        try {
            return userService.checkExistsEmail(emailDto.getEmail());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/send-email")
    public ResponseEntity<?> sendEmail(@Validated @RequestBody SendEmailDto emailRequestDto) {
        try {
            userService.sendEmail(emailRequestDto.getEmail(), emailRequestDto.getPincode());
            return ResponseEntity.ok().body(Collections.singletonMap("msg", "Email sent successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("msg", e.getMessage()));
        }
    }

    @PatchMapping("/change-password")
    public User changePassword(@Validated @RequestBody ChangePasswordDto changePasswordDto) {
        try {
            return userService.changePassword(changePasswordDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<Map<String, Object>> getUser(@RequestHeader("x-auth-token") String token) {
        try {
            Map<String, Object> userData = userService.getUserData(token);
            return ResponseEntity.ok(userData);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
        }
    }

    @Setter
    @Getter
    @AllArgsConstructor
    private static class ErrorMessage {
        private String msg;
    }
}
