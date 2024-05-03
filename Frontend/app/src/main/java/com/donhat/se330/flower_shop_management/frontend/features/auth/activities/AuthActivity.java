package com.donhat.se330.flower_shop_management.frontend.features.auth.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityAuthBinding;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;

public class AuthActivity extends AppCompatActivity implements HasDefaultViewModelProviderFactory {
    private ActivityAuthBinding _activityAuthBinding;

    private AuthViewModel _authViewModel;
    private FragmentTransaction _transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _activityAuthBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_auth
        );

        // View Model
        _authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        // Observe
        _authViewModel.getAuthFragment().observe(this, authFragment -> {
            _transaction = getSupportFragmentManager().beginTransaction();
            _transaction.replace(R.id.auth_fragment, authFragment);
            _transaction.addToBackStack(null);
            _transaction.commit();
        });
    }
}