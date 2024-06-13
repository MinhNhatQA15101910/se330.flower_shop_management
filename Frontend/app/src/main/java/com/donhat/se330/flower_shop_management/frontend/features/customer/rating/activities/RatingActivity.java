package com.donhat.se330.flower_shop_management.frontend.features.customer.rating.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityRatingBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.rating.eventhandlers.RatingEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.rating.viewmodels.RatingViewModels;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

public class RatingActivity extends AppCompatActivity {
    private Product _product;
    private ActivityRatingBinding activityRatingBinding;
    private RatingViewModels ratingViewModels;
    private RatingEventHandler ratingEventHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int productId = (int) getIntent().getSerializableExtra("product");

        activityRatingBinding = DataBindingUtil.setContentView(this, R.layout.activity_rating);

        ratingViewModels = new ViewModelProvider(this).get(RatingViewModels.class);

        ratingEventHandler = new RatingEventHandler(this, ratingViewModels);

        activityRatingBinding.setRatingViewModel(ratingViewModels);
        activityRatingBinding.setRatingEventHandler(ratingEventHandler);

        ratingViewModels.setProductId(productId);
        ratingEventHandler.onInitial();

        _product = ratingViewModels.getProduct().getValue();

        displayProductDetail();
    }

    private void displayProductDetail() {
        // Display product detail
        ratingViewModels.getProduct().observe(this, product -> {
            _product = product;
            activityRatingBinding.ratingBar.setRating(Float.parseFloat(_product.getRatingAvg()));
            activityRatingBinding.setProduct(_product);

            Glide.with(this)
                    .load(_product.getImageUrls().get(0))
                    .into(activityRatingBinding.productImage);
        });
    }

}
