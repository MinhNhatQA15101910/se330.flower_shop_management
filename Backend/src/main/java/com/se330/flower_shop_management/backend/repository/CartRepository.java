package com.se330.flower_shop_management.backend.repository;

import com.se330.flower_shop_management.backend.entity.Cart;
import com.se330.flower_shop_management.backend.entity.IDS.CartId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, CartId> {
    List<Cart> findByUserId(Long userId);
}