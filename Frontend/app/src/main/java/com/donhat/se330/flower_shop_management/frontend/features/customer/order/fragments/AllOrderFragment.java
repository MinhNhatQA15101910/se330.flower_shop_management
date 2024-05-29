package com.donhat.se330.flower_shop_management.frontend.features.customer.order.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentAllOrderBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.adapters.OrdersAdapter;
import com.donhat.se330.flower_shop_management.frontend.models.Order;

import java.util.ArrayList;

public class AllOrderFragment extends Fragment {
    ArrayList<Order> _orders;

    FragmentAllOrderBinding _fragmentAllOrderBinding;

    OrdersAdapter _ordersAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        _fragmentAllOrderBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_all_order,
                container,
                false
        );

        _ordersAdapter = new OrdersAdapter(_orders);
        _fragmentAllOrderBinding.allOrderRecyclerView.setAdapter(_ordersAdapter);

        return inflater.inflate(R.layout.fragment_all_order, container, false);
    }
}