package com.donhat.se330.flower_shop_management.frontend.features.customer.cart.eventhandlers;

import android.content.Context;
import android.view.View;

import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.viewmodel.CartViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.customer.category.viewmodels.CategoryViewModel;

public class CartEventHandler {
    private final CartViewModel _cartViewModel;
    private final Context _context;

    public CartEventHandler(CartViewModel cartViewModel, Context context) {
        _cartViewModel = cartViewModel;
        _context = context;
    }

}

