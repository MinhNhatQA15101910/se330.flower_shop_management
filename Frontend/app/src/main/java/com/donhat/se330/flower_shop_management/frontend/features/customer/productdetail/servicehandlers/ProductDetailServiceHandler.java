package com.donhat.se330.flower_shop_management.frontend.features.customer.productdetail.servicehandlers;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.constants.responses.ProductListResponse;
import com.donhat.se330.flower_shop_management.frontend.constants.retrofit.RetrofitClient;
import com.donhat.se330.flower_shop_management.frontend.constants.utils.ErrorHandling;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productdetail.services.ProductDetailService;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productdetail.viewmodels.ProductDetailViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailServiceHandler {
    Context context;
    ProductDetailService productDetailService;
    ProductDetailViewModel productDetailViewModel;
    private MutableLiveData<Product> _products = new MutableLiveData<>();
    private MutableLiveData<List<Product>> _productsList = new MutableLiveData<>();

    public ProductDetailServiceHandler(Context context, ProductDetailViewModel productDetailViewModel) {
        this.context = context;
        this.productDetailViewModel = productDetailViewModel;
        productDetailService = RetrofitClient.getRetrofitInstance().create(ProductDetailService.class);
    }

    public MutableLiveData<Product> getProductFromId(int productId) {
        String authToken = GlobalVariables.getUser().getValue().getToken();
        Call<Product> call = productDetailService.getProductFromId(authToken, productId);

        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(@NonNull Call<Product> call, @NonNull Response<Product> response) {
                ErrorHandling.httpErrorHandler(response, context, () -> {
                    Product product = response.body();
                    if (product != null) {
                        productDetailViewModel.getProduct().setValue(product);
                        _products.setValue(product);
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<Product> call, @NonNull Throwable throwable) {
                Toast.makeText(context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return _products;
    }

    public MutableLiveData<List<Product>> getRecommendProducts() {
        String authToken = GlobalVariables.getUser().getValue().getToken();
        Call<ProductListResponse> call = productDetailService.getRecommendProducts(authToken);

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
