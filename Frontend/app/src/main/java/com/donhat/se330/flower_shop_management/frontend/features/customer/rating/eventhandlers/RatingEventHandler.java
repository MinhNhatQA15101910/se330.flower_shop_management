package com.donhat.se330.flower_shop_management.frontend.features.customer.rating.eventhandlers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.activities.CartActivity;
import com.donhat.se330.flower_shop_management.frontend.features.customer.rating.servicehandlers.RatingServiceHandlers;
import com.donhat.se330.flower_shop_management.frontend.features.customer.rating.viewmodels.RatingViewModels;

public class RatingEventHandler {
    private Context context;
    private RatingViewModels ratingViewModels;
    private RatingServiceHandlers ratingServiceHandlers;

    public RatingEventHandler(Context context, RatingViewModels ratingViewModels) {
        this.context = context;
        this.ratingViewModels = ratingViewModels;
        this.ratingServiceHandlers = new RatingServiceHandlers(context, ratingViewModels);
    }

    public void onInitial() {
        int productId = ratingViewModels.getProductId();
        if (productId > 0) {
            ratingServiceHandlers.getProductFromId(productId);
        }
    }

    public void onNavigateBack(View view) {
        ((Activity) context).finish();
    }

    public void onNavigateToCart(View view) {
        // Navigate to cart
        Intent intent = new Intent(context, CartActivity.class);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }
}
