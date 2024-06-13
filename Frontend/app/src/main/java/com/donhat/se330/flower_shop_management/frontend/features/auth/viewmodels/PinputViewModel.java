package com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels;

import android.os.CountDownTimer;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class PinputViewModel extends ViewModel {
    private final MutableLiveData<String> pincode = new MutableLiveData<>("");
    private final MutableLiveData<Boolean> isVerifyLoading = new MutableLiveData<>(false);
    private final MutableLiveData<Integer> remainingSeconds = new MutableLiveData<>(60);

    private CountDownTimer countDownTimer;
    private final String actualPincode = generateRandomNumberString();

    public static boolean isNavigatingBack = false;
    public static boolean isSigningIn = false;

    public MutableLiveData<String> getPincode() {
        return pincode;
    }

    public MutableLiveData<Boolean> getIsVerifyLoading() {
        return isVerifyLoading;
    }

    public MutableLiveData<Integer> getRemainingSeconds() {
        return remainingSeconds;
    }

    public String getActualPincode() {
        return actualPincode;
    }

    public CountDownTimer getCountDownTimer() {
        return countDownTimer;
    }

    public void setCountDownTimer(CountDownTimer countDownTimer) {
        this.countDownTimer = countDownTimer;
    }

    private static String generateRandomNumberString() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }

        return sb.toString();
    }
}
