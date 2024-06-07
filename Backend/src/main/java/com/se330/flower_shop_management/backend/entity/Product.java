package com.se330.flower_shop_management.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Float price;

    @Column(name = "sale_price")
    private Float salePrice;

    @Column(name = "sale_percentage")
    private Float salePercentage;

    @Column(name = "detail_description")
    private String detailDescription;

    @Column(name = "size")
    private String size;

    @Column(name = "weight")
    private Float weight;

    @Column(name = "color")
    private String color;

    @Column(name = "material")
    private String material;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "sold")
    private Integer sold;

    @Column(name = "rating_avg")
    private Float ratingAvg;

    @Column(name = "total_rating")
    private Integer totalRating;

    @Column(name = "is_available")
    private Boolean isAvailable;
}
