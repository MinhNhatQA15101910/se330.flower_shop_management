package com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.servicehandlers;

import static com.donhat.se330.flower_shop_management.frontend.constants.utils.Utils.displayErrorToast;
import static com.donhat.se330.flower_shop_management.frontend.constants.utils.Utils.displaySuccessToast;

import android.content.Context;

import androidx.annotation.NonNull;

import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.constants.retrofit.RetrofitClient;
import com.donhat.se330.flower_shop_management.frontend.constants.utils.ErrorHandling;
import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.LoginFragment;
import com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.services.CheckoutService;
import com.donhat.se330.flower_shop_management.frontend.models.Order;
import com.donhat.se330.flower_shop_management.frontend.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckoutServiceHandler {
    private final Context _context;
    private final CheckoutService _checkoutService;

    public CheckoutServiceHandler(Context context) {
        _checkoutService = RetrofitClient.getRetrofitInstance().create(CheckoutService.class);
        _context = context;
    }

    public void createOrderFromCart(Order order) {
        Call<Order> call = _checkoutService.createOrderFromCart(Objects.requireNonNull(GlobalVariables.getUser().getValue()).getToken());
        call.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(@NonNull Call<Order> call, @NonNull Response<Order> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> {
                    displaySuccessToast(_context, "Create order successfully");
                });
            }
            @Override
            public void onFailure(@NonNull Call<Order> call, @NonNull Throwable throwable) {
                displayErrorToast(_context, throwable.getMessage());
            }
        });
    }
}
