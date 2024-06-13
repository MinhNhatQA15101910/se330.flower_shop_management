package com.se330.flower_shop_management.backend.controller;

import com.se330.flower_shop_management.backend.dto.TypeDTO;
import com.se330.flower_shop_management.backend.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("/customer/types")
    public ResponseEntity<List<TypeDTO>> getTypes(@RequestParam(required = false) Long category_id) {
        try {
            List<TypeDTO> types;
            if (category_id != null) {
                types = typeService.getTypesByCategoryId(category_id);
            } else {
                types = typeService.getAllTypes();
            }
            return new ResponseEntity<>(types, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
