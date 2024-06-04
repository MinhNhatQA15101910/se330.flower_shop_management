package com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers;

import static com.donhat.se330.flower_shop_management.frontend.constants.utils.Utils.displayErrorToast;
import static com.donhat.se330.flower_shop_management.frontend.constants.utils.Utils.displayInfoToast;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.ChangePasswordFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.ForgotPasswordFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.LoginFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.PinputFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.servicehandlers.AuthServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.PinputViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.SignUpViewModel;

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

        CountDownTimer countDownTimer;
        countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                _pinputViewModel.getRemainingSeconds().setValue(
                        _pinputViewModel.getRemainingSeconds().getValue() - 1
                );
            }

            @Override
            public void onFinish() {
                _authViewModel.getAuthFragment().setValue(new ForgotPasswordFragment());
                _authViewModel.setPreviousFragment(new LoginFragment());

                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(_context);
                dlgAlert.setTitle("Email verify timeout")
                        .setMessage("You must enter your verify code before the time is over")
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                        .setCancelable(true)
                        .create()
                        .show();
            }
        }.start();
        _pinputViewModel.setCountDownTimer(countDownTimer);

        if (!PinputViewModel.isNavigatingBack) {
            _authServiceHandler.sendVerifyEmail(
                    _authViewModel.getResentEmail().getValue(),
                    _pinputViewModel.getActualPincode()
            );
        }
    }

    public void navigateToPreviousFragment(View view) {
        CountDownTimer countDownTimer = _pinputViewModel.getCountDownTimer();
        countDownTimer.cancel();
        _pinputViewModel.setCountDownTimer(countDownTimer);

        _authViewModel.getAuthFragment().setValue(_authViewModel.getPreviousFragment());
        _authViewModel.setPreviousFragment(new LoginFragment());
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
                            displayErrorToast(_context, "Incorrect pincode");
                        } else {
                            CountDownTimer countDownTimer = _pinputViewModel.getCountDownTimer();
                            countDownTimer.cancel();
                            _pinputViewModel.setCountDownTimer(countDownTimer);

                            if (PinputViewModel.isSigningIn) {
                                _authServiceHandler.signUpUser(
                                        SignUpViewModel.signUpUser.getUsername(),
                                        SignUpViewModel.signUpUser.getEmail(),
                                        SignUpViewModel.signUpUser.getPassword()
                                );
                            } else {
                                _authViewModel.getAuthFragment().setValue(new ChangePasswordFragment());
                                _authViewModel.setPreviousFragment(new PinputFragment());
                            }
                        }

                        _pinputViewModel.getIsVerifyLoading().setValue(false);
                    },
                    2000
            );
        }
    }

    public void resendEmail(View view) {
        _authServiceHandler.sendVerifyEmail(
                _authViewModel.getResentEmail().getValue(),
                _pinputViewModel.getActualPincode()
        );
    }

    private boolean isValidAll() {
        String pincode = _pinputViewModel.getPincode().getValue();

        if (Objects.requireNonNull(pincode).length() < 6) {
            displayInfoToast(_context, "Please complete the pincode");
            return false;
        }

        return true;
    }
}
