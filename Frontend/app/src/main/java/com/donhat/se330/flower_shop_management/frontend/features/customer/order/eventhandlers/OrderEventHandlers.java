package com.donhat.se330.flower_shop_management.frontend.features.customer.order.eventhandlers;

import android.app.Activity;
import android.content.Context;

import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.servicehandlers.OrderServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.viewmodel.OrderManagementViewModel;

public class OrderEventHandlers {
    private final Context _context;
    private final Activity _activity;
    private final OrderManagementViewModel _orderManagementViewModel;
    private final OrderServiceHandler _orderServiceHandler;

    public OrderEventHandlers(Context context, OrderManagementViewModel orderManagementViewModel, Activity activity) {
        _context = context;
        _activity = activity;
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
}
