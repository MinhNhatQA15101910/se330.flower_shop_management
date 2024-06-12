package com.donhat.se330.flower_shop_management.frontend.features.customer.rating.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityRatingBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.rating.eventhandlers.RatingEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.rating.viewmodels.RatingViewModels;

public class RatingActivity extends AppCompatActivity {
    private ActivityRatingBinding activityRatingBinding;
    private RatingViewModels ratingViewModels;
    private RatingEventHandler ratingEventHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRatingBinding = DataBindingUtil.setContentView(this, R.layout.activity_rating);

        ratingViewModels = new ViewModelProvider(this).get(RatingViewModels.class);

        ratingEventHandler = new RatingEventHandler(this, ratingViewModels);
    }
}
