package com.donhat.se330.flower_shop_management.frontend.features.customer.order.services;

import com.donhat.se330.flower_shop_management.frontend.models.Order;
import com.donhat.se330.flower_shop_management.frontend.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface OrderService {
    @GET("/customer/orders")
    Call<List<Order>> GetOrderByUser(@Header("x-auth-token") String token, @Query("user_id") int userId);

    @GET("/customer/orders")
    Call<List<Order>> GetOrderByUserSatus(@Header("x-auth-token") String token, @Query("user_id") int userId, @Query("status") String status);
}
