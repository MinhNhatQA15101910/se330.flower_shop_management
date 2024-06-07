package com.se330.flower_shop_management.backend.entity;

import com.se330.flower_shop_management.backend.entity.IDS.ProductImageId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_images")
@IdClass(ProductImageId.class)
public class ProductImage {

    @Id
    @Column(name = "product_id")
    private Long productId;

    @Id
    @Column(name = "image_url")
    private String imageUrl;
}
