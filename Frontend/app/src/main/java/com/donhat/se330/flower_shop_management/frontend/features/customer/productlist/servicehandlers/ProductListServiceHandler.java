package com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.servicehandlers;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.constants.responses.ProductListResponse;
import com.donhat.se330.flower_shop_management.frontend.constants.retrofit.RetrofitClient;
import com.donhat.se330.flower_shop_management.frontend.constants.utils.ErrorHandling;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.services.ProductListService;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.viewmodels.ProductListViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductListServiceHandler {
    private final Context _context;
    private final ProductListService _productListService;
    private final ProductListViewModel _productListViewModel;
    private MutableLiveData<List<Product>> _productsList = new MutableLiveData<>();

    public ProductListServiceHandler(Context context, ProductListViewModel productListViewModel) {
        _productListService = RetrofitClient.getRetrofitInstance().create(ProductListService.class);
        _context = context;
        _productListViewModel = productListViewModel;
    }

    public MutableLiveData<List<Product>> getProduct() {
        String authToken = GlobalVariables.getUser().getValue().getToken();

        Call<ProductListResponse> call = _productListService.getDoDProducts(authToken);

        call.enqueue(new Callback<ProductListResponse>() {
            @Override
            public void onResponse(@NonNull Call<ProductListResponse> call, @NonNull Response<ProductListResponse> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> {
                    ProductListResponse productListResponse = response.body();

                    if (productListResponse != null && productListResponse.getResults() != null) {
                        _productsList.setValue(productListResponse.getResults());
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<ProductListResponse> call, @NonNull Throwable throwable) {
                Toast.makeText(_context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return _productsList;
    }
}
