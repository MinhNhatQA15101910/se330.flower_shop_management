package com.donhat.se330.flower_shop_management.frontend.features.customer.order.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentDeliveredOrderBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.adapters.OrdersAdapter;
import com.donhat.se330.flower_shop_management.frontend.models.Order;

import java.util.ArrayList;

public class DeliveredOrderFragment extends Fragment {
    ArrayList<Order> _orders;

    FragmentDeliveredOrderBinding _fragmentDeliveredOrderBinding;

    OrdersAdapter _ordersAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        _fragmentDeliveredOrderBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_delivered_order,
                container,
                false
        );

        _ordersAdapter = new OrdersAdapter(_orders);

        _fragmentDeliveredOrderBinding.deliveredOrderRecyclerView.setAdapter(_ordersAdapter);

        return inflater.inflate(R.layout.fragment_delivered_order, container, false);
    }
}