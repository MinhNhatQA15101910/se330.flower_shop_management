package com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.services;

import com.donhat.se330.flower_shop_management.frontend.models.Order;
import com.donhat.se330.flower_shop_management.frontend.models.Voucher;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface CheckoutService {
    @POST("/customer/create-order-from-cart")
    Call<Order> createOrderFromCart(@Header("x-auth-token") String token, @Body Object createOrderFromCartRequestBody);

    @GET("/vouchers")
    Call<List<Voucher>> getAllVouchers(@Header("x-auth-token") String token);
}
