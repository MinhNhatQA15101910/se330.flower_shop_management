package com.donhat.se330.flower_shop_management.frontend.features.customer.cart.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityCartBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.adapters.CartAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.entities.ProductCart;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.eventhandlers.CartEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.viewmodels.CartViewModel;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    private ActivityCartBinding _activityCartBinding;
    private CartViewModel _cartViewModel;
    private CartEventHandler _cartEventHandler;
    private List<ProductCart> productCartList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout for this activity using DataBindingUtil
        _activityCartBinding = DataBindingUtil.setContentView(this, R.layout.activity_cart);

        // View Model
        _cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);

        // Event Handler
        _cartEventHandler = new CartEventHandler(_cartViewModel, this);
        _activityCartBinding.setActivityCartEventHandler(_cartEventHandler);

        // Set up RecyclerView
        RecyclerView cartItemRecyclerView = _activityCartBinding.cartItemRecyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        cartItemRecyclerView.setLayoutManager(linearLayoutManager);
        cartItemRecyclerView.setHasFixedSize(true);

        // Add sample data to productCartList
        productCartList = addProductCart();

        // Set up the adapter
        CartAdapter cartAdapter = new CartAdapter(productCartList, this);
        cartItemRecyclerView.setAdapter(cartAdapter);
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
