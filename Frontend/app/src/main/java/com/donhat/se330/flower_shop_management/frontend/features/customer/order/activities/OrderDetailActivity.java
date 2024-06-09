package com.donhat.se330.flower_shop_management.frontend.features.customer.order.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityOrderDetailBinding;

public class OrderDetailActivity extends AppCompatActivity{
    private ActivityOrderDetailBinding activityOrderDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOrderDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_order_detail);
    }
}
