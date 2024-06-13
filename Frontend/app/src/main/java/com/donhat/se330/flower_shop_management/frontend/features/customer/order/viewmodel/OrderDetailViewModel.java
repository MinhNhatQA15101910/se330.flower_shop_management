package com.donhat.se330.flower_shop_management.frontend.features.customer.order.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.donhat.se330.flower_shop_management.frontend.models.Order;

public class OrderDetailViewModel extends ViewModel {
    private MutableLiveData<Order> order = new MutableLiveData<>();
    private int orderId;

    public MutableLiveData<Order> getOrder() {
        return order;
    }

    public void setOrder(MutableLiveData<Order> order) {
        this.order = order;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
