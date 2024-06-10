package com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.eventhandlers;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.servicehandlers.ProductListServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.viewmodels.ProductListViewModel;

public class ProductListEventHandler {

    private final Context _context;
    //private final Activity _activity;
    private final ProductListViewModel _productListViewModel;
    private final ProductListServiceHandler _productListServiceHandler;

    public ProductListEventHandler(Context context, ProductListViewModel productListViewModel) {
        _context = context;
        //_activity = activity;
        _productListViewModel = productListViewModel;
        _productListServiceHandler = new ProductListServiceHandler(context, _productListViewModel);

    }

    public void onInitial() {
        //_productListServiceHandler.getProduct();
        _productListViewModel.setListDoDProducts(_productListServiceHandler.getProduct());
    }

    public void onNavigateBack(View view) {
        ((Activity) _context).finish();
    }

}
