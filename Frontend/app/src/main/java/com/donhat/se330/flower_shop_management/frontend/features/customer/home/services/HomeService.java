package com.donhat.se330.flower_shop_management.frontend.features.customer.home.services;

import com.donhat.se330.flower_shop_management.frontend.models.Category;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface HomeService {
    @GET("customer/recommended-products/all")
    Call<List<Product>> getRecommendProducts(@Header("x-auth-token") String authToken);

    @GET("customer/deals-of-day/all")
    Call<List<Product>> getDoDProducts(@Header("x-auth-token") String authToken);

    @GET("/customer/categories")
    Call<List<Category>> getCategoryList(@Header("x-auth-token") String token);
}
