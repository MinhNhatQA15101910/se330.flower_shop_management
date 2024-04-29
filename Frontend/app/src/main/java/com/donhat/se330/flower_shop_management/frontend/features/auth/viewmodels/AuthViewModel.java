package com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.LoginFragment;

public class AuthViewModel extends ViewModel {
    private final MutableLiveData<Fragment> authFragment = new MutableLiveData<>(new LoginFragment());

    public MutableLiveData<Fragment> getAuthFragment() {
        return authFragment;
    }
}
