package com.donhat.se330.flower_shop_management.frontend.features.customer.order.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentDeliveredOrderBinding;
import com.donhat.se330.flower_shop_management.frontend.features.components.adapters.ItemOrderCardAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.eventhandlers.OrderEventHandlers;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.viewmodel.OrderManagementViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Order;

import java.util.List;

public class DeliveredOrderFragment extends Fragment {
    private FragmentDeliveredOrderBinding fragmentDeliveredOrderBinding;
    private ItemOrderCardAdapter itemOrderCardAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentDeliveredOrderBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_delivered_order,
                container,
                false
        );

        OrderManagementViewModel orderManagementViewModel = new ViewModelProvider(this).get(OrderManagementViewModel.class);

        // Event Handler
        OrderEventHandlers orderEventHandlers = new OrderEventHandlers(getContext(), orderManagementViewModel);

        orderManagementViewModel.getOrderList().observe(getViewLifecycleOwner(), orderList -> {
            if (orderList != null && !orderList.isEmpty()) {
                setupRecyclerView(orderList);
            }
        });

        orderEventHandlers.onInitialStatus("In delivery");

        return fragmentDeliveredOrderBinding.getRoot();  // Return the bound view
    }

    private void setupRecyclerView(List<Order> orderList) {
        RecyclerView orderItemRecyclerView = fragmentDeliveredOrderBinding.deliveredOrderRecyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        orderItemRecyclerView.setLayoutManager(linearLayoutManager);
        orderItemRecyclerView.setHasFixedSize(true);

        itemOrderCardAdapter = new ItemOrderCardAdapter(orderList, getContext());
        orderItemRecyclerView.setAdapter(itemOrderCardAdapter);
    }
}