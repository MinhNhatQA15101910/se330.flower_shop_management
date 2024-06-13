package com.donhat.se330.flower_shop_management.frontend.features.components.eventhandlers;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.activities.ProductListActivity;

public class ItemCategoryEventHandler {
    private final MutableLiveData<String> _title = new MutableLiveData<>();
    Context _context;

    public ItemCategoryEventHandler(Context context) {
        _context = context;
    }

    public void setTitle(String title) {
        _title.setValue(title);
    }

    public void onCategoryClick(View view) {
        Intent intent = new Intent(view.getContext(), ProductListActivity.class);
        intent.putExtra("title", _title.getValue());
        view.getContext().startActivity(intent);
    }
}
