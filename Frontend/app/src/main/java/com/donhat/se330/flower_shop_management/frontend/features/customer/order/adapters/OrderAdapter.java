package com.donhat.se330.flower_shop_management.frontend.features.customer.order.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ItemOrderCardBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.activities.CartActivity;
import com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.activities.CheckoutActivity;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.activities.OrderDetailActivity;
import com.donhat.se330.flower_shop_management.frontend.features.welcome.activities.WelcomeActivity;
import com.donhat.se330.flower_shop_management.frontend.models.Order;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private final Context context;
    private final List<Order> orderList;

    public OrderAdapter(List<Order> orderList, Context context) {
        this.orderList = orderList;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderAdapter.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemOrderCardBinding itemOrderCardBinding = ItemOrderCardBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new OrderAdapter.OrderViewHolder(itemOrderCardBinding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.OrderViewHolder holder, int position) {
        Order order = orderList.get(position);

        // Set status layout and text color based on order status
        switch (order.getStatus()) {
            case "Pending":
                holder.itemOrderCardBinding.statusLayout.setBackgroundResource(R.drawable.light_yellow_badge);
                holder.itemOrderCardBinding.statusText.setTextColor(ContextCompat.getColor(context, R.color.darkYellow));
                break;
            case "In delivery":
                holder.itemOrderCardBinding.statusLayout.setBackgroundResource(R.drawable.light_blue_badge);
                holder.itemOrderCardBinding.statusText.setTextColor(ContextCompat.getColor(context, R.color.darkBlue));
                break;
            case "Delivered":
                holder.itemOrderCardBinding.statusLayout.setBackgroundResource(R.drawable.light_green_badge);
                holder.itemOrderCardBinding.statusText.setTextColor(ContextCompat.getColor(context, R.color.darkGreen));
                break;
            default:
                holder.itemOrderCardBinding.statusLayout.setBackgroundResource(R.drawable.light_red_badge);
                holder.itemOrderCardBinding.statusText.setTextColor(ContextCompat.getColor(context, R.color.darkRed));
                break;
        }
        holder.itemOrderCardBinding.statusText.setText(order.getStatus());

        // Set product details if available
        if (order.getProducts() != null && !order.getProducts().isEmpty()) {
            String productPromoteName = order.getProducts().get(0).getName();
            holder.itemOrderCardBinding.productNameText.setText(productPromoteName);

            double price = order.getProducts().get(0).getPrice();
            int quantity = !order.getQuantities().isEmpty() ? order.getQuantities().get(0) : 0;
            holder.itemOrderCardBinding.textProductPrice.setText(quantity + " x $" + price);

            if (!order.getProducts().get(0).getImageUrls().isEmpty()) {
                Glide.with(context)
                        .load(order.getProducts().get(0).getImageUrls().get(0))
                        .into(holder.itemOrderCardBinding.imageProduct);
            }
        }

        // Set click listener for order card
        holder.itemOrderCardBinding.itemOrderCard.setOnClickListener(v -> {
            Intent intent = new Intent(context, OrderDetailActivity.class);
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
    }

    @Override
    public int getItemCount() {
        return orderList != null ? orderList.size() : 0;
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        private final ItemOrderCardBinding itemOrderCardBinding;

        public OrderViewHolder(@NonNull ItemOrderCardBinding itemOrderCardBinding) {
            super(itemOrderCardBinding.getRoot());
            this.itemOrderCardBinding = itemOrderCardBinding;
        }
    }
}
