package com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.ChangePasswordFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.ForgotPasswordFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.servicehandlers.AuthServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.PinputViewModel;

import java.util.Objects;

public class PinputEventHandler {
    private final Context _context;
    private final AuthViewModel _authViewModel;
    private final PinputViewModel _pinputViewModel;
    private final AuthServiceHandler _authServiceHandler;

    public PinputEventHandler(AuthViewModel authViewModel, PinputViewModel pinputViewModel, Context context) {
        _authViewModel = authViewModel;
        _pinputViewModel = pinputViewModel;
        _context = context;
        _authServiceHandler = new AuthServiceHandler(context, authViewModel);

        new CountDownTimer(60000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                _pinputViewModel.getRemainingSeconds().setValue(
                        _pinputViewModel.getRemainingSeconds().getValue() - 1
                );
            }

            @Override
            public void onFinish() {
                _authViewModel.getAuthFragment().setValue(new ForgotPasswordFragment());

                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(_context);
                dlgAlert.setTitle("Email verify timeout")
                        .setMessage("You must enter your verify code before the time is over.")
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .setCancelable(true)
                        .create()
                        .show();
            }
        }.start();

        if (!_pinputViewModel.isNavigatingBack()) {
            _authServiceHandler.sendVerifyEmail(
                    _authViewModel.getResentEmail().getValue(),
                    _pinputViewModel.getActualPincode()
            );
        }
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
                        String userPincode = _pinputViewModel.getPincode().getValue();
                        String actualPincode = _pinputViewModel.getActualPincode();

                        if (!Objects.equals(userPincode, actualPincode)) {
                            Toast.makeText(_context, "Incorrect pincode.", Toast.LENGTH_SHORT).show();
                        } else {
                            _authViewModel.getAuthFragment().setValue(new ChangePasswordFragment());
                        }

                        _pinputViewModel.getIsVerifyLoading().setValue(false);
                    },
                    2000
            );
        }
    }

    private boolean isValidAll() {
        String pincode = _pinputViewModel.getPincode().getValue();

        if (Objects.requireNonNull(pincode).length() < 6) {
            Toast.makeText(_context, "Please complete the pincode.", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
