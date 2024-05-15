package com.se330.flower_shop_management.backend.controller;

import com.se330.flower_shop_management.backend.dto.UserDto;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/what")
    public ResponseEntity<?> helloWorld() throws MessagingException {
        return ResponseEntity.ok("Success.");
    }
}
