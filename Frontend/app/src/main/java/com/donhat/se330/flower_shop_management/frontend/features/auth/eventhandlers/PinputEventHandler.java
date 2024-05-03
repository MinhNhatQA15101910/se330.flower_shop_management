package com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.ChangePasswordFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.ForgotPasswordFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.PinputViewModel;

public class PinputEventHandler {
    private final Context _context;
    private final AuthViewModel _authViewModel;
    private final PinputViewModel _pinputViewModel;

    public PinputEventHandler(AuthViewModel authViewModel, PinputViewModel pinputViewModel, Context context) {
        _authViewModel = authViewModel;
        _pinputViewModel = pinputViewModel;
        _context = context;
    }

    public void navigateToForgotPasswordFragment(View view) {
        _authViewModel.getAuthFragment().setValue(new ForgotPasswordFragment());
    }

    public void verifyPincode(View view) {
        verifyPincode();
    }

    public void verifyPincode() {
        if (isValidAll()) {
            _pinputViewModel.getIsVerifyLoading().setValue(true);

            Handler handler = new Handler();
            handler.postDelayed(
                    () -> {
                        _pinputViewModel.getIsVerifyLoading().setValue(false);

                        _authViewModel.getAuthFragment().setValue(new ChangePasswordFragment());
                    },
                    2000
            );
        }
    }

    private boolean isValidAll() {
        String pincode = _pinputViewModel.getPincode().getValue();

        if (pincode.length() < 6) {
            Toast.makeText(_context, "Please complete the pincode.", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
