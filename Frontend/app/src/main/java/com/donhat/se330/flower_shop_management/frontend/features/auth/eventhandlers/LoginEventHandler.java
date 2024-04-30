package com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers;

import android.content.Context;
import android.view.View;

import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.ForgotPasswordFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.SignUpFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;

public class LoginEventHandler {
    private final Context _context;
    private final AuthViewModel _authViewModel;

    public LoginEventHandler(Context context, AuthViewModel authViewModel) {
        _context = context;
        _authViewModel = authViewModel;
    }

    public void navigateToSignUpFragment(View view) {
        _authViewModel.getAuthFragment().setValue(new SignUpFragment());
    }

    public void navigateToForgotPasswordFragment(View view) {
        _authViewModel.getAuthFragment().setValue(new ForgotPasswordFragment());
    }
}
