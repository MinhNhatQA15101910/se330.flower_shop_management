package com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.eventhandlers;

import android.content.Context;

import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.servicehandlers.ProductListServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.viewmodels.ProductListViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.List;

public class ProductListEventHandler {
    private final Context _context;
    private final ProductListViewModel _productListViewModel;
    private final ProductListServiceHandler _productListServiceHandler;

    public ProductListEventHandler(Context context, ProductListViewModel productListViewModel) {
        _context = context;
        _productListViewModel = productListViewModel;
        _productListServiceHandler = new ProductListServiceHandler(context);
    }

    public List<Product> getProduct() {
        List<Product> products = _productListServiceHandler.getProduct().getValue();
        if (products != null) {
            _productListViewModel.setListDoDProducts(_productListServiceHandler.getProduct().getValue());
        }
        return products;
    }

}
