package com.donhat.se330.flower_shop_management.frontend.features.customer.search.servicehandlers;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.constants.responses.ProductListResponse;
import com.donhat.se330.flower_shop_management.frontend.constants.retrofit.RetrofitClient;
import com.donhat.se330.flower_shop_management.frontend.constants.utils.ErrorHandling;
import com.donhat.se330.flower_shop_management.frontend.features.customer.search.services.SearchService;
import com.donhat.se330.flower_shop_management.frontend.features.customer.search.viewmodels.SearchFragmentViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchServiceHandler {
    Context context;
    SearchService searchService;
    SearchFragmentViewModel searchFragmentViewModel;
    private MutableLiveData<List<Product>> _productsList = new MutableLiveData<>();

    public SearchServiceHandler(Context context, SearchFragmentViewModel searchFragmentViewModel) {
        this.context = context;
        this.searchFragmentViewModel = searchFragmentViewModel;
        searchService = RetrofitClient.getRetrofitInstance().create(SearchService.class);
    }

    public MutableLiveData<List<Product>> getAllProducts() {
        String authToken = GlobalVariables.getUser().getValue().getToken();
        Call<ProductListResponse> call = searchService.getAllProducts(authToken);

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
}