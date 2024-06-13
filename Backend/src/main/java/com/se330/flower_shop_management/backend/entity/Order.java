package com.se330.flower_shop_management.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "total_price")
    private String totalPrice;

    @Column(name = "product_price")
    private String productPrice;

    @Column(name = "shipping_price")
    private String shippingPrice;

    @Column(name = "status")
    private String status;

    @Column(name = "estimated_receive_date")
    private Timestamp estimatedReceiveDate;

    @Column(name = "order_date")
    private Timestamp orderDate;

    @Column(name = "in_delivery_date")
    private Timestamp inDeliveryDate;

    @Column(name = "receive_date")
    private Timestamp receiveDate;

    @Column(name = "province")
    private String province;

    @Column(name = "district")
    private String district;

    @Column(name = "ward")
    private String ward;

    @Column(name = "detail_address")
    private String detailAddress;

    @Column(name = "receiver_name")
    private String receiverName;

    @Column(name = "receiver_phone_number")
    private String receiverPhoneNumber;
}
