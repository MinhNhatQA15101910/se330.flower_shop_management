package com.se330.flower_shop_management.backend.entity.IDS;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductImageId implements Serializable {

    private Long productId;

    private String imageUrl;

    @Override
    public int hashCode() {
        return Objects.hash(productId, imageUrl);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ProductImageId that = (ProductImageId) obj;
        return Objects.equals(productId, that.productId) && Objects.equals(imageUrl, that.imageUrl);
    }
}
