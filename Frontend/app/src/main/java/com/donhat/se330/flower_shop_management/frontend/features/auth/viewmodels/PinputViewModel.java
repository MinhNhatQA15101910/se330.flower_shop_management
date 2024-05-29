package com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class PinputViewModel extends ViewModel {
    private final MutableLiveData<String> pincode = new MutableLiveData<>("");
    private final MutableLiveData<Boolean> isVerifyLoading = new MutableLiveData<>(false);
    private final MutableLiveData<Integer> remainingSeconds = new MutableLiveData<>(60);

    public final String actualPincode = generateRandomNumberString();
    public boolean isNavigatingBack;

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

    public boolean isNavigatingBack() {
        return isNavigatingBack;
    }

    public void setNavigatingBack(boolean navigatingBack) {
        isNavigatingBack = navigatingBack;
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
