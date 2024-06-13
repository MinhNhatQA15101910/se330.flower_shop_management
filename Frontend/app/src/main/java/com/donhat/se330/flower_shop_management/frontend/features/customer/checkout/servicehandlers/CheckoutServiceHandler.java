package com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.servicehandlers;

import static com.donhat.se330.flower_shop_management.frontend.constants.utils.Utils.displayErrorToast;
import static com.donhat.se330.flower_shop_management.frontend.constants.utils.Utils.displaySuccessToast;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.constants.retrofit.RetrofitClient;
import com.donhat.se330.flower_shop_management.frontend.constants.utils.ErrorHandling;
import com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.services.CheckoutService;
import com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.viewmodels.CheckoutViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Order;
import com.donhat.se330.flower_shop_management.frontend.models.Voucher;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckoutServiceHandler {
    private final Context _context;
    private final CheckoutService _checkoutService;
    private final CheckoutViewModel _checkoutViewModel;

    public CheckoutServiceHandler(Context context, CheckoutViewModel checkoutViewModel) {
        _checkoutService = RetrofitClient.getRetrofitInstance().create(CheckoutService.class);
        _context = context;
        _checkoutViewModel = checkoutViewModel;
    }

    public void createOrderFromCart(Order order) {
        Map<String, Object> map = new HashMap<>();
        map.put("estimated_receive_date", order.getEstimatedReceiveDate());
        map.put("province", order.getProvince());
        map.put("district", order.getDistrict());
        map.put("ward", order.getWard());
        map.put("detail_address", order.getDetailAddress());
        map.put("receiver_name", order.getReceiverName());
        map.put("receiver_phone_number", order.getReceiverPhoneNumber());
        ObjectMapper objectMapper = new ObjectMapper();
        Object requestBody = objectMapper.convertValue(map, Object.class);
        Call<Order> call = _checkoutService.createOrderFromCart(Objects.requireNonNull(GlobalVariables.getUser().getValue()).getToken(), requestBody);
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

    public MutableLiveData<List<Voucher>> getAllVouchers() {
        MutableLiveData<List<Voucher>> voucherList = new MutableLiveData<>();
        Call<List<Voucher>> call = _checkoutService.getAllVouchers(Objects.requireNonNull(GlobalVariables.getUser().getValue()).getToken());
        call.enqueue(new Callback<List<Voucher>>() {
            @Override
            public void onResponse(@NonNull Call<List<Voucher>> call, @NonNull Response<List<Voucher>> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> {
                    voucherList.setValue(response.body());
                });
            }

            @Override
            public void onFailure(@NonNull Call<List<Voucher>> call, @NonNull Throwable throwable) {
                displayErrorToast(_context, throwable.getMessage());
            }
        });
        return voucherList;
    }
}
