package com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.eventhandlers;

import android.content.Context;

import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.servicehandlers.ProductListServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.viewmodels.ProductListViewModel;

public class ProductListEventHandler {
    private final ProductListViewModel _productListViewModel;
    private final ProductListServiceHandler _productListServiceHandler;

    public ProductListEventHandler(Context context, ProductListViewModel productListViewModel) {
        _productListViewModel = productListViewModel;
        _productListServiceHandler = new ProductListServiceHandler(context, _productListViewModel);
    }

    public void onInitial() {
        //_productListServiceHandler.getProduct();
        _productListViewModel.setListDoDProducts(_productListServiceHandler.getProduct());
    }

}
