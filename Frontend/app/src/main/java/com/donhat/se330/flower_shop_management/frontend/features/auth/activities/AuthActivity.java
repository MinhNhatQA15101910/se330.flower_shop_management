package com.donhat.se330.flower_shop_management.frontend.features.auth.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityAuthBinding;
import com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers.LoginEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers.SignUpEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.auth.servicehandlers.AuthServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.User;

import java.util.concurrent.CompletableFuture;

public class AuthActivity extends AppCompatActivity implements HasDefaultViewModelProviderFactory {
    private ActivityAuthBinding _activityAuthBinding;

    private AuthViewModel _authViewModel;
    private FragmentTransaction _transaction;

    @Override
    protected void onStart() {
        super.onStart();
        LoginEventHandler.initialIntentSenderLauncher(this);
        SignUpEventHandler.initialIntentSenderLauncher(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _activityAuthBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_auth
        );

        // View Model
        setViewModels();

        // Observe
        observeData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        _activityAuthBinding = null;
    }

    private void setViewModels() {
        _authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);
    }

    private void observeData() {
        _authViewModel.getAuthFragment().observe(this, authFragment -> {
            _transaction = getSupportFragmentManager().beginTransaction();
            _transaction.replace(R.id.auth_fragment, authFragment);
            _transaction.addToBackStack(null);
            _transaction.commit();
        });
    }
}