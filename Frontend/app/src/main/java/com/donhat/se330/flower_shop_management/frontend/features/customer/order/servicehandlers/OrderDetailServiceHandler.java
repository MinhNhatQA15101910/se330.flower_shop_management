package com.donhat.se330.flower_shop_management.frontend.features.customer.order.servicehandlers;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.constants.retrofit.RetrofitClient;
import com.donhat.se330.flower_shop_management.frontend.constants.utils.ErrorHandling;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.services.OrderService;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.viewmodel.OrderDetailViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Order;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderDetailServiceHandler {
    private final Context _context;
    private final OrderService _orderService;
    private final OrderDetailViewModel _orderDetailViewModel;

    private final MutableLiveData<Order> _order = new MutableLiveData<>();

    public OrderDetailServiceHandler(Context context, OrderDetailViewModel orderDetailViewModel) {
        _orderService = RetrofitClient.getRetrofitInstance().create(OrderService.class);
        _context = context;
        _orderDetailViewModel = orderDetailViewModel;
    }

    public MutableLiveData<Order> getOrderFromId(int orderId) {
        String authToken = GlobalVariables.getUser().getValue().getToken();
        Call<Order> call = _orderService.getOrderById(authToken, orderId);

        call.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(@NonNull Call<Order> call, @NonNull Response<Order> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> {
                    Order product = response.body();
                    if (product != null) {
                        _orderDetailViewModel.getOrder().setValue(product);
                        _order.setValue(product);
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<Order> call, @NonNull Throwable throwable) {
                Toast.makeText(_context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return _order;
    }
}
