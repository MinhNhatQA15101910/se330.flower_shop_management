package com.donhat.se330.flower_shop_management.frontend.features.customer.category.services;

import com.donhat.se330.flower_shop_management.frontend.models.Category;
import com.donhat.se330.flower_shop_management.frontend.models.Occasion;
import com.donhat.se330.flower_shop_management.frontend.models.Product;
import com.donhat.se330.flower_shop_management.frontend.models.Type;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface CategoryService {
    @GET("/customer/categories")
    Call<List<Category>> getCategoryList(@Header("x-auth-token") String token);

    @GET("/customer/types")
    Call<List<Type>> getComboTypeList(@Header("x-auth-token") String token, @Query("category_id") int categoryId);
    @GET("/customer/types")
    Call<List<Type>> getFlowerTypeList(@Header("x-auth-token") String token, @Query("category_id") int categoryId);
    @GET("/customer/types")
    Call<List<Type>> getCakeTypeList(@Header("x-auth-token") String token, @Query("category_id") int categoryId);
    @GET("/customer/occasions")
    Call<List<Occasion>> getComboOccasionList(@Header("x-auth-token") String token, @Query("category_id") int categoryId);
    @GET("/customer/occasions")
    Call<List<Occasion>> getFlowerOccasionList(@Header("x-auth-token") String token, @Query("category_id") int categoryId);
    @GET("/customer/occasions")
    Call<List<Occasion>> getCakeOccasionList(@Header("x-auth-token") String token, @Query("category_id") int categoryId);
    @GET("/customer/products")
    Call<List<Product>> getProductListType(@Header("x-auth-token") String token, @Body Object getProductListTypeOccasionRequest);
    @GET("/customer/products")
    Call<List<Product>> getProductListOccasion(@Header("x-auth-token") String token, @Body Object getProductListTypeOccasionRequest);
}
