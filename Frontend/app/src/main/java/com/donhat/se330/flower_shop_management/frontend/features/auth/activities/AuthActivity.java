package com.donhat.se330.flower_shop_management.frontend.features.auth.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_auth);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        _activityAuthBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_auth
        );

        // View Model
        _authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        _authViewModel.getAuthFragment().observe(this, authFragment -> {
            _transaction = getSupportFragmentManager().beginTransaction();
            _transaction.replace(R.id.auth_fragment, authFragment);
            _transaction.addToBackStack(null);
            _transaction.commit();
        });
    }
}