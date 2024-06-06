package com.donhat.se330.flower_shop_management.frontend.features.customer.cart.eventhandlers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.activities.CartActivity;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.viewmodels.CartViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.activities.CheckoutActivity;

public class CartEventHandler {
    private final Context _context;
    private final Activity _activity;

    public CartEventHandler(Context context, CartViewModel cartViewModel, Activity activity) {
        _context=context;
        _activity = activity;
    }

    public void onNavigateBack(View view) {
        _activity.finish();
    }
    public void navigateToCheckout(View view) {
        Intent intent = new Intent(_context, CheckoutActivity.class);
        _context.startActivity(intent);
        ((Activity) _context).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}


