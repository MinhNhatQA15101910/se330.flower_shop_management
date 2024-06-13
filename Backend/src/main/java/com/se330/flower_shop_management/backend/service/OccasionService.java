package com.se330.flower_shop_management.backend.service;

import com.se330.flower_shop_management.backend.entity.Occasion;
import com.se330.flower_shop_management.backend.repository.OccasionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OccasionService {

    @Autowired
    private OccasionRepository occasionRepository;

    public List<Occasion> getAllOccasions() {
        return occasionRepository.findAll();
    }

    public List<Occasion> getOccasionsByCategoryId(Long categoryId) {
        return occasionRepository.findByCategoryId(categoryId);
    }
}