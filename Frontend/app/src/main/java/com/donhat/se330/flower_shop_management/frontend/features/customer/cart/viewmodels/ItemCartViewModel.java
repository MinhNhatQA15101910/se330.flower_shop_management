package com.donhat.se330.flower_shop_management.frontend.features.customer.cart.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemCartViewModel extends ViewModel {
    private MutableLiveData<Integer> currentQuantity = new MutableLiveData<>(0);

    public MutableLiveData<Integer> getCurrentQuantity() {
        return currentQuantity;
    }
}
