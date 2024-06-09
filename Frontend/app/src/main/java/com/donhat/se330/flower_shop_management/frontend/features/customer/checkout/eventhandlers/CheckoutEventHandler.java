package com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.eventhandlers;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities.ShippingInfo;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.fragments.BottomSheetAddressFragment;
import com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.servicehandlers.CheckoutServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.viewmodels.CheckoutViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Order;
import com.donhat.se330.flower_shop_management.frontend.models.Product;
import com.donhat.se330.flower_shop_management.frontend.models.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CheckoutEventHandler {
    private final CheckoutViewModel _checkoutViewModel;
    private final CheckoutServiceHandler _checkoutServiceHandler;
    private final Context _context;

    private final Activity _activity;

    public CheckoutEventHandler(CheckoutViewModel checkoutViewModel, Context context, Activity activity) {
        _checkoutViewModel = checkoutViewModel;
        _context = context;
        _activity = activity;
        _checkoutServiceHandler = new CheckoutServiceHandler(context);
    }

    public void onClickShippingInfoBox(View view) {
        FragmentActivity activity = (FragmentActivity) _context;

        BottomSheetAddressFragment bottomSheetAddressFragment = new BottomSheetAddressFragment();
        bottomSheetAddressFragment.show(activity.getSupportFragmentManager(), bottomSheetAddressFragment.getTag());
    }
    public void onNavigateBack(View view) {
        _activity.finish();
    }
    public void onCheckOutClick(View view) {
        User user = GlobalVariables.getUser().getValue();
        ShippingInfo shippingInfo = GlobalVariables.getShippingInfo().getValue();
        if (user != null && shippingInfo != null) {
            Order order = new Order();

            order.setProvince(shippingInfo.getProvinceName());
            order.setDistrict(shippingInfo.getDistrictName());
            order.setWard(shippingInfo.getWardName());
            order.setDetailAddress(shippingInfo.getStreet());
            order.setReceiverName(shippingInfo.getFullName());
            order.setReceiverPhoneNumber(shippingInfo.getPhoneNumber());
        }
    }
}
