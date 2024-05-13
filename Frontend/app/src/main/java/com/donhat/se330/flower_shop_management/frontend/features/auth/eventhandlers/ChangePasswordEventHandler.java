package com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers;

import android.content.Context;
import android.os.Handler;
import android.view.View;

import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.LoginFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.PinputFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.ChangePasswordViewModel;

public class ChangePasswordEventHandler {
    private final ChangePasswordViewModel _changePasswordViewModel;
    private final AuthViewModel _authViewModel;

    public ChangePasswordEventHandler(AuthViewModel authViewModel, ChangePasswordViewModel changePasswordViewModel) {
        _changePasswordViewModel = changePasswordViewModel;
        _authViewModel = authViewModel;
    }

    public void navigateToPinputFragment(View view) {
        _authViewModel.getAuthFragment().setValue(new PinputFragment());
    }

    public void changePassword(View view) {
        if (isValidAll()) {
            _changePasswordViewModel.getIsUpdateLoading().setValue(true);

            Handler handler = new Handler();
            handler.postDelayed(
                    () -> {
                        // TODO: Update password

                        _changePasswordViewModel.getIsUpdateLoading().setValue(false);

                        _authViewModel.getAuthFragment().setValue(new LoginFragment());
                    },
                    2000
            );
        }
    }

    private boolean isValidAll() {
        String password = _changePasswordViewModel.getPassword().getValue();
        String passwordConfirmed = _changePasswordViewModel.getPasswordConfirmed().getValue();
        boolean isValidAll = true;

        if (password.trim().isEmpty()) {
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

        if (passwordConfirmed.trim().isEmpty()) {
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
