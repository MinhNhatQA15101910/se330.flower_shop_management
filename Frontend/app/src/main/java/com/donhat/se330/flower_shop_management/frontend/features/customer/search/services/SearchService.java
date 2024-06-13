package com.donhat.se330.flower_shop_management.frontend.features.customer.search.services;

import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface SearchService {
    @GET("customer/products/all")
    Call<List<Product>> getAllProducts(@Header("x-auth-token") String authToken);
}
