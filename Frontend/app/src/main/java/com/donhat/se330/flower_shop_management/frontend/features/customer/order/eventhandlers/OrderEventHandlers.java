package com.donhat.se330.flower_shop_management.frontend.features.customer.order.eventhandlers;

import android.app.Activity;
import android.content.Context;

import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.servicehandlers.OrderServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.viewmodel.OrderManagementViewModel;

public class OrderEventHandlers {
    Context context;
    private final OrderManagementViewModel _orderManagementViewModel;
    private final OrderServiceHandler _orderServiceHandler;

    public OrderEventHandlers(Context context, OrderManagementViewModel orderManagementViewModel) {
        this.context=context;
        _orderManagementViewModel = orderManagementViewModel;
        _orderServiceHandler = new OrderServiceHandler(context, _orderManagementViewModel);
    }

    public void onInitial() {
        if (GlobalVariables.getUser() != null) {
            _orderServiceHandler.getOrderByUser(GlobalVariables.getUser().getValue().getId());
        }
    }

    public void onInitialStatus(String status) {
        if (GlobalVariables.getUser() != null) {
            _orderServiceHandler.getOrderByUserStatus(GlobalVariables.getUser().getValue().getId(), status);
        }
    }

    public void getOrderById(int order_id) {
        _orderServiceHandler.getOrderById(order_id);
        GlobalVariables.getOrder().setValue(_orderManagementViewModel.getOrder().getValue());
    }

    public void onNavigateBack(int order_id) {
        ((Activity) context).finish();
    }
}
