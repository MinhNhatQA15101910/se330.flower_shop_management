package com.donhat.se330.flower_shop_management.frontend.features.customer.cart.services;

import com.donhat.se330.flower_shop_management.frontend.constants.responses.MsgResponse;
import com.donhat.se330.flower_shop_management.frontend.models.User;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface CartService {
    @POST("/customer/add-to-cart")
    Call<User> addToCart(@Header("x-auth-token") String token, @Body Object addToCartRequestBody);
    @DELETE("/customer/remove-from-cart/{product_id}")
    Call<User> removeFromCart(@Header("x-auth-token") String token, @Path("product_id") int productId);
    @DELETE("customer/delete-from-cart/{product_id}")
    Call<User> deleteFromCart(@Header("x-auth-token") String token, @Path("product_id") int productId);

}
