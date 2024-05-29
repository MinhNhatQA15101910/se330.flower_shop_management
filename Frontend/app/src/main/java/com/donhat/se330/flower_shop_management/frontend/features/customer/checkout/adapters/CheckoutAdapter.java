package com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.donhat.se330.flower_shop_management.frontend.databinding.ItemProductCheckoutBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.entities.ProductCart;

import java.util.List;

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.CheckoutViewHolder> {
    private final Context _context;
    private final List<ProductCart> productCartList;

    public CheckoutAdapter(List<ProductCart> productCartList, Context context) {
        this.productCartList = productCartList;
        this._context=context;
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
        ProductCart productCart = productCartList.get(position);
        if(productCart==null){
            return;
        }

        Glide.with(_context).load(productCart.getImgURL()).into(holder.itemProductCheckoutBinding.itemImageProduct);
        holder.itemProductCheckoutBinding.labelProductName.setText(productCart.getProductName());
        holder.itemProductCheckoutBinding.labelQuantityPrice.setText(productCart.getQuantity() +" x "+ productCart.getPrice());
    }

    @Override
    public int getItemCount() {
        if (productCartList != null) {
            return productCartList.size();
        }
        return 0;
    }
    public static class CheckoutViewHolder extends RecyclerView.ViewHolder {
        private final ItemProductCheckoutBinding itemProductCheckoutBinding;
        public CheckoutViewHolder(@NonNull ItemProductCheckoutBinding itemProductCheckoutBinding) {
            super(itemProductCheckoutBinding.getRoot());
            this.itemProductCheckoutBinding = itemProductCheckoutBinding;
        }
    }
}
