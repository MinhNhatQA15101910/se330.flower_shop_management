package com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers;

import android.content.Context;
import android.os.Handler;
import android.view.View;

import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.LoginFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.servicehandlers.AuthServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.ForgotPasswordViewModel;

public class ForgotPasswordEventHandler {
    private final AuthViewModel _authViewModel;
    private final ForgotPasswordViewModel _forgotPasswordViewModel;
    private final AuthServiceHandler _authServiceHandler;

    public ForgotPasswordEventHandler(AuthViewModel authViewModel, ForgotPasswordViewModel forgotPasswordViewModel, Context context) {
        _authViewModel = authViewModel;
        _forgotPasswordViewModel = forgotPasswordViewModel;
        _authServiceHandler = new AuthServiceHandler(context, authViewModel);
    }

    public void navigateToLogInFragment(View view) {
        _authViewModel.getAuthFragment().setValue(new LoginFragment());
    }

    public void verifyEmail(View view) {
        if (isValidAll()) {
            _forgotPasswordViewModel.getIsVerifyLoading().setValue(true);

            Handler handler = new Handler();
            handler.postDelayed(
                    () -> {
                        _forgotPasswordViewModel.getIsVerifyLoading().setValue(false);

                        _authServiceHandler.checkEmailExists(_forgotPasswordViewModel.getEmail().getValue());
                    },
                    2000
            );
        }
    }

    private boolean isValidAll() {
        // Validate email is not empty
        String email = _forgotPasswordViewModel.getEmail().getValue();
        if (email.trim().isEmpty()) {
            _forgotPasswordViewModel.getIsEmailEmpty().setValue(true);
            return false;
        }
        _forgotPasswordViewModel.getIsEmailEmpty().setValue(false);

        // Validate email is valid
        String emailPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if (!email.matches(emailPattern)) {
            _forgotPasswordViewModel.getIsEmailValid().setValue(false);
            return false;
        }
        _forgotPasswordViewModel.getIsEmailValid().setValue(true);

        return true;
    }
}
