package com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers;

import android.content.Context;
import android.os.Handler;
import android.view.View;

import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.LoginFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.servicehandlers.AuthServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.SignUpViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Product;
import com.donhat.se330.flower_shop_management.frontend.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SignUpEventHandler {
    private final AuthViewModel _authViewModel;
    private final SignUpViewModel _signUpViewModel;
    private final AuthServiceHandler _authServiceHandler;

    public SignUpEventHandler(Context context, AuthViewModel authViewModel, SignUpViewModel signUpViewModel) {
        _authViewModel = authViewModel;
        _signUpViewModel = signUpViewModel;
        _authServiceHandler = new AuthServiceHandler(context, authViewModel);
    }

    public void navigateToLoginFragment(View view) {
        _authViewModel.getAuthFragment().setValue(new LoginFragment());
    }

    public void navigateToPinputFragment(View view) {
        if (isValidAll()) {
            _signUpViewModel.getIsSignUpLoading().setValue(true);

            Handler handler = new Handler();
            handler.postDelayed(
                    () -> {
                        SignUpViewModel.signUpUser = new User(
                                0,
                                _signUpViewModel.getUsername().getValue(),
                                _signUpViewModel.getEmail().getValue(),
                                _signUpViewModel.getPassword().getValue(),
                                "",
                                "",
                                "",
                                new ArrayList<>(),
                                new ArrayList<>()
                        );

                        _authServiceHandler.checkEmailExistsToSignUp(
                                _signUpViewModel.getEmail().getValue()
                        );

                        _signUpViewModel.getIsSignUpLoading().setValue(false);
                    },
                    2000
            );
        }
    }

    private boolean isValidAll() {
        String email = _signUpViewModel.getEmail().getValue();
        String username = _signUpViewModel.getUsername().getValue();
        String password = _signUpViewModel.getPassword().getValue();
        String passwordConfirmed = _signUpViewModel.getPasswordConfirmed().getValue();
        boolean isValidAll = true;

        // Validate email is not empty
        if (Objects.requireNonNull(email).trim().isEmpty()) {
            _signUpViewModel.getIsPasswordEmpty().setValue(true);
            isValidAll = false;
        } else {
            _signUpViewModel.getIsPasswordEmpty().setValue(false);
        }

        // Validate email is valid
        String emailPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if (!email.matches(emailPattern)) {
            _signUpViewModel.getIsEmailValid().setValue(false);
            isValidAll = false;
        } else {
            _signUpViewModel.getIsEmailValid().setValue(true);
        }

        // Validate username is not empty
        if (Objects.requireNonNull(username).trim().isEmpty()) {
            _signUpViewModel.getIsUsernameEmpty().setValue(true);
            isValidAll = false;
        } else {
            _signUpViewModel.getIsUsernameEmpty().setValue(false);
        }

        // Validate username length is valid
        if (username.trim().length() < 6) {
            _signUpViewModel.getIsUsernameLengthValid().setValue(false);
            isValidAll = false;
        } else {
            _signUpViewModel.getIsUsernameLengthValid().setValue(true);
        }

        // Validate password is not empty
        if (Objects.requireNonNull(password).trim().isEmpty()) {
            _signUpViewModel.getIsPasswordEmpty().setValue(true);
            isValidAll = false;
        } else {
            _signUpViewModel.getIsPasswordEmpty().setValue(false);
        }

        // Validate password length is valid
        if (password.trim().length() < 8) {
            _signUpViewModel.getIsPasswordLengthValid().setValue(false);
            isValidAll = false;
        } else {
            _signUpViewModel.getIsPasswordLengthValid().setValue(true);
        }

        // Validate password confirmed is not empty
        if (Objects.requireNonNull(passwordConfirmed).trim().isEmpty()) {
            _signUpViewModel.getIsPasswordConfirmedEmpty().setValue(true);
            isValidAll = false;
        } else {
            _signUpViewModel.getIsPasswordConfirmedEmpty().setValue(false);
        }

        // Validate password is match
        if (!passwordConfirmed.equals(password)) {
            _signUpViewModel.getIsPasswordMatch().setValue(false);
            isValidAll = false;
        } else {
            _signUpViewModel.getIsPasswordMatch().setValue(true);
        }

        return isValidAll;
    }
}
