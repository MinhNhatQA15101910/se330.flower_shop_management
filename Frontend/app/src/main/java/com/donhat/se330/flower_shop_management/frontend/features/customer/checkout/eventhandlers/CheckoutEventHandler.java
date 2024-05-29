package com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.eventhandlers;

import android.content.Context;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.fragments.BottomSheetAddressFragment;
import com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.viewmodels.CheckoutViewModel;

public class CheckoutEventHandler {
    private final CheckoutViewModel _checkoutViewModel;
    private final Context _context;

    public CheckoutEventHandler(CheckoutViewModel checkoutViewModel, Context context) {
        _checkoutViewModel = checkoutViewModel;
        _context = context;
    }

    public void onClickShippingInfoBox(View view) {
        FragmentActivity activity = (FragmentActivity) _context;

        BottomSheetAddressFragment bottomSheetAddressFragment = new BottomSheetAddressFragment();
        bottomSheetAddressFragment.show(activity.getSupportFragmentManager(), bottomSheetAddressFragment.getTag());
    }
}
