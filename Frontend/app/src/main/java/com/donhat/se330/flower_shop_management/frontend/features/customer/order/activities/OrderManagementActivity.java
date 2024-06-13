package com.donhat.se330.flower_shop_management.frontend.features.customer.order.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager2.widget.ViewPager2;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityOrderManagementBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.adapters.ViewPagerAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.eventhandlers.OrderEventHandlers;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class OrderManagementActivity extends AppCompatActivity {

    ActivityOrderManagementBinding _activityOrderManagementBinding;
    OrderEventHandlers orderEventHandlers;

    ViewPagerAdapter _viewPagerAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _activityOrderManagementBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_order_management
        );
        _activityOrderManagementBinding.setActivityOrderEventHandlers(orderEventHandlers);

        _viewPagerAdapter = new ViewPagerAdapter(
                getSupportFragmentManager(),
                getLifecycle()
        );

        TabLayout tabLayout = _activityOrderManagementBinding.tabLayout;
        ViewPager2 viewPager = _activityOrderManagementBinding.viewPager2;

        viewPager.setAdapter(_viewPagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(getTabText(position))
        ).attach();
    }

    private String getTabText(int position) {
        switch(position) {
            case 0:
                return "All";
            case 1:
                return "Pending";
            case 2:
                return "In Delivery";
            case 3:
                return "Delivered";
            default:
                return "";
        }
    }
}
