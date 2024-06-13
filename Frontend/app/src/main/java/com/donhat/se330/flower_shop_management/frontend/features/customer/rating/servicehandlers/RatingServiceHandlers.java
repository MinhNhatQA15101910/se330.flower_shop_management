package com.donhat.se330.flower_shop_management.frontend.features.customer.rating.servicehandlers;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.constants.retrofit.RetrofitClient;
import com.donhat.se330.flower_shop_management.frontend.constants.utils.ErrorHandling;
import com.donhat.se330.flower_shop_management.frontend.features.customer.rating.services.RatingService;
import com.donhat.se330.flower_shop_management.frontend.features.customer.rating.viewmodels.RatingViewModels;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RatingServiceHandlers {
    private final MutableLiveData<Product> _products = new MutableLiveData<>();
    Context context;
    RatingService ratingService;
    RatingViewModels ratingViewModels;

    public RatingServiceHandlers(Context context, RatingViewModels ratingViewModels) {
        this.context = context;
        this.ratingViewModels = ratingViewModels;
        ratingService = RetrofitClient.getRetrofitInstance().create(RatingService.class);
    }

    public MutableLiveData<Product> getProductFromId(int productId) {
        String authToken = GlobalVariables.getUser().getValue().getToken();
        Call<Product> call = ratingService.getProductFromId(authToken, productId);

        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(@NonNull Call<Product> call, @NonNull Response<Product> response) {
                ErrorHandling.httpErrorHandler(response, context, () -> {
                    Product product = response.body();
                    if (product != null) {
                        ratingViewModels.getProduct().setValue(product);
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

}
