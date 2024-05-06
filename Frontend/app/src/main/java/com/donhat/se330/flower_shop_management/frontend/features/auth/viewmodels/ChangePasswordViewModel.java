package com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ChangePasswordViewModel extends ViewModel {
    private final MutableLiveData<String> password = new MutableLiveData<>("");
    private final MutableLiveData<String> passwordConfirmed = new MutableLiveData<>("");
    private final MutableLiveData<Boolean> isPasswordEmpty = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isPasswordLengthValid = new MutableLiveData<>(true);
    private final MutableLiveData<Boolean> isPasswordConfirmedEmpty = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isPasswordMatch = new MutableLiveData<>(true);
    private final MutableLiveData<Boolean> isUpdateLoading = new MutableLiveData<>(false);

    public MutableLiveData<String> getPassword() {
        return password;
    }

    public MutableLiveData<String> getPasswordConfirmed() {
        return passwordConfirmed;
    }

    public MutableLiveData<Boolean> getIsPasswordEmpty() {
        return isPasswordEmpty;
    }

    public MutableLiveData<Boolean> getIsPasswordLengthValid() {
        return isPasswordLengthValid;
    }

    public MutableLiveData<Boolean> getIsPasswordConfirmedEmpty() {
        return isPasswordConfirmedEmpty;
    }

    public MutableLiveData<Boolean> getIsPasswordMatch() {
        return isPasswordMatch;
    }

    public MutableLiveData<Boolean> getIsUpdateLoading() {
        return isUpdateLoading;
    }
}
