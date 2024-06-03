package com.donhat.se330.flower_shop_management.frontend.features.auth.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityAuthBinding;
import com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers.LoginEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.common.api.ApiException;

public class AuthActivity extends AppCompatActivity implements HasDefaultViewModelProviderFactory {
    private ActivityAuthBinding _activityAuthBinding;

    private AuthViewModel _authViewModel;
    private FragmentTransaction _transaction;

    private static ActivityResultLauncher<IntentSenderRequest> _intentSenderLauncher;

    @Override
    protected void onStart() {
        super.onStart();
        LoginEventHandler.initialIntentSenderLauncher(this);
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