package com.donhat.se330.flower_shop_management.frontend.features.customer.search.eventhandlers;

import android.view.View;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class FilterBtmSheetEventHandler {
    private final BottomSheetDialogFragment bottomSheetDialogFragment;

    public FilterBtmSheetEventHandler(BottomSheetDialogFragment bottomSheetDialogFragment) {
        this.bottomSheetDialogFragment = bottomSheetDialogFragment;
    }

    public void onCloseIconClick(View view){
        //Close the bottom sheet dialog
        if (bottomSheetDialogFragment != null) {
            bottomSheetDialogFragment.dismiss();
        }
    }
}
