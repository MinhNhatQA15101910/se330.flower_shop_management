package com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.eventhandlers;

import android.content.Context;

import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.viewmodels.CartViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.viewmodels.CheckoutViewModel;

public class CheckoutEventHandler {
    private final CheckoutViewModel _checkoutViewModel;
    private final Context _context;

    public CheckoutEventHandler(CheckoutViewModel checkoutViewModel, Context context) {
        _checkoutViewModel = checkoutViewModel;
        _context = context;
    }
}
