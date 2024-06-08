package com.donhat.se330.flower_shop_management.frontend.features.customer.productdetail.eventhandlers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.activities.CartActivity;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productdetail.servicehandlers.ProductDetailServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productdetail.viewmodels.ProductDetailViewModel;

public class ProductDetailEventHandler {
    private final Context context;
    private final Activity activity;
    private final ProductDetailViewModel productDetailViewModel;
    private final ProductDetailServiceHandler productDetailServiceHandler;

    public ProductDetailEventHandler(ProductDetailViewModel productDetailViewModel, Context context, Activity activity) {
        this.productDetailViewModel = productDetailViewModel;
        this.context = context;
        this.activity = activity;
        this.productDetailServiceHandler = new ProductDetailServiceHandler(context, productDetailViewModel);
    }

    public void onInitial() {
        int productId = productDetailViewModel.getProductId();
        if (productId > 0) {
            productDetailServiceHandler.getProductFromId(productId);
            productDetailViewModel.setSuggestProducts(productDetailServiceHandler.getRecommendProducts());
        }
    }

    public void addToCart(View view) {
        int productId = productDetailViewModel.getProductId();
        if (productId > 0) {
            productDetailServiceHandler.addToCart(productId);
            Toast.makeText(context, "Product added to cart successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    public void buyNow(View view) {
        int productId = productDetailViewModel.getProductId();
        if (productId > 0) {
            productDetailServiceHandler.addToCart(productId);
            Intent intent = new Intent(context, CartActivity.class);
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }

    public void onNavigateBack(View view) {
        activity.finish();
    }

    public void navigateToCartActivity(View view) {
        Intent intent = new Intent(context, CartActivity.class);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
