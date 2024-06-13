package com.se330.flower_shop_management.backend.repository;

import com.se330.flower_shop_management.backend.entity.Occasion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OccasionRepository extends JpaRepository<Occasion, Long> {
    List<Occasion> findByCategoryId(Long categoryId);
}