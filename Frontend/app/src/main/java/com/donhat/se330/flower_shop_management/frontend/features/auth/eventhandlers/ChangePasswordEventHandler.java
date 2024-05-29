package com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers;

import android.content.Context;
import android.os.Handler;
import android.view.View;

import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.PinputFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.servicehandlers.AuthServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.ChangePasswordViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.PinputViewModel;

import java.util.Objects;

public class ChangePasswordEventHandler {
    private final ChangePasswordViewModel _changePasswordViewModel;
    private final AuthViewModel _authViewModel;
    private final AuthServiceHandler _authServiceHandler;

    public ChangePasswordEventHandler(AuthViewModel authViewModel, ChangePasswordViewModel changePasswordViewModel, Context context) {
        _changePasswordViewModel = changePasswordViewModel;
        _authViewModel = authViewModel;
        _authServiceHandler = new AuthServiceHandler(context, authViewModel);
    }

    public void navigateToPinputFragment(View view) {
        PinputViewModel.isNavigatingBack = true;
        _authViewModel.getAuthFragment().setValue(new PinputFragment());
    }

    public void changePassword(View view) {
        if (isValidAll()) {
            _changePasswordViewModel.getIsUpdateLoading().setValue(true);

            Handler handler = new Handler();
            handler.postDelayed(
                    () -> {
                        _authServiceHandler.changePassword(
                                _authViewModel.getResentEmail().getValue(),
                                _changePasswordViewModel.getPassword().getValue()
                        );

                        _changePasswordViewModel.getIsUpdateLoading().setValue(false);
                    },
                    2000
            );
        }
    }

    private boolean isValidAll() {
        String password = _changePasswordViewModel.getPassword().getValue();
        String passwordConfirmed = _changePasswordViewModel.getPasswordConfirmed().getValue();
        boolean isValidAll = true;

        if (Objects.requireNonNull(password).trim().isEmpty()) {
            _changePasswordViewModel.getIsPasswordEmpty().setValue(true);
            isValidAll = false;
        } else {
            _changePasswordViewModel.getIsPasswordEmpty().setValue(false);
        }

        if (password.trim().length() < 8) {
            _changePasswordViewModel.getIsPasswordLengthValid().setValue(false);
            isValidAll = false;
        } else {
            _changePasswordViewModel.getIsPasswordLengthValid().setValue(true);
        }

        if (Objects.requireNonNull(passwordConfirmed).trim().isEmpty()) {
            _changePasswordViewModel.getIsPasswordConfirmedEmpty().setValue(true);
            isValidAll = false;
        } else {
            _changePasswordViewModel.getIsPasswordConfirmedEmpty().setValue(false);
        }

        if (!passwordConfirmed.equals(password)) {
            _changePasswordViewModel.getIsPasswordMatch().setValue(false);
            isValidAll = false;
        } else {
            _changePasswordViewModel.getIsPasswordMatch().setValue(true);
        }

        return isValidAll;
    }
}
