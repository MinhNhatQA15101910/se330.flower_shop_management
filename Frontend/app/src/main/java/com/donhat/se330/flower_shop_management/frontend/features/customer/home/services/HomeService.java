package com.donhat.se330.flower_shop_management.frontend.features.customer.home.services;

import com.donhat.se330.flower_shop_management.frontend.constants.responses.ProductListResponse;
import com.donhat.se330.flower_shop_management.frontend.models.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface HomeService {
    @GET("customer/recommended-products")
    Call<ProductListResponse> getRecommendProducts(@Header("x-auth-token") String authToken);

    @GET("customer/deal-of-the-day")
    Call<ProductListResponse> getDoDProducts(@Header("x-auth-token") String authToken);

    @GET("/customer/categories")
    Call<List<Category>> getCategoryList(@Header("x-auth-token") String token);
}
