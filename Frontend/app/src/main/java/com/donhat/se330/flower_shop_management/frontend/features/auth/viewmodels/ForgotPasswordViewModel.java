package com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ForgotPasswordViewModel extends ViewModel {
    private final MutableLiveData<String> email = new MutableLiveData<>("");
    private final MutableLiveData<Boolean> isEmailEmpty = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isEmailValid = new MutableLiveData<>(true);

    public MutableLiveData<String> getEmail() {
        return email;
    }

    public MutableLiveData<Boolean> getIsEmailEmpty() {
        return isEmailEmpty;
    }

    public MutableLiveData<Boolean> getIsEmailValid() {
        return isEmailValid;
    }
}
