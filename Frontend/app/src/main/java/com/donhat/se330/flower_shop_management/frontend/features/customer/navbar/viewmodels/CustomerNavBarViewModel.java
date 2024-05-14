package com.donhat.se330.flower_shop_management.frontend.features.customer.navbar.viewmodels;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.LoginFragment;
import com.donhat.se330.flower_shop_management.frontend.features.customer.home.fragments.HomeFragment;

public class CustomerNavBarViewModel extends ViewModel {
    private MutableLiveData<Fragment> customerFragment = new MutableLiveData<>(new HomeFragment());
    public final MutableLiveData<Boolean> isHomeClicked = new MutableLiveData<>(true);
    public final MutableLiveData<Boolean> isCategoryClicked = new MutableLiveData<>(false);
    public final MutableLiveData<Boolean> isSearchClicked = new MutableLiveData<>(false);
    public final MutableLiveData<Boolean> isProfileClicked = new MutableLiveData<>(false);

    public MutableLiveData<Fragment> getCustomerFragment() {
        return customerFragment;
    }

    public MutableLiveData<Boolean> getIsHomeClicked() {
        return isHomeClicked;
    }

    public void setIsHomeClicked(boolean isClicked) {
        isHomeClicked.setValue(isClicked);
    }

    public MutableLiveData<Boolean> getIsCategoryClicked() {
        return isCategoryClicked;
    }

    public MutableLiveData<Boolean> getIsSearchClicked() {
        return isSearchClicked;
    }

    public MutableLiveData<Boolean> getIsProfileClicked() {
        return isProfileClicked;
    }
}
