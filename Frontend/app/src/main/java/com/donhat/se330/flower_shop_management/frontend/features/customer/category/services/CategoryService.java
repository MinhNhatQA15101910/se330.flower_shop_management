package com.donhat.se330.flower_shop_management.frontend.features.customer.category.services;

import com.donhat.se330.flower_shop_management.frontend.models.Category;
import com.donhat.se330.flower_shop_management.frontend.models.Occasion;
import com.donhat.se330.flower_shop_management.frontend.models.Type;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface CategoryService {
    @GET("/customer/categories")
    Call<List<Category>> getCategoryList(@Header("x-auth-token") String token);
    @GET("/customer/types")
    Call<List<Type>> getTypeList(@Header("x-auth-token") String token);
    @GET("/customer/occasions")
    Call<List<Occasion>> getOccasionList(@Header("x-auth-token") String token);
}
