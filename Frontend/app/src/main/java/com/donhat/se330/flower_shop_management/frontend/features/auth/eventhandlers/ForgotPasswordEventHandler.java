package com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.LoginFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.ForgotPasswordViewModel;

public class ForgotPasswordEventHandler {
    private final Context _context;
    private final AuthViewModel _authViewModel;
    private final ForgotPasswordViewModel _forgotPasswordViewModel;

    public ForgotPasswordEventHandler(Context context, AuthViewModel authViewModel, ForgotPasswordViewModel forgotPasswordViewModel) {
        _context = context;
        _authViewModel = authViewModel;
        _forgotPasswordViewModel = forgotPasswordViewModel;
    }

    public void navigateToLogInFragment(View view) {
        _authViewModel.getAuthFragment().setValue(new LoginFragment());
    }

    public void verifyPassword(View view) {
        String email = _forgotPasswordViewModel.getEmail().getValue();
        if (email.trim().isEmpty()) {
            _forgotPasswordViewModel.getIsEmailEmpty().setValue(true);
            return;
        }

        _forgotPasswordViewModel.getIsEmailEmpty().setValue(false);

        String emailPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if (!email.matches(emailPattern)) {
            _forgotPasswordViewModel.getIsEmailValid().setValue(false);
            return;
        }

        _forgotPasswordViewModel.getIsEmailValid().setValue(true);
        Toast.makeText(_context, "Valid", Toast.LENGTH_SHORT).show();
    }
}
