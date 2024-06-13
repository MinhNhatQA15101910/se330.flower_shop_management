package com.se330.flower_shop_management.backend.repository;

import com.se330.flower_shop_management.backend.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
    List<Type> findByCategoryId(Long categoryId);
}
