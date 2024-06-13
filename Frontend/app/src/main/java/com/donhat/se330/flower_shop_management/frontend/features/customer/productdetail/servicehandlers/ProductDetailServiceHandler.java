package com.donhat.se330.flower_shop_management.frontend.features.customer.productdetail.servicehandlers;

import static com.donhat.se330.flower_shop_management.frontend.constants.utils.Utils.displayErrorToast;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.constants.retrofit.RetrofitClient;
import com.donhat.se330.flower_shop_management.frontend.constants.utils.ErrorHandling;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productdetail.services.ProductDetailService;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productdetail.viewmodels.ProductDetailViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Product;
import com.donhat.se330.flower_shop_management.frontend.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailServiceHandler {
    Context context;
    ProductDetailService productDetailService;
    ProductDetailViewModel productDetailViewModel;
    private final MutableLiveData<Product> _products = new MutableLiveData<>();
    private final MutableLiveData<List<Product>> _productsList = new MutableLiveData<>();

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
        Call<List<Product>> call = productDetailService.getRecommendProducts(authToken);

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(@NonNull Call<List<Product>> call, @NonNull Response<List<Product>> response) {
                ErrorHandling.httpErrorHandler(response, context, () -> {
                    List<Product> productListResponse = response.body();

                    if (productListResponse != null) {
                        _productsList.setValue(productListResponse);
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<List<Product>> call, @NonNull Throwable throwable) {
                Toast.makeText(context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return _productsList;
    }
    public void addToCart(int productId) {
        Map<String, Object> map = new HashMap<>();
        map.put("product_id", productId);
        ObjectMapper objectMapper = new ObjectMapper();
        Object requestBody = objectMapper.convertValue(map, Object.class);
        Call<User> call = productDetailService.addToCart(Objects.requireNonNull(GlobalVariables.getUser().getValue()).getToken(), requestBody);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                ErrorHandling.httpErrorHandler(response, context, () -> GlobalVariables.getUser().setValue(response.body()));
            }
            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable throwable) {
                displayErrorToast(context, throwable.getMessage());
            }
        });
    }

}
