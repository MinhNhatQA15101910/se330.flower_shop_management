package com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers;

import android.os.Handler;
import android.view.View;

import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.ForgotPasswordFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.LoginFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.PinputFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.ForgotPasswordViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.PinputViewModel;

public class PinputEventHandler {
    private final AuthViewModel _authViewModel;
    private final PinputViewModel _pinputViewModel;

    public PinputEventHandler(AuthViewModel authViewModel, PinputViewModel pinputViewModel) {
        _authViewModel = authViewModel;
        _pinputViewModel = pinputViewModel;
    }

    public void navigateToForgotPasswordFragment(View view) {
        _authViewModel.getAuthFragment().setValue(new ForgotPasswordFragment());
    }

//    public void verifyPincode(View view) {
//        if (isValidAll()) {
//            _forgotPasswordViewModel.getIsVerifyLoading().setValue(true);
//
//            Handler handler = new Handler();
//            handler.postDelayed(
//                    () -> {
//                        _forgotPasswordViewModel.getIsVerifyLoading().setValue(false);
//
//                        _authViewModel.getResentEmail().setValue(_forgotPasswordViewModel.getEmail().getValue());
//                        _authViewModel.getAuthFragment().setValue(new PinputFragment());
//                    },
//                    2000
//            );
//        }
//    }
//
//    private boolean isValidAll() {
//        // Validate email is not empty
//        String pincode = _pinputViewModel.getPincode().getValue();
//
//        return true;
//    }
}
