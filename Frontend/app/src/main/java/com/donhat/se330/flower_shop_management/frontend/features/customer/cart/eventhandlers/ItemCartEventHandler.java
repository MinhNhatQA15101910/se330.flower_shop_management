package com.donhat.se330.flower_shop_management.frontend.features.customer.cart.eventhandlers;

import android.content.Context;
import android.view.View;

import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.viewmodels.ItemCartViewModel;

public class ItemCartEventHandler {
    private final ItemCartViewModel _itemCartViewModel;
    private final Context _context;

    public ItemCartEventHandler(ItemCartViewModel itemCartViewModel, Context context) {
        _itemCartViewModel = itemCartViewModel;
        _context = context;
    }

    public void onIncrementButtonClick(View view) {
        _itemCartViewModel.getCurrentQuantity().setValue(_itemCartViewModel.getCurrentQuantity().getValue()+1);
    }


}

