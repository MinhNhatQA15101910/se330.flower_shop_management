package com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.donhat.se330.flower_shop_management.frontend.models.User;

public class SignUpViewModel extends ViewModel {
    private final MutableLiveData<String> email = new MutableLiveData<>("");
    private final MutableLiveData<String> username = new MutableLiveData<>("");
    private final MutableLiveData<String> password = new MutableLiveData<>("");
    private final MutableLiveData<String> passwordConfirmed = new MutableLiveData<>("");

    private final MutableLiveData<Boolean> isEmailEmpty = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isEmailValid = new MutableLiveData<>(true);
    private final MutableLiveData<Boolean> isUsernameEmpty = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isUsernameLengthValid = new MutableLiveData<>(true);
    private final MutableLiveData<Boolean> isPasswordEmpty = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isPasswordLengthValid = new MutableLiveData<>(true);
    private final MutableLiveData<Boolean> isPasswordConfirmedEmpty = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isPasswordMatch = new MutableLiveData<>(true);

    private final MutableLiveData<Boolean> isSignUpLoading = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isSignUpWithGoogleLoading = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isContinueAsAGuessLoading = new MutableLiveData<>(false);

    public static User signUpUser = new User();

    public MutableLiveData<String> getEmail() {
        return email;
    }

    public MutableLiveData<Boolean> getIsEmailEmpty() {
        return isEmailEmpty;
    }

    public MutableLiveData<Boolean> getIsEmailValid() {
        return isEmailValid;
    }

    public MutableLiveData<String> getUsername() {
        return username;
    }

    public MutableLiveData<String> getPassword() {
        return password;
    }

    public MutableLiveData<String> getPasswordConfirmed() {
        return passwordConfirmed;
    }

    public MutableLiveData<Boolean> getIsUsernameEmpty() {
        return isUsernameEmpty;
    }

    public MutableLiveData<Boolean> getIsUsernameLengthValid() {
        return isUsernameLengthValid;
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

    public MutableLiveData<Boolean> getIsSignUpLoading() {
        return isSignUpLoading;
    }

    public MutableLiveData<Boolean> getIsSignUpWithGoogleLoading() {
        return isSignUpWithGoogleLoading;
    }

    public MutableLiveData<Boolean> getIsContinueAsAGuessLoading() {
        return isContinueAsAGuessLoading;
    }
}
