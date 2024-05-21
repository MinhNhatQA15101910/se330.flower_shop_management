package com.donhat.se330.flower_shop_management.frontend.features.customer.cart.eventhandlers;

import android.content.Context;

import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.viewmodels.CartViewModel;

public class CartEventHandler {
    private final CartViewModel _cartViewModel;
    private final Context _context;

    public CartEventHandler(CartViewModel cartViewModel, Context context) {
        _cartViewModel = cartViewModel;
        _context = context;
    }

}

