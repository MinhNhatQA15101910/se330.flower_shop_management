package com.donhat.se330.flower_shop_management.frontend.features.components.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ItemProductImageBinding;

import java.util.List;

public class ProductImageAdapter extends RecyclerView.Adapter<ProductImageAdapter.ProductImageViewHolder> {

    private List<String> _imagesUrl;

    public ProductImageAdapter(List<String> imagesUrl) {
        _imagesUrl = imagesUrl;
    }

    @NonNull
    @Override
    public ProductImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductImageBinding itemProductImageBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_product_image, parent, false);
        return new ProductImageViewHolder(itemProductImageBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductImageViewHolder holder, int position) {
        String currentImageUrl = _imagesUrl.get(position);

        // Use Glide to load the image
        Glide.with(holder._itemProductImageBinding.getRoot())
                .load(currentImageUrl)
                .into(holder._itemProductImageBinding.imageView);
    }

    @Override
    public int getItemCount() {
        if (_imagesUrl != null)
            return _imagesUrl.size();
        return 0;
    }

    public static class ProductImageViewHolder extends RecyclerView.ViewHolder {
        private final ItemProductImageBinding _itemProductImageBinding;

        public ProductImageViewHolder(ItemProductImageBinding itemProductImageBinding) {
            super(itemProductImageBinding.getRoot());
            _itemProductImageBinding = itemProductImageBinding;
        }
    }
}