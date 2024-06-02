package com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers;

import android.content.Context;
import android.os.Handler;
import android.view.View;

import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.ForgotPasswordFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.LoginFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.SignUpFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.servicehandlers.AuthServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.LoginViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.SignUpViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.User;

import java.util.ArrayList;
import java.util.Objects;

public class LoginEventHandler {
    private final Context _context;
    private final AuthViewModel _authViewModel;
    private final LoginViewModel _loginViewModel;
    private final AuthServiceHandler _authServiceHandler;

    public LoginEventHandler(Context context, AuthViewModel authViewModel, LoginViewModel loginViewModel) {
        _context = context;
        _authViewModel = authViewModel;
        _loginViewModel = loginViewModel;
        _authServiceHandler = new AuthServiceHandler(context, authViewModel);
    }

    public void navigateToSignUpFragment(View view) {
        _authViewModel.getAuthFragment().setValue(new SignUpFragment());
    }

    public void navigateToForgotPasswordFragment(View view) {
        _authViewModel.setPreviousFragment(new LoginFragment());
        _authViewModel.getAuthFragment().setValue(new ForgotPasswordFragment());
    }

    public void login(View view) {
        if (isValidAll()) {
            _loginViewModel.getIsLoginLoading().setValue(true);

            Handler handler = new Handler();
            handler.postDelayed(
                    () -> {
                        _authServiceHandler.loginUser(
                                Objects.requireNonNull(_loginViewModel.getEmail().getValue()).trim(),
                                Objects.requireNonNull(_loginViewModel.getPassword().getValue()).trim()
                        );

                        _loginViewModel.getIsLoginLoading().setValue(false);
                    },
                    2000
            );
        }
    }

    private boolean isValidAll() {
        String email = Objects.requireNonNull(_loginViewModel.getEmail().getValue()).trim();
        String password = Objects.requireNonNull(_loginViewModel.getPassword().getValue()).trim();
        boolean isValidAll = true;

        // Validate email is not empty
        if (Objects.requireNonNull(email).trim().isEmpty()) {
            _loginViewModel.getIsPasswordEmpty().setValue(true);
            isValidAll = false;
        } else {
            _loginViewModel.getIsPasswordEmpty().setValue(false);
        }

        // Validate email is valid
        String emailPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if (!email.matches(emailPattern)) {
            _loginViewModel.getIsEmailValid().setValue(false);
            isValidAll = false;
        } else {
            _loginViewModel.getIsEmailValid().setValue(true);
        }

        // Validate password is not empty
        if (Objects.requireNonNull(password).trim().isEmpty()) {
            _loginViewModel.getIsPasswordEmpty().setValue(true);
            isValidAll = false;
        } else {
            _loginViewModel.getIsPasswordEmpty().setValue(false);
        }

        // Validate password length is valid
        if (password.trim().length() < 8) {
            _loginViewModel.getIsPasswordLengthValid().setValue(false);
            isValidAll = false;
        } else {
            _loginViewModel.getIsPasswordLengthValid().setValue(true);
        }

        return isValidAll;
    }
}
