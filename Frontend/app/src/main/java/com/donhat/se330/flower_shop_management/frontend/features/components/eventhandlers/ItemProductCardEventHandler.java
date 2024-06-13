package com.donhat.se330.flower_shop_management.frontend.features.components.eventhandlers;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.lifecycle.MutableLiveData;

import com.donhat.se330.flower_shop_management.frontend.features.customer.productdetail.activities.ProductDetailActivity;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.Objects;

public class ItemProductCardEventHandler {

    private final MutableLiveData<Product> _product = new MutableLiveData<>();
    Context _context;

    public ItemProductCardEventHandler(Context context) {
        _context = context;
    }

    public void setProduct(Product product) {
        _product.setValue(product);
    }

    public void onProductClick(View view) {
        Intent intent = new Intent(view.getContext(), ProductDetailActivity.class);
        intent.putExtra("product", Objects.requireNonNull(_product.getValue()).getId());
        view.getContext().startActivity(intent);
    }

}
