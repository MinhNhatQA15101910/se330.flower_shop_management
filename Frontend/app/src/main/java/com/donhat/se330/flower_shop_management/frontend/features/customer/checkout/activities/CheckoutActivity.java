package com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityCheckoutBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.eventhandlers.CheckoutEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.viewmodels.CheckoutViewModel;

public class CheckoutActivity extends AppCompatActivity {
    private ActivityCheckoutBinding _activityCheckoutBinding;
    private CheckoutViewModel _checkoutViewModel;
    private CheckoutEventHandler _checkoutEventHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout for this activity using DataBindingUtil
        _activityCheckoutBinding = DataBindingUtil.setContentView(this, R.layout.activity_checkout);

        // View Model
        _checkoutViewModel = new ViewModelProvider(this).get(CheckoutViewModel.class);

        // Event Handler
        _checkoutEventHandler = new CheckoutEventHandler(_checkoutViewModel, this);
        _activityCheckoutBinding.setActivityCheckoutEventHandler(_checkoutEventHandler);

        // Set up RecyclerView
        RecyclerView productCheckoutItemRecyclerView = _activityCheckoutBinding.recyclerViewCheckoutDetail;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        productCheckoutItemRecyclerView.setLayoutManager(linearLayoutManager);
        productCheckoutItemRecyclerView.setHasFixedSize(true);

    }

}
