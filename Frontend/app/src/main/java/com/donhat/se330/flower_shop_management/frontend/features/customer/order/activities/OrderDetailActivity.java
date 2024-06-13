package com.donhat.se330.flower_shop_management.frontend.features.customer.order.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityOrderDetailBinding;
import com.donhat.se330.flower_shop_management.frontend.features.components.adapters.ProductListOrderAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.adapters.CheckoutAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.eventhandlers.OrderDetailEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.viewmodel.OrderDetailViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Order;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class OrderDetailActivity extends AppCompatActivity {
    private ActivityOrderDetailBinding _activityOrderDetailBinding;
    private OrderDetailViewModel _orderDetailViewModel;
    private OrderDetailEventHandler _orderDetailEventHandlers;
    private Order _order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int orderId = (int) getIntent().getSerializableExtra("order");

        _activityOrderDetailBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_order_detail
        );
        _orderDetailViewModel = new ViewModelProvider(this).get(OrderDetailViewModel.class);
        _orderDetailEventHandlers = new OrderDetailEventHandler(_orderDetailViewModel, this);

        _orderDetailViewModel.setOrderId(orderId);

        _orderDetailEventHandlers.onInitial();


        _order = _orderDetailViewModel.getOrder().getValue();

        displayOrderDetail();



        /*GlobalVariables.getOrder().observe(this, order -> {
            _activityOrderDetailBinding.orderIdText.setText(order.getId());
            _activityOrderDetailBinding.orderDateText.setText(order.getOrderDate().toString());
            _activityOrderDetailBinding.orderIdText.setText(order.getId());
        });*/
    }

    private void displayOrderDetail() {
        _orderDetailViewModel.getOrder().observe(this, order -> {
            _order = order;
            _activityOrderDetailBinding.setOrder(_order);
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy", Locale.getDefault());
            String formattedDate = sdf.format(order.getOrderDate());
            _activityOrderDetailBinding.orderDateText.setText(formattedDate);
            _activityOrderDetailBinding.labelShipOrderDetail.setText(_order.getDetailAddress() + ", " + _order.getWard() + ", " + _order.getDistrict() + ", " + _order.getProvince());
            _activityOrderDetailBinding.labelShipDescriptionOrderDetail.setText(_order.getReceiverName() + " - " + _order.getReceiverPhoneNumber());
            _activityOrderDetailBinding.priceText.setText("$"+order.getProductPrice());
            _activityOrderDetailBinding.deliveryFeeText.setText("$"+order.getShippingPrice());
            double productPrice = Double.parseDouble(order.getProductPrice());
            double shippingPrice = Double.parseDouble(order.getShippingPrice());
            double totalPrice = productPrice + shippingPrice;
            String formattedTotalPrice = String.format("$%.2f", totalPrice);
            _activityOrderDetailBinding.totalPriceText.setText(formattedTotalPrice);



            RecyclerView productCheckoutItemRecyclerView = _activityOrderDetailBinding.orderDetailRecyclerView;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            productCheckoutItemRecyclerView.setLayoutManager(linearLayoutManager);
            productCheckoutItemRecyclerView.setHasFixedSize(true);

            ProductListOrderAdapter productListOrderAdapter = new ProductListOrderAdapter(_order, this);
            productCheckoutItemRecyclerView.setAdapter(productListOrderAdapter);
        });
    }


}
