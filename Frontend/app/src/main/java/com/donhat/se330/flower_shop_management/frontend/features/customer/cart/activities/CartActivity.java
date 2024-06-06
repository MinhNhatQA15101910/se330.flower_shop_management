package com.donhat.se330.flower_shop_management.frontend.features.customer.cart.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityCartBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.adapters.CartAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.eventhandlers.CartEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.viewmodels.CartViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Product;
import com.donhat.se330.flower_shop_management.frontend.models.User;

import java.util.Locale;

public class CartActivity extends AppCompatActivity implements CartAdapter.OnProductDeleteListener {
    private CartAdapter cartAdapter;
    private ActivityCartBinding _activityCartBinding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout for this activity using DataBindingUtil
        _activityCartBinding = DataBindingUtil.setContentView(this, R.layout.activity_cart);

        // View Model
        CartViewModel _cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);

        // Event Handler
        CartEventHandler _cartEventHandler = new CartEventHandler(this , _cartViewModel, this);
        _activityCartBinding.setActivityCartEventHandler(_cartEventHandler);

        // Set up RecyclerView

        GlobalVariables.getUser().observe(this, user -> {
            if(user != null){
                RecyclerView cartItemRecyclerView = _activityCartBinding.cartItemRecyclerView;
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                cartItemRecyclerView.setLayoutManager(linearLayoutManager);
                cartItemRecyclerView.setHasFixedSize(true);

                cartAdapter = new CartAdapter(user, this);
                cartAdapter.setOnProductDeleteListener(this);
                cartItemRecyclerView.setAdapter(cartAdapter);

                double subtotalPrice = 0;
                int index = 0;
                for (Product product : user.getProducts()) {
                    subtotalPrice += product.getPrice() * user.getQuantities().get(index);
                    index++;
                }
                String formattedSubtotalPrice = String.format(Locale.US, "%.2f", subtotalPrice);
                _activityCartBinding.suptotalPriceText.setText("$" + formattedSubtotalPrice);


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
