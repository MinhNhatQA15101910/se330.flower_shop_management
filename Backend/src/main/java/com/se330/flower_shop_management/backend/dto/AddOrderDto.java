package com.se330.flower_shop_management.backend.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderDto {

    @SerializedName("product_id")
    private Long productId;

    @SerializedName("total_price")
    private String totalPrice;

    @SerializedName("product_price")
    private String productPrice;

    @SerializedName("shipping_price")
    private String shippingPrice;

    private String status;

    @SerializedName("estimated_receive_date")
    private Timestamp estimatedReceiveDate;

    @SerializedName("order_date")
    private Timestamp orderDate;

    @SerializedName("in_delivery_date")
    private Timestamp inDeliveryDate;

    @SerializedName("receive_date")
    private Timestamp receiveDate;

    private String province;
    private String district;
    private String ward;

    @SerializedName("detail_address")
    private String detailAddress;

    @SerializedName("receiver_name")
    private String receiverName;

    @SerializedName("receiver_phone_number")
    private String receiverPhoneNumber;
}