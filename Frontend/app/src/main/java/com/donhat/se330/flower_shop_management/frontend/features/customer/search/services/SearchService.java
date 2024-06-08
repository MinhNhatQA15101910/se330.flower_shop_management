package com.donhat.se330.flower_shop_management.frontend.features.customer.search.services;

import com.donhat.se330.flower_shop_management.frontend.constants.responses.ProductListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface SearchService {
    @GET("customer/products")
    Call<ProductListResponse> getAllProducts(@Header("x-auth-token") String authToken);
}
