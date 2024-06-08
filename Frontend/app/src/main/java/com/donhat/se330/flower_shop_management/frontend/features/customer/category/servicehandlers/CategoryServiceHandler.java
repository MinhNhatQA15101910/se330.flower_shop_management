package com.donhat.se330.flower_shop_management.frontend.features.customer.category.servicehandlers;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.donhat.se330.flower_shop_management.frontend.constants.retrofit.RetrofitClient;
import com.donhat.se330.flower_shop_management.frontend.constants.utils.ErrorHandling;
import com.donhat.se330.flower_shop_management.frontend.features.customer.category.services.CategoryService;
import com.donhat.se330.flower_shop_management.frontend.features.customer.category.viewmodels.CategoryViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Category;
import com.donhat.se330.flower_shop_management.frontend.models.Occasion;
import com.donhat.se330.flower_shop_management.frontend.models.Type;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryServiceHandler {
    private final Context _context;
    private final CategoryService _categoryService;
    private final CategoryViewModel _categoryViewModel;

    public CategoryServiceHandler(Context context, CategoryViewModel categoryViewModel) {
        _categoryService = RetrofitClient.getRetrofitInstance().create(CategoryService.class);
        _context = context;
        _categoryViewModel = categoryViewModel;
    }

    public void getCategoryList() {
        Call<List<Category>> call = _categoryService.getCategoryList("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwiaWF0IjoxNzE3NTA0NjI2fQ.GHA1UZ_KxE0u3XfYExYX6UICojuuxr6GIjJQlmxyx3U");
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(@NonNull Call<List<Category>> call, @NonNull Response<List<Category>> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> {
                    List<Category> categoryList = response.body();
                    if (categoryList != null) {
                        _categoryViewModel.getCategoryList().setValue(categoryList);
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<List<Category>> call, @NonNull Throwable throwable) {
                Toast.makeText(_context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getTypeList() {
        Call<List<Type>> call = _categoryService.getTypeList("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwiaWF0IjoxNzE3NTA0NjI2fQ.GHA1UZ_KxE0u3XfYExYX6UICojuuxr6GIjJQlmxyx3U");
        call.enqueue(new Callback<List<Type>>() {
            @Override
            public void onResponse(@NonNull Call<List<Type>> call, @NonNull Response<List<Type>> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> {
                    List<Type> typeList = response.body();
                    if (typeList != null) {
                        _categoryViewModel.getTypeList().setValue(typeList);
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<List<Type>> call, @NonNull Throwable throwable) {
                Toast.makeText(_context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getOccasionList() {
        Call<List<Occasion>> call = _categoryService.getOccasionList("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwiaWF0IjoxNzE3NTA0NjI2fQ.GHA1UZ_KxE0u3XfYExYX6UICojuuxr6GIjJQlmxyx3U");
        call.enqueue(new Callback<List<Occasion>>() {
            @Override
            public void onResponse(@NonNull Call<List<Occasion>> call, @NonNull Response<List<Occasion>> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> {
                    List<Occasion> occasionList = response.body();
                    if (occasionList != null) {
                        _categoryViewModel.getOccasionList().setValue(occasionList);
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<List<Occasion>> call, @NonNull Throwable throwable) {
                Toast.makeText(_context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
