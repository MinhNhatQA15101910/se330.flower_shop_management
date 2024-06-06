package com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.donhat.se330.flower_shop_management.frontend.databinding.ItemProductCheckoutBinding;
import com.donhat.se330.flower_shop_management.frontend.models.Product;
import com.donhat.se330.flower_shop_management.frontend.models.User;

import java.util.List;

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.CheckoutViewHolder> {
    private final Context _context;
    private final User user;

    public CheckoutAdapter(User user, Context context) {
        this.user = user;
        this._context = context;
    }

    @NonNull
    @Override
    public CheckoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductCheckoutBinding _itemProductCheckoutBinding = ItemProductCheckoutBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CheckoutViewHolder(_itemProductCheckoutBinding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CheckoutViewHolder holder, int position) {
        List<Product> productList = user.getProducts();
        if (productList == null || position >= productList.size()) {
            return;
        }

        Product product = productList.get(position);
        int quantity = user.getQuantities().get(position);
        Glide.with(_context).load(product.getImageUrls()).into(holder.itemProductCheckoutBinding.itemImageProduct);
        holder.itemProductCheckoutBinding.labelProductName.setText(product.getName());
        holder.itemProductCheckoutBinding.labelQuantityPrice.setText(quantity + " x " + product.getPrice());
    }

    @Override
    public int getItemCount() {
        List<Product> productList = user.getProducts();
        return productList != null ? productList.size() : 0;
    }

    public static class CheckoutViewHolder extends RecyclerView.ViewHolder {
        private final ItemProductCheckoutBinding itemProductCheckoutBinding;

        public CheckoutViewHolder(@NonNull ItemProductCheckoutBinding itemProductCheckoutBinding) {
            super(itemProductCheckoutBinding.getRoot());
            this.itemProductCheckoutBinding = itemProductCheckoutBinding;
        }
    }
}
