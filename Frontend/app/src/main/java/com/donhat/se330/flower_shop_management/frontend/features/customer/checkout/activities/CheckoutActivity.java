package com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityCheckoutBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.entities.ProductCart;
import com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.adapters.CheckoutAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.eventhandlers.CheckoutEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.viewmodels.CheckoutViewModel;

import java.util.ArrayList;
import java.util.List;

public class CheckoutActivity extends AppCompatActivity {
    private ActivityCheckoutBinding _activityCheckoutBinding;
    private CheckoutViewModel _checkoutViewModel;
    private CheckoutEventHandler _checkoutEventHandler;
    private List<ProductCart> productCartList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout for this activity using DataBindingUtil
        _activityCheckoutBinding = DataBindingUtil.setContentView(this, R.layout.activity_checkout);

        // View Model
        _checkoutViewModel = new ViewModelProvider(this).get(CheckoutViewModel.class);

        // Event Handler
        _checkoutEventHandler = new CheckoutEventHandler(_checkoutViewModel, this);
        _activityCheckoutBinding.setActivityCheckoutEventHandler(_checkoutEventHandler);

        // Set up RecyclerView
        RecyclerView productCheckoutItemRecyclerView = _activityCheckoutBinding.recyclerViewCheckoutDetail;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        productCheckoutItemRecyclerView.setLayoutManager(linearLayoutManager);
        productCheckoutItemRecyclerView.setHasFixedSize(true);

        // Add sample data to productCartList
        productCartList = addProductCart();

        // Set up the adapter
        CheckoutAdapter checkoutAdapter = new CheckoutAdapter(productCartList, this);
        productCheckoutItemRecyclerView.setAdapter(checkoutAdapter);
    }

    private List<ProductCart> addProductCart() {
        List<ProductCart> productCarts = new ArrayList<>();
        productCarts.add(new ProductCart(1, "Product 1", "@drawable/img_product1", 19.99, 2));
        productCarts.add(new ProductCart(2, "Product 2", "@drawable/img_product2", 29.99, 1));
        productCarts.add(new ProductCart(3, "Product 3", "@drawable/img_product3", 39.99, 3));
        productCarts.add(new ProductCart(4, "Product 4", "@drawable/img_product4", 49.99, 1));
        productCarts.add(new ProductCart(5, "Product 5", "@drawable/img_product5", 59.99, 2));
        return productCarts;
    }
}