package com.donhat.se330.flower_shop_management.frontend.features.customer.cart.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ItemCartBinding;
import com.donhat.se330.flower_shop_management.frontend.models.Cart;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private final Context _context;
    private final List<Cart> productCartList;

    public CartAdapter(List<Cart> productCartList, Context context) {
        this.productCartList = productCartList;
        this._context=context;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCartBinding _itemCartBinding = ItemCartBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CartViewHolder(_itemCartBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        Cart productCart = productCartList.get(position);
        if (productCart == null) {
            return;
        }
        Product product = new Product();
        Glide.with(_context).load(product.getImageUrls()).into(holder.itemCartBinding.itemImageListCart);
        holder.itemCartBinding.labelProductCart.setText(product.getName());
        holder.itemCartBinding.labelPriceCart.setText(String.valueOf(product.getPrice()));
        holder.itemCartBinding.inputValue.setText(String.valueOf(productCart.getQuantity()));

        int stock = product.getStock();

        updateButtonStates(holder, productCart.getQuantity(), stock);

        holder.itemCartBinding.increaseBox.setOnClickListener(v -> {
            int currentQuantity = Integer.parseInt(holder.itemCartBinding.inputValue.getText().toString());

            if (currentQuantity < stock) {
                int newQuantity = currentQuantity + 1;
                holder.itemCartBinding.inputValue.setText(String.valueOf(newQuantity));
                updateButtonStates(holder, newQuantity, stock);
                productCart.setQuantity(newQuantity);
            }
        });

        holder.itemCartBinding.decreaseBox.setOnClickListener(v -> {
            int currentQuantity = Integer.parseInt(holder.itemCartBinding.inputValue.getText().toString());

            if (currentQuantity > 1) {
                int newQuantity = currentQuantity - 1;
                holder.itemCartBinding.inputValue.setText(String.valueOf(newQuantity));
                updateButtonStates(holder, newQuantity, stock);
                productCart.setQuantity(newQuantity);
            }
        });
    }

    private void updateButtonStates(@NonNull CartViewHolder holder, int quantity, int stock) {
        if (quantity >= stock) {
            holder.itemCartBinding.increaseBox.setBackgroundResource(R.drawable.vector_increment_button_disable);
        } else {
            holder.itemCartBinding.increaseBox.setBackgroundResource(R.drawable.vector_increment_button_enable);
        }

        if (quantity <= 1) {
            holder.itemCartBinding.decreaseBox.setBackgroundResource(R.drawable.vector_decrement_button_disable);
        } else {
            holder.itemCartBinding.decreaseBox.setBackgroundResource(R.drawable.vector_decrement_button_enable);
        }
    }


    @Override
    public int getItemCount() {
        if (productCartList != null) {
            return productCartList.size();
        }
        return 0;
    }
    public static class CartViewHolder extends RecyclerView.ViewHolder {
        private final ItemCartBinding itemCartBinding;
        public CartViewHolder(@NonNull ItemCartBinding itemCartBinding) {
            super(itemCartBinding.getRoot());
            this.itemCartBinding = itemCartBinding;
        }
    }
}
