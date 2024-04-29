package com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers;

import android.content.Context;
import android.view.View;

import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.LoginFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;

public class SignUpEventHandler {
    private final Context _context;
    private final AuthViewModel _authViewModel;

    public SignUpEventHandler(Context context, AuthViewModel authViewModel) {
        _context = context;
        _authViewModel = authViewModel;
    }

    public void navigateToLoginFragment(View view) {
        _authViewModel.getAuthFragment().setValue(new LoginFragment());
    }
}
