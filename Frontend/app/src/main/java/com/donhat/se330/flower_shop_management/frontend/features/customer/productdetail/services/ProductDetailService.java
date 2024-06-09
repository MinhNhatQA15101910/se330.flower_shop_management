package com.donhat.se330.flower_shop_management.frontend.features.customer.productdetail.services;

import com.donhat.se330.flower_shop_management.frontend.constants.responses.ProductListResponse;
import com.donhat.se330.flower_shop_management.frontend.models.Product;
import com.donhat.se330.flower_shop_management.frontend.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ProductDetailService {
    @POST("/customer/add-to-cart")
    Call<User> addToCart(@Header("x-auth-token") String token, @Body Object addToCartRequestBody);
    @GET("customer/products/{product_id}")
    Call<Product> getProductFromId(@Header("x-auth-token") String authToken, @Path("product_id") int productId);

    @GET("customer/recommended-products")
    Call<ProductListResponse> getRecommendProducts(@Header("x-auth-token") String authToken);
}