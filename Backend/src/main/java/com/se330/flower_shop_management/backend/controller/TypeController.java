package com.se330.flower_shop_management.backend.controller;

import com.se330.flower_shop_management.backend.dto.TypeDTO;
import com.se330.flower_shop_management.backend.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("/customer/types")
    public ResponseEntity<List<TypeDTO>> getAllTypes() {
        try {
            List<TypeDTO> types = typeService.getAllTypes();
            return new ResponseEntity<>(types, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
