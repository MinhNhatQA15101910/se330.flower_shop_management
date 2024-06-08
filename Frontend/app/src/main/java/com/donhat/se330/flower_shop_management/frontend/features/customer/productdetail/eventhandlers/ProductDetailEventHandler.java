package com.donhat.se330.flower_shop_management.frontend.features.customer.productdetail.eventhandlers;

import android.content.Context;

import com.donhat.se330.flower_shop_management.frontend.features.customer.productdetail.servicehandlers.ProductDetailServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productdetail.viewmodels.ProductDetailViewModel;

public class ProductDetailEventHandler {
    private final ProductDetailViewModel _productDetailViewModel;
    private final ProductDetailServiceHandler _productDetailServiceHandler;

    public ProductDetailEventHandler(Context context, ProductDetailViewModel _productDetailViewModel) {
        this._productDetailViewModel = _productDetailViewModel;
        this._productDetailServiceHandler = new ProductDetailServiceHandler(context, _productDetailViewModel);
    }

    public void onInitial() {
        int productId = _productDetailViewModel.getProductId();
        _productDetailServiceHandler.getProductFromId(productId);

        _productDetailViewModel.setSuggestProducts(_productDetailServiceHandler.getRecommendProducts());
    }
}
