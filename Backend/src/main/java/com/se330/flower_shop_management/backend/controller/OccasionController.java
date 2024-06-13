package com.se330.flower_shop_management.backend.controller;

import com.se330.flower_shop_management.backend.entity.Occasion;
import com.se330.flower_shop_management.backend.service.OccasionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class OccasionController {

    @Autowired
    private OccasionService occasionService;

    @GetMapping("/occasions")
    public ResponseEntity<List<Occasion>> getOccasions(@RequestParam(required = false) Long category_id) {
        if (category_id != null) {
            List<Occasion> occasions = occasionService.getOccasionsByCategoryId(category_id);
            return ResponseEntity.ok(occasions);
        } else {
            List<Occasion> occasions = occasionService.getAllOccasions();
            return ResponseEntity.ok(occasions);
        }
    }
}
