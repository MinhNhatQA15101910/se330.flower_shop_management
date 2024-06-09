package com.donhat.se330.flower_shop_management.frontend.features.customer.order.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.donhat.se330.flower_shop_management.frontend.models.Order;

import java.util.List;

public class OrderManagementViewModel extends ViewModel {
    MutableLiveData<List<Order>> orderList =new MutableLiveData<>();

    public MutableLiveData<List<Order>> getOrderList() {
        return orderList;
    }
}
