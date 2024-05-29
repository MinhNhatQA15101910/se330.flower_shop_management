package com.donhat.se330.flower_shop_management.frontend.features.customer.order.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentPendingOrderBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.adapters.OrdersAdapter;
import com.donhat.se330.flower_shop_management.frontend.models.Order;

import java.util.ArrayList;

public class PendingOrderFragment extends Fragment {

    ArrayList<Order> _orders;

    FragmentPendingOrderBinding _fragmentPendingOrderBinding;

    OrdersAdapter _ordersAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        _fragmentPendingOrderBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_pending_order,
                container,
                false
        );
        _ordersAdapter = new OrdersAdapter(_orders);

        _fragmentPendingOrderBinding.pendingOrderRecyclerView.setAdapter(_ordersAdapter);

        return inflater.inflate(R.layout.fragment_pending_order, container, false);
    }
}