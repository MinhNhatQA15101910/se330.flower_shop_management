package com.donhat.se330.flower_shop_management.frontend.features.welcome.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WelcomeViewModel extends ViewModel {
    private final MutableLiveData<Integer> fragmentIndex = new MutableLiveData<>(0);

    public MutableLiveData<Integer> getFragmentIndex() {
        return fragmentIndex;
    }
}
