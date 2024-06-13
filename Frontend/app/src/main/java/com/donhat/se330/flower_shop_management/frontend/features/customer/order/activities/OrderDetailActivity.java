package com.donhat.se330.flower_shop_management.frontend.features.customer.order.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityOrderDetailBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.eventhandlers.OrderEventHandlers;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.viewmodel.OrderManagementViewModel;

public class OrderDetailActivity extends AppCompatActivity {
    private ActivityOrderDetailBinding _activityOrderDetailBinding;
    private OrderManagementViewModel _orderManagementViewModel;
    private OrderEventHandlers _orderEventHandlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _activityOrderDetailBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_order_detail
        );

        setViewModels();

        // Event handler
        setEventHandlers();

        GlobalVariables.getOrder().observe(this, order -> {
            _activityOrderDetailBinding.orderIdText.setText(order.getId());
            _activityOrderDetailBinding.orderDateText.setText(order.getOrderDate().toString());
            _activityOrderDetailBinding.orderIdText.setText(order.getId());
        });
    }

    private void setViewModels() {
        _orderManagementViewModel = new ViewModelProvider(this).get(OrderManagementViewModel.class);
    }

    private void setEventHandlers() {
        _orderEventHandlers = new OrderEventHandlers(this, _orderManagementViewModel);
    }
}
