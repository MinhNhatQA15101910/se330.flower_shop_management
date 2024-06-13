package com.donhat.se330.flower_shop_management.frontend.features.components.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ItemSingleProductCardBinding;
import com.donhat.se330.flower_shop_management.frontend.features.components.eventhandlers.ItemProductCardEventHandler;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.List;

public class ItemProductCardAdapter extends RecyclerView.Adapter<ItemProductCardAdapter.ProductViewHolder> {
    private List<Product> _products;
    private ItemProductCardEventHandler _itemProductCardEventHandler;

    public ItemProductCardAdapter(List<Product> products) {
        _products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSingleProductCardBinding itemSingleProductCardBinding = DataBindingUtil
                .inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.item_single_product_card,
                        parent,
                        false
                );
        _itemProductCardEventHandler = new ItemProductCardEventHandler(parent.getContext());
        itemSingleProductCardBinding.setProductEventHandler(_itemProductCardEventHandler);
        return new ProductViewHolder(itemSingleProductCardBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product currentProduct = _products.get(position);

        holder._itemSingleProductCardBinding.setProduct(currentProduct);
        _itemProductCardEventHandler.setProduct(currentProduct);
        //load image from url if available
        if (currentProduct.getImageUrls() != null && !currentProduct.getImageUrls().isEmpty()) {
            Glide.with(holder._itemSingleProductCardBinding.getRoot().getContext())
                    .load(currentProduct.getImageUrls().get(0))
                    .into(holder._itemSingleProductCardBinding.imageProduct);
        }
    }


    @Override
    public int getItemCount() {
        if (_products != null)
            return _products.size();
        return 0;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        private final ItemSingleProductCardBinding _itemSingleProductCardBinding;

        public ProductViewHolder(ItemSingleProductCardBinding itemSingleProductCardBinding) {
            super(itemSingleProductCardBinding.getRoot());
            _itemSingleProductCardBinding = itemSingleProductCardBinding;
        }
    }
}
