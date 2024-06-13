package com.donhat.se330.flower_shop_management.frontend.features.customer.profile.eventhandlers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.features.auth.activities.AuthActivity;
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
    public void onLogOutClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(_context);
        builder.setTitle("Confirm Logout");
        builder.setMessage("Are you sure you want to logout?");

        builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Perform logout
                Intent intent = new Intent(_context, AuthActivity.class);
                _context.startActivity(intent);
                ((Activity) _context).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Cancelled logout
                dialog.dismiss(); // Dismiss the dialog
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
