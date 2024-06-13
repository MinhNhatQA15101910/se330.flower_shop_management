package com.donhat.se330.flower_shop_management.frontend.features.customer.cart.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ItemCartBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.servicehandlers.CartServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.models.Product;
import com.donhat.se330.flower_shop_management.frontend.models.User;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private final Context _context;
    private final User user;
    private final CartServiceHandler _cartServiceHandler;
    private OnProductDeleteListener deleteListener;

    public CartAdapter(User user, Context context ) {
        this.user = user;
        this._context = context;
        this._cartServiceHandler = new CartServiceHandler(_context);
    }

    public void setOnProductDeleteListener(OnProductDeleteListener listener) {
        this.deleteListener = listener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCartBinding _itemCartBinding = ItemCartBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CartViewHolder(_itemCartBinding);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        List<Product> productList = user.getProducts();
        if (productList == null || position >= productList.size()) {
            return;
        }
        Product product = productList.get(position);
        int quantity = user.getQuantities().get(position);

        List<String> imageUrls = product.getImageUrls();
        String firstUrl = null;
        if (imageUrls != null && !imageUrls.isEmpty()) {
            firstUrl = imageUrls.get(0);
        }

        // Load image using Glide
        Glide.with(_context)
                .load(firstUrl)
                .into(holder.itemCartBinding.itemImageListCart);

        holder.itemCartBinding.labelProductCart.setText(product.getName());
        holder.itemCartBinding.labelPriceCart.setText("$"+ product.getSalePrice());
        holder.itemCartBinding.inputValue.setText(String.valueOf(quantity));

        int stock = product.getStock();

        updateButtonStates(holder, quantity, stock);

        holder.itemCartBinding.increaseBox.setOnClickListener(v -> {
            int currentQuantity = Integer.parseInt(holder.itemCartBinding.inputValue.getText().toString());

            if (currentQuantity < stock) {
                int newQuantity = currentQuantity + 1;
                holder.itemCartBinding.inputValue.setText(String.valueOf(newQuantity));
                updateButtonStates(holder, newQuantity, stock);
                _cartServiceHandler.addToCart(product.getId());
            }
        });

        holder.itemCartBinding.decreaseBox.setOnClickListener(v -> {
            int currentQuantity = Integer.parseInt(holder.itemCartBinding.inputValue.getText().toString());

            if (currentQuantity > 1) {
                int newQuantity = currentQuantity - 1;
                holder.itemCartBinding.inputValue.setText(String.valueOf(newQuantity));
                updateButtonStates(holder, newQuantity, stock);
                _cartServiceHandler.removeFromCart(product.getId());
            }
        });

        holder.itemCartBinding.deleteProduct.setOnClickListener(v -> {
            if (deleteListener != null) {
                deleteListener.onProductDelete(position);
                _cartServiceHandler.deleteFromCart(product.getId());
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
        List<Product> productList = user.getProducts();
        return productList != null ? productList.size() : 0;
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        private final ItemCartBinding itemCartBinding;

        public CartViewHolder(@NonNull ItemCartBinding itemCartBinding) {
            super(itemCartBinding.getRoot());
            this.itemCartBinding = itemCartBinding;
        }
    }

    public interface OnProductDeleteListener {
        void onProductDelete(int position);
    }
}
