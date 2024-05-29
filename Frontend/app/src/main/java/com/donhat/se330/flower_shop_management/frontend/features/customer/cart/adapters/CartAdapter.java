package com.donhat.se330.flower_shop_management.frontend.features.customer.cart.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.donhat.se330.flower_shop_management.frontend.databinding.ItemCartBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.entities.ProductCart;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private final Context _context;
    private final List<ProductCart> productCartList;

    public CartAdapter(List<ProductCart> productCartList, Context context) {
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
        ProductCart productCart = productCartList.get(position);
        if(productCart==null){
            return;
        }

        Glide.with(_context).load(productCart.getImgURL()).into(holder.itemCartBinding.itemImageListCart);
        holder.itemCartBinding.labelProductCart.setText(productCart.getProductName());
        holder.itemCartBinding.labelPriceCart.setText(String.valueOf(productCart.getPrice()));
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
