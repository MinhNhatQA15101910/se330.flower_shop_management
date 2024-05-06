package com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers;

import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

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
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setCancelable(true)
                        .create()
                        .show();
            }
        }.start();
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
