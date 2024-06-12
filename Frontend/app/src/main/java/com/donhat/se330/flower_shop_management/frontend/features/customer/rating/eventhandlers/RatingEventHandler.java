package com.donhat.se330.flower_shop_management.frontend.features.customer.rating.eventhandlers;

import android.content.Context;

import com.donhat.se330.flower_shop_management.frontend.features.customer.rating.viewmodels.RatingViewModels;

public class RatingEventHandler {
    Context context;
    RatingViewModels ratingViewModels;

    public RatingEventHandler(Context context, RatingViewModels ratingViewModels) {
        this.context = context;
        this.ratingViewModels = ratingViewModels;
    }
}
