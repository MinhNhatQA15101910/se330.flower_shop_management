package com.donhat.se330.flower_shop_management.frontend.features.customer.profile.eventhandlers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.activities.CheckoutActivity;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.activities.OrderManagementActivity;

public class ProfileEventHandler {
    private final Context _context;

    public ProfileEventHandler(Context context) {
        _context = context;
    }

    public void navigateToOrderManagement(View view){
        Intent intent = new Intent(_context, OrderManagementActivity.class);
        _context.startActivity(intent);
        ((Activity) _context).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
