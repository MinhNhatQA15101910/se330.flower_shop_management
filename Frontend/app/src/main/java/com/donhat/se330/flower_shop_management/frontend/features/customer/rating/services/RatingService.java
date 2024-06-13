package com.donhat.se330.flower_shop_management.frontend.features.customer.rating.services;

import com.donhat.se330.flower_shop_management.frontend.models.Product;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface RatingService {
    @GET("customer/products/{product_id}")
    Call<Product> getProductFromId(@Header("x-auth-token") String authToken, @Path("product_id") int productId);
}
