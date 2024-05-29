package com.donhat.se330.flower_shop_management.frontend.features.customer.order.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentInDeliveryOrderBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.adapters.OrdersAdapter;
import com.donhat.se330.flower_shop_management.frontend.models.Order;

import java.util.ArrayList;

public class InDeliveryOrderFragment extends Fragment {
    ArrayList<Order> _orders;

    FragmentInDeliveryOrderBinding _fragmentInDeliveryOrderBinding;

    OrdersAdapter _ordersAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        _fragmentInDeliveryOrderBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_in_delivery_order,
                container,
                false
        );

        _ordersAdapter = new OrdersAdapter(_orders);

        _fragmentInDeliveryOrderBinding.inDeliveryOrderRecyclerView.setAdapter(_ordersAdapter);
        return inflater.inflate(R.layout.fragment_in_delivery_order, container, false);
    }
}