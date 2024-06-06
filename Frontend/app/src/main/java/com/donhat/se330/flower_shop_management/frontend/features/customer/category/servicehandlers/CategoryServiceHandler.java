package com.donhat.se330.flower_shop_management.frontend.features.customer.category.servicehandlers;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.constants.retrofit.RetrofitClient;
import com.donhat.se330.flower_shop_management.frontend.constants.utils.ErrorHandling;
import com.donhat.se330.flower_shop_management.frontend.features.customer.category.services.CategoryService;
import com.donhat.se330.flower_shop_management.frontend.features.customer.category.viewmodels.CategoryViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Category;
import com.donhat.se330.flower_shop_management.frontend.models.Occasion;
import com.donhat.se330.flower_shop_management.frontend.models.Type;

import java.util.List;
import java.util.Objects;

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
        Call<List<Category>> call = _categoryService.getCategoryList(Objects.requireNonNull(GlobalVariables.getUser().getValue()).getToken());
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

    public void getComboTypeList() {
        Call<List<Type>> call = _categoryService.getComboTypeList(Objects.requireNonNull(GlobalVariables.getUser().getValue()).getToken(), 1);
        call.enqueue(new Callback<List<Type>>() {
            @Override
            public void onResponse(@NonNull Call<List<Type>> call, @NonNull Response<List<Type>> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> {
                    List<Type> typeList = response.body();
                    if (typeList != null) {
                        _categoryViewModel.getTypeComboList().setValue(typeList);
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<List<Type>> call, @NonNull Throwable throwable) {
                Toast.makeText(_context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getFlowerTypeList() {
        Call<List<Type>> call = _categoryService.getFlowerTypeList(Objects.requireNonNull(GlobalVariables.getUser().getValue()).getToken(), 2);
        call.enqueue(new Callback<List<Type>>() {
            @Override
            public void onResponse(@NonNull Call<List<Type>> call, @NonNull Response<List<Type>> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> {
                    List<Type> typeList = response.body();
                    if (typeList != null) {
                        _categoryViewModel.getTypeFlowerList().setValue(typeList);
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<List<Type>> call, @NonNull Throwable throwable) {
                Toast.makeText(_context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getCakeTypeList() {
        Call<List<Type>> call = _categoryService.getCakeTypeList(Objects.requireNonNull(GlobalVariables.getUser().getValue()).getToken(), 3);
        call.enqueue(new Callback<List<Type>>() {
            @Override
            public void onResponse(@NonNull Call<List<Type>> call, @NonNull Response<List<Type>> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> {
                    List<Type> typeList = response.body();
                    if (typeList != null) {
                        _categoryViewModel.getTypeCakeList().setValue(typeList);
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<List<Type>> call, @NonNull Throwable throwable) {
                Toast.makeText(_context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getComboOccasionList() {
        Call<List<Occasion>> call = _categoryService.getComboOccasionList(Objects.requireNonNull(GlobalVariables.getUser().getValue()).getToken(), 1);
        call.enqueue(new Callback<List<Occasion>>() {
            @Override
            public void onResponse(@NonNull Call<List<Occasion>> call, @NonNull Response<List<Occasion>> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> {
                    List<Occasion> occasionList = response.body();
                    if (occasionList != null) {
                        _categoryViewModel.getOccasionComboList().setValue(occasionList);
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<List<Occasion>> call, @NonNull Throwable throwable) {
                Toast.makeText(_context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getFlowerOccasionList() {
        Call<List<Occasion>> call = _categoryService.getFlowerOccasionList(Objects.requireNonNull(GlobalVariables.getUser().getValue()).getToken(), 2);
        call.enqueue(new Callback<List<Occasion>>() {
            @Override
            public void onResponse(@NonNull Call<List<Occasion>> call, @NonNull Response<List<Occasion>> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> {
                    List<Occasion> occasionList = response.body();
                    if (occasionList != null) {
                        _categoryViewModel.getOccasionFlowerList().setValue(occasionList);
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<List<Occasion>> call, @NonNull Throwable throwable) {
                Toast.makeText(_context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getCakeOccasionList() {
        Call<List<Occasion>> call = _categoryService.getCakeOccasionList(Objects.requireNonNull(GlobalVariables.getUser().getValue()).getToken(), 3);
        call.enqueue(new Callback<List<Occasion>>() {
            @Override
            public void onResponse(@NonNull Call<List<Occasion>> call, @NonNull Response<List<Occasion>> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> {
                    List<Occasion> occasionList = response.body();
                    if (occasionList != null) {
                        _categoryViewModel.getOccasionCakeList().setValue(occasionList);
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
