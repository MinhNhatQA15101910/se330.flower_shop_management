package com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityCheckoutBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.adapters.CheckoutAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.eventhandlers.CheckoutEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.viewmodels.CheckoutViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.Locale;

public class CheckoutActivity extends AppCompatActivity {
    private ActivityCheckoutBinding _activityCheckoutBinding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate the layout for this activity using DataBindingUtil
        _activityCheckoutBinding = DataBindingUtil.setContentView(this, R.layout.activity_checkout);

        // View Model
        CheckoutViewModel _checkoutViewModel = new ViewModelProvider(this).get(CheckoutViewModel.class);

        // Event Handler
        CheckoutEventHandler _checkoutEventHandler = new CheckoutEventHandler(_checkoutViewModel, this, this);
        _activityCheckoutBinding.setActivityCheckoutEventHandler(_checkoutEventHandler);

        GlobalVariables.getUser().observe(this, user -> {
            if(user != null){
                RecyclerView productCheckoutItemRecyclerView = _activityCheckoutBinding.recyclerViewCheckoutDetail;
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                productCheckoutItemRecyclerView.setLayoutManager(linearLayoutManager);
                productCheckoutItemRecyclerView.setHasFixedSize(true);

                CheckoutAdapter checkoutAdapter = new CheckoutAdapter(user, this);
                productCheckoutItemRecyclerView.setAdapter(checkoutAdapter);

                double subtotalPrice = 0;
                int index = 0;
                for (Product product : user.getProducts()) {
                    subtotalPrice += Double.parseDouble(product.getPrice()) * user.getQuantities().get(index);
                    index++;
                }
                String formattedSubtotalPrice = String.format(Locale.US, "%.2f", subtotalPrice);
                _activityCheckoutBinding.totalPriceOrderDetail.setText("$" + formattedSubtotalPrice);
                _activityCheckoutBinding.finalPriceOrderDetail.setText("$" + formattedSubtotalPrice);
                _activityCheckoutBinding.changeOrderStatusText.setText("Checkout $" + formattedSubtotalPrice);
            }
        });

        GlobalVariables.getShippingInfo().observe(this, shippingInfo -> {
            _activityCheckoutBinding.labelShipOrderDetail.setText(shippingInfo.getStreet()+checkEmpty(shippingInfo.getStreet(),", ")
                    +shippingInfo.getWardName()+checkEmpty(shippingInfo.getWardName(),", ")
                    +shippingInfo.getDistrictName()+checkEmpty(shippingInfo.getDistrictName(),", ")
                    +shippingInfo.getProvinceName());
            _activityCheckoutBinding.labelShipDescriptionOrderDetail.setText(shippingInfo.getFullName()+checkEmpty(shippingInfo.getFullName()," • ")
                    +shippingInfo.getPhoneNumber());
        });
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
    String checkEmpty(String string, String symbol){
        if(string==null || string.isEmpty()){
            return "";
        }
        else return symbol;
    }
}
