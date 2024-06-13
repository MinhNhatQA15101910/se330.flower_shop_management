package com.donhat.se330.flower_shop_management.frontend.features.customer.order.eventhandlers;

import android.content.Context;

import com.donhat.se330.flower_shop_management.frontend.features.customer.order.servicehandlers.OrderDetailServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.viewmodel.OrderDetailViewModel;

public class OrderDetailEventHandler {
    Context context;
    OrderDetailViewModel orderDetailViewModel;
    OrderDetailServiceHandler orderDetailServiceHandler;

    public OrderDetailEventHandler(OrderDetailViewModel orderDetailViewModel, Context context) {
        this.orderDetailViewModel = orderDetailViewModel;
        this.context = context;
        this.orderDetailServiceHandler = new OrderDetailServiceHandler(context, orderDetailViewModel);
    }

    public void onInitial() {
        int orderId = orderDetailViewModel.getOrderId();
        if (orderId > 0) {
            orderDetailViewModel.setOrder(orderDetailServiceHandler.getOrderFromId(orderId));
        }
    }
}
