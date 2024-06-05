package com.donhat.se330.flower_shop_management.frontend.features.customer.cart.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.donhat.se330.flower_shop_management.frontend.models.Cart;

import java.util.List;

public class CartViewModel extends ViewModel {
    final MutableLiveData<List<Cart>> cartList = new MutableLiveData<>();

}
