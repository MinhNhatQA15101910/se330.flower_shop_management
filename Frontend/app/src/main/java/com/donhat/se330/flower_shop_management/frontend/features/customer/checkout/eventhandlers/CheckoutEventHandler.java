package com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.eventhandlers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities.ShippingInfo;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.fragments.BottomSheetAddressFragment;
import com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.servicehandlers.CheckoutServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.viewmodels.CheckoutViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.customer.rating.activities.RatingActivity;
import com.donhat.se330.flower_shop_management.frontend.models.Order;
import com.donhat.se330.flower_shop_management.frontend.models.User;

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
        ShippingInfo shippingInfo = GlobalVariables.getShippingInfo().getValue();
        if(shippingInfo != null){
            User user = GlobalVariables.getUser().getValue();
            if (user != null) {
                Order order = new Order();
                order.setProvince(shippingInfo.getProvinceName());
                order.setDistrict(shippingInfo.getDistrictName());
                order.setWard(shippingInfo.getWardName());
                order.setDetailAddress(shippingInfo.getStreet());
                order.setReceiverName(shippingInfo.getFullName());
                order.setReceiverPhoneNumber(shippingInfo.getPhoneNumber());
                _checkoutServiceHandler.createOrderFromCart(order);
                ((Activity) _context).finish();
            }

        }
        else {
            Toast.makeText(_context, "Please type your shipping information", Toast.LENGTH_SHORT).show();
        }

    }
}
