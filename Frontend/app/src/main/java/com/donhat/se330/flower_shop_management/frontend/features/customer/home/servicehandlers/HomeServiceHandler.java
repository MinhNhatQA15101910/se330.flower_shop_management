package com.donhat.se330.flower_shop_management.frontend.features.customer.home.servicehandlers;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.constants.responses.ProductListResponse;
import com.donhat.se330.flower_shop_management.frontend.constants.retrofit.RetrofitClient;
import com.donhat.se330.flower_shop_management.frontend.constants.utils.ErrorHandling;
import com.donhat.se330.flower_shop_management.frontend.features.customer.home.services.HomeService;
import com.donhat.se330.flower_shop_management.frontend.features.customer.home.viewmodels.HomeFragmentViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Category;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeServiceHandler {
    Context context;
    HomeService homeService;
    HomeFragmentViewModel homeFragmentViewModel;
    private final MutableLiveData<List<Product>> _productsList = new MutableLiveData<>();

    public HomeServiceHandler(Context context, HomeFragmentViewModel homeFragmentViewModel) {
        this.context = context;
        this.homeFragmentViewModel = homeFragmentViewModel;
        homeService = RetrofitClient.getRetrofitInstance().create(HomeService.class);
    }

    public MutableLiveData<List<Product>> getRecommendProducts() {
        String authToken = Objects.requireNonNull(GlobalVariables.getUser().getValue()).getToken();
        Call<ProductListResponse> call = homeService.getRecommendProducts(authToken);

        call.enqueue(new Callback<ProductListResponse>() {
            @Override
            public void onResponse(@NonNull Call<ProductListResponse> call, @NonNull Response<ProductListResponse> response) {
                ErrorHandling.httpErrorHandler(response, context, () -> {
                    ProductListResponse productListResponse = response.body();

                    if (productListResponse != null && productListResponse.getResults() != null) {
                        _productsList.setValue(productListResponse.getResults());
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<ProductListResponse> call, @NonNull Throwable throwable) {
                Toast.makeText(context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return _productsList;
    }

    public MutableLiveData<List<Product>> getDoDProducts() {
        String authToken = Objects.requireNonNull(GlobalVariables.getUser().getValue()).getToken();
        Call<ProductListResponse> call = homeService.getDoDProducts(authToken);

        call.enqueue(new Callback<ProductListResponse>() {
            @Override
            public void onResponse(@NonNull Call<ProductListResponse> call, @NonNull Response<ProductListResponse> response) {
                ErrorHandling.httpErrorHandler(response, context, () -> {
                    ProductListResponse productListResponse = response.body();

                    if (productListResponse != null && productListResponse.getResults() != null) {
                        _productsList.setValue(productListResponse.getResults());
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<ProductListResponse> call, @NonNull Throwable throwable) {
                Toast.makeText(context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return _productsList;
    }

    public void getCategoryList() {
        Call<List<Category>> call = homeService.getCategoryList(Objects.requireNonNull(GlobalVariables.getUser().getValue()).getToken());
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(@NonNull Call<List<Category>> call, @NonNull Response<List<Category>> response) {
                ErrorHandling.httpErrorHandler(response, context, () -> {
                    List<Category> categoryList = response.body();
                    if (categoryList != null) {
                        homeFragmentViewModel.getListCategories().setValue(categoryList);
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<List<Category>> call, @NonNull Throwable throwable) {
                Toast.makeText(context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
