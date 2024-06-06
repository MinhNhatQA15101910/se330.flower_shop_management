package com.donhat.se330.flower_shop_management.frontend.features.customer.cart.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.constants.enums.Size;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.adapters.CartAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.eventhandlers.CartEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.viewmodels.CartViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Product;
import com.donhat.se330.flower_shop_management.frontend.models.User;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity implements CartAdapter.OnProductDeleteListener {
    private CartAdapter cartAdapter;
    private com.donhat.se330.flower_shop_management.frontend.databinding.ActivityCartBinding _activityCartBinding;
    private CartViewModel _cartViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout for this activity using DataBindingUtil
        _activityCartBinding = DataBindingUtil.setContentView(this, R.layout.activity_cart);

        // View Model
        _cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);

        // Event Handler
        CartEventHandler _cartEventHandler = new CartEventHandler(this ,_cartViewModel, this);
        _activityCartBinding.setActivityCartEventHandler(_cartEventHandler);

        // Set up RecyclerView

        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Rose Bouquet", 25.99, 20.99, 0.2, "Beautiful bouquet of roses", Size.MEDIUM, 0.5f, "Red", "Silk", 50, 20, 4.5f, 100,null));
        productList.add(new Product(2, "Tulip Bouquet", 20.99, 18.99, 0.1, "Colorful bouquet of tulips", Size.SMALL, 0.4f, "Mixed", "Plastic", 30, 15, 4.2f, 80,null));
        productList.add(new Product(3, "Sunflower Bouquet", 22.99, 19.99, 0.15, "Bright bouquet of sunflowers", Size.LARGE, 0.6f, "Yellow", "Paper", 40, 25, 4.7f, 120,null));
        List<Integer> quantityList = new ArrayList<>();
        quantityList.add(1);
        quantityList.add(2);
        quantityList.add(3);
        GlobalVariables.getUser().getValue().setProducts(productList);
        GlobalVariables.getUser().getValue().setQuantities(quantityList);

        GlobalVariables.getUser().observe(this, user -> {
            if(user != null){
                RecyclerView cartItemRecyclerView = _activityCartBinding.cartItemRecyclerView;
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                cartItemRecyclerView.setLayoutManager(linearLayoutManager);
                cartItemRecyclerView.setHasFixedSize(true);

                cartAdapter = new CartAdapter(user, this);
                cartAdapter.setOnProductDeleteListener(this);
                cartItemRecyclerView.setAdapter(cartAdapter);
            }
        });
    }

    @Override
    public void onProductDelete(int position) {
        // Get the user from GlobalVariables
        User user = GlobalVariables.getUser().getValue();
        if (user != null) {
            // Remove the product and quantity at the specified position
            user.getProducts().remove(position);
            user.getQuantities().remove(position);

            // Notify the adapter about the item removed
            cartAdapter.notifyItemRemoved(position);
            cartAdapter.notifyItemRangeChanged(position, user.getProducts().size());
            _activityCartBinding.cartItemRecyclerView.requestLayout();
        }
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
