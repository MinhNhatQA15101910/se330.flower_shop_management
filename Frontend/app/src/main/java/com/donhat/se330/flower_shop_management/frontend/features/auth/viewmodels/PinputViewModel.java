package com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PinputViewModel extends ViewModel {
    private final MutableLiveData<String> pincode = new MutableLiveData<>("");
    private final MutableLiveData<Boolean> isVerifyLoading = new MutableLiveData<>(false);

    public MutableLiveData<String> getPincode() {
        return pincode;
    }

    public MutableLiveData<Boolean> getIsVerifyLoading() {
        return isVerifyLoading;
    }
}
