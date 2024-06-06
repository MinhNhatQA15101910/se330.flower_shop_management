package com.donhat.se330.flower_shop_management.frontend.features.customer.cart.servicehandlers;

import static com.donhat.se330.flower_shop_management.frontend.constants.utils.Utils.displayErrorToast;

import android.content.Context;

import androidx.annotation.NonNull;

import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.constants.retrofit.RetrofitClient;
import com.donhat.se330.flower_shop_management.frontend.constants.utils.ErrorHandling;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.services.CartService;
import com.donhat.se330.flower_shop_management.frontend.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartServiceHandler {
    private final Context _context;
    private final CartService _cartService;

    public CartServiceHandler(Context context) {
        _cartService = RetrofitClient.getRetrofitInstance().create(CartService.class);
        _context = context;
    }

    public void addToCart(int productId) {
        Map<String, Object> map = new HashMap<>();
        map.put("product_id", productId);
        ObjectMapper objectMapper = new ObjectMapper();
        Object requestBody = objectMapper.convertValue(map, Object.class);
        Call<User> call = _cartService.addToCart(Objects.requireNonNull(GlobalVariables.getUser().getValue()).getToken(), requestBody);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> GlobalVariables.getUser().setValue(response.body()));
            }
            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable throwable) {
                displayErrorToast(_context, throwable.getMessage());
            }
        });
    }
    public void removeFromCart(int productId) {
        Call<User> call = _cartService.removeFromCart(
                Objects.requireNonNull(GlobalVariables.getUser().getValue()).getToken(),
                productId
        );

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> GlobalVariables.getUser().setValue(response.body()));
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable throwable) {
                displayErrorToast(_context, throwable.getMessage());
            }
        });
    }
    public void deleteFromCart(int productId) {
        Call<User> call = _cartService.deleteFromCart(
                Objects.requireNonNull(GlobalVariables.getUser().getValue()).getToken(),
                productId
        );

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> GlobalVariables.getUser().setValue(response.body()));
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable throwable) {
                   displayErrorToast(_context, throwable.getMessage());
            }
        });
    }

}
