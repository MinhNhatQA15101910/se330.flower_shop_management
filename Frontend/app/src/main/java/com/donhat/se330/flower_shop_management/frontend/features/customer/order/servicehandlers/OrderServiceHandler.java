package com.donhat.se330.flower_shop_management.frontend.features.customer.order.servicehandlers;

import static com.donhat.se330.flower_shop_management.frontend.constants.utils.Utils.displayErrorToast;

import android.content.Context;

import androidx.annotation.NonNull;

import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.constants.retrofit.RetrofitClient;
import com.donhat.se330.flower_shop_management.frontend.constants.utils.ErrorHandling;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.services.OrderService;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.viewmodel.OrderManagementViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Order;
import com.donhat.se330.flower_shop_management.frontend.models.User;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderServiceHandler {
    private final Context _context;
    private final OrderService _orderService;
    private final OrderManagementViewModel _orderManagementViewModel;

    public OrderServiceHandler(Context context, OrderManagementViewModel orderManagementViewModel) {
        _orderService = RetrofitClient.getRetrofitInstance().create(OrderService.class);
        _context = context;
        _orderManagementViewModel = orderManagementViewModel;
    }
    public void getOrderByUser(int userId) {
        Call<List<Order>> call = _orderService.GetOrderByUser(Objects.requireNonNull(GlobalVariables.getUser().getValue()).getToken(), userId);
        call.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(@NonNull Call<List<Order>> call, @NonNull Response<List<Order>> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> _orderManagementViewModel.getOrderList().setValue(response.body()));
            }
            @Override
            public void onFailure(@NonNull Call<List<Order>> call, @NonNull Throwable throwable) {
                displayErrorToast(_context, throwable.getMessage());
            }
        });
    }
    public void getOrderByUserStatus(int userId, String userStatus) {
        Call<List<Order>> call = _orderService.GetOrderByUserSatus(Objects.requireNonNull(GlobalVariables.getUser().getValue()).getToken(), userId, userStatus);
        call.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(@NonNull Call<List<Order>> call, @NonNull Response<List<Order>> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> _orderManagementViewModel.getOrderList().setValue(response.body()));
            }
            @Override
            public void onFailure(@NonNull Call<List<Order>> call, @NonNull Throwable throwable) {
                displayErrorToast(_context, throwable.getMessage());
            }
        });
    }
    public void getOrderById(int orderId) {
        Call<Order> call = _orderService.getOrderById(
                Objects.requireNonNull(GlobalVariables.getUser().getValue()).getToken(),
                orderId
        );
        call.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(@NonNull Call<Order> call, @NonNull Response<Order> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> GlobalVariables.getOrder().setValue(response.body()));
            }

            @Override
            public void onFailure(@NonNull Call<Order> call, @NonNull Throwable throwable) {
                displayErrorToast(_context, throwable.getMessage());
            }
        });
    }
}
