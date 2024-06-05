package com.donhat.se330.flower_shop_management.frontend.features.customer.cart.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.adapters.CartAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.eventhandlers.CartEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.viewmodels.CartViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout for this activity using DataBindingUtil
        com.donhat.se330.flower_shop_management.frontend.databinding.ActivityCartBinding _activityCartBinding = DataBindingUtil.setContentView(this, R.layout.activity_cart);

        // View Model
        CartViewModel _cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);

        // Event Handler
        CartEventHandler _cartEventHandler = new CartEventHandler(_cartViewModel, this);
        _activityCartBinding.setActivityCartEventHandler(_cartEventHandler);

        // Set up RecyclerView
        RecyclerView cartItemRecyclerView = _activityCartBinding.cartItemRecyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        cartItemRecyclerView.setLayoutManager(linearLayoutManager);
        cartItemRecyclerView.setHasFixedSize(true);

        List<Cart> cartList = new ArrayList<>();
        CartAdapter cartAdapter = new CartAdapter(cartList, this);
        cartItemRecyclerView.setAdapter(cartAdapter);
    }
}
