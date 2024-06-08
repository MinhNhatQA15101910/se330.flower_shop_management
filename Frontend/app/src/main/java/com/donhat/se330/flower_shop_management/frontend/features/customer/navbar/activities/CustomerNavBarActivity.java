package com.donhat.se330.flower_shop_management.frontend.features.customer.navbar.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityCustomerNavBarBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.navbar.eventhandlers.CustomerNavBarEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.navbar.viewmodels.CustomerNavBarViewModel;

public class CustomerNavBarActivity extends AppCompatActivity {
    private ActivityCustomerNavBarBinding _activityCustomerNavBarBinding;
    private CustomerNavBarViewModel _customerNavBarViewModel;
    private CustomerNavBarEventHandler _customerNavBarEventHandler;
    private FragmentTransaction _transaction;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _activityCustomerNavBarBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_customer_nav_bar
        );

        // View Model
        _customerNavBarViewModel = new ViewModelProvider(this).get(CustomerNavBarViewModel.class);

        // Event Handler
        _customerNavBarEventHandler = new CustomerNavBarEventHandler(_customerNavBarViewModel, this);

        _activityCustomerNavBarBinding.setCustomerNavBarEventHandler(_customerNavBarEventHandler);

        // Observe
        _customerNavBarViewModel.getCustomerFragment().observe(this, customerFragment -> {
            _transaction = getSupportFragmentManager().beginTransaction();
            _transaction.replace(R.id.fragment_container, customerFragment);
            _transaction.addToBackStack(null);
            _transaction.commit();
        });

        _customerNavBarViewModel.getIsHomeClicked().observe(this, isHomeClicked -> {
            if (isHomeClicked) {
                _activityCustomerNavBarBinding.titleLable.setText("Flowerfly");
                _activityCustomerNavBarBinding.homeTxt.setVisibility(View.VISIBLE);
                _activityCustomerNavBarBinding.homeImage.setImageResource(R.drawable.vector_home_selected);
                _activityCustomerNavBarBinding.homeLayout.setBackgroundResource(R.drawable.round_white_100);
                _activityCustomerNavBarBinding.homeLayout.setScaleX(0f);
                _activityCustomerNavBarBinding.homeLayout.setScaleY(0f);
                _activityCustomerNavBarBinding.homeLayout.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(200)
                        .setListener(null);

            } else {
                _activityCustomerNavBarBinding.homeTxt.setVisibility(View.GONE);
                _activityCustomerNavBarBinding.homeImage.setImageResource(R.drawable.vector_home);
                _activityCustomerNavBarBinding.homeLayout.setBackgroundResource(0);
            }
        });
        _customerNavBarViewModel.getIsCategoryClicked().observe(this, isCategoryClicked -> {
            if (isCategoryClicked) {
                _activityCustomerNavBarBinding.titleLable.setText("Category");
                _activityCustomerNavBarBinding.categoryTxt.setVisibility(View.VISIBLE);
                _activityCustomerNavBarBinding.categoryImage.setImageResource(R.drawable.vector_category_selected);
                _activityCustomerNavBarBinding.categoryLayout.setBackgroundResource(R.drawable.round_white_100);
                _activityCustomerNavBarBinding.categoryLayout.setScaleX(0f);
                _activityCustomerNavBarBinding.categoryLayout.setScaleY(0f);
                _activityCustomerNavBarBinding.categoryLayout.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(200)
                        .setListener(null);

            } else {
                _activityCustomerNavBarBinding.categoryTxt.setVisibility(View.GONE);
                _activityCustomerNavBarBinding.categoryImage.setImageResource(R.drawable.vector_category);
                _activityCustomerNavBarBinding.categoryLayout.setBackgroundResource(0);
            }
        });
        _customerNavBarViewModel.getIsSearchClicked().observe(this, isSearchClicked -> {
            if (isSearchClicked) {
                _activityCustomerNavBarBinding.titleLable.setText("Search");
                _activityCustomerNavBarBinding.searchTxt.setVisibility(View.VISIBLE);
                _activityCustomerNavBarBinding.searchImage.setImageResource(R.drawable.vector_search_selected);
                _activityCustomerNavBarBinding.searchLayout.setBackgroundResource(R.drawable.round_white_100);
                _activityCustomerNavBarBinding.searchLayout.setScaleX(0f);
                _activityCustomerNavBarBinding.searchLayout.setScaleY(0f);
                _activityCustomerNavBarBinding.searchLayout.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(200)
                        .setListener(null);

            } else {
                _activityCustomerNavBarBinding.searchTxt.setVisibility(View.GONE);
                _activityCustomerNavBarBinding.searchImage.setImageResource(R.drawable.vector_search);
                _activityCustomerNavBarBinding.searchLayout.setBackgroundResource(0);
            }
        });
        _customerNavBarViewModel.getIsProfileClicked().observe(this, isProfileClicked -> {
            if (isProfileClicked) {
                _activityCustomerNavBarBinding.titleLable.setText("Profile");
                _activityCustomerNavBarBinding.profileTxt.setVisibility(View.VISIBLE);
                _activityCustomerNavBarBinding.profileImage.setImageResource(R.drawable.vector_profile_selected);
                _activityCustomerNavBarBinding.profileLayout.setBackgroundResource(R.drawable.round_white_100);
                _activityCustomerNavBarBinding.profileLayout.setScaleX(0f);
                _activityCustomerNavBarBinding.profileLayout.setScaleY(0f);
                _activityCustomerNavBarBinding.profileLayout.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(200)
                        .setListener(null);

            } else {
                _activityCustomerNavBarBinding.profileTxt.setVisibility(View.GONE);
                _activityCustomerNavBarBinding.profileImage.setImageResource(R.drawable.vector_profile);
                _activityCustomerNavBarBinding.profileLayout.setBackgroundResource(0);
            }
        });
    }
}