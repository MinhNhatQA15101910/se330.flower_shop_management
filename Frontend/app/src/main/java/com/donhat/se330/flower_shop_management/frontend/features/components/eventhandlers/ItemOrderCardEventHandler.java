package com.donhat.se330.flower_shop_management.frontend.features.components.eventhandlers;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.donhat.se330.flower_shop_management.frontend.features.customer.order.activities.OrderDetailActivity;
import com.donhat.se330.flower_shop_management.frontend.models.Order;

import java.util.Objects;

public class ItemOrderCardEventHandler {
    private final MutableLiveData<Order> _order = new MutableLiveData<>();
    Context _context;

    public ItemOrderCardEventHandler(Context context) {
        _context = context;
    }

    public void setOrder(Order order) {
        _order.setValue(order);
    }

    public void onOrderClick(View view) {
        Intent intent = new Intent(view.getContext(), OrderDetailActivity.class);
        intent.putExtra("order", Objects.requireNonNull(_order.getValue()).getId());
        view.getContext().startActivity(intent);
    }
}
