package com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    private final MutableLiveData<String> email = new MutableLiveData<>("");
    private final MutableLiveData<String> password = new MutableLiveData<>("");

    private final MutableLiveData<Boolean> isEmailEmpty = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isEmailValid = new MutableLiveData<>(true);
    private final MutableLiveData<Boolean> isPasswordEmpty = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isPasswordLengthValid = new MutableLiveData<>(true);

    private final MutableLiveData<Boolean> isLoginLoading = new MutableLiveData<>(false);

    public MutableLiveData<String> getEmail() {
        return email;
    }

    public MutableLiveData<String> getPassword() {
        return password;
    }

    public MutableLiveData<Boolean> getIsEmailEmpty() {
        return isEmailEmpty;
    }

    public MutableLiveData<Boolean> getIsEmailValid() {
        return isEmailValid;
    }

    public MutableLiveData<Boolean> getIsPasswordEmpty() {
        return isPasswordEmpty;
    }

    public MutableLiveData<Boolean> getIsPasswordLengthValid() {
        return isPasswordLengthValid;
    }

    public MutableLiveData<Boolean> getIsLoginLoading() {
        return isLoginLoading;
    }
}
