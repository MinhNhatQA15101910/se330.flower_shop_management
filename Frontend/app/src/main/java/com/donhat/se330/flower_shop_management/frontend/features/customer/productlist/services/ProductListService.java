package com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.services;

import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ProductListService {
    @GET("customer/deals-of-day/all")
    Call<List<Product>> getDoDProducts(@Header("x-auth-token") String authToken);
}
