package com.donhat.se330.flower_shop_management.frontend.features.customer.home.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ItemBannerCardBinding;
import com.donhat.se330.flower_shop_management.frontend.models.Banner;
import java.util.ArrayList;

public class CarouselBannerAdapter extends RecyclerView.Adapter<CarouselBannerAdapter.CarouselViewHolder> {

    private ArrayList<Banner> _banners;

    public CarouselBannerAdapter(ArrayList<Banner> banners) {
        _banners = banners;
    }

    @NonNull
    @Override
    public CarouselViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBannerCardBinding itemBannerCardBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_banner_card, parent, false);
        return new CarouselViewHolder(itemBannerCardBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CarouselViewHolder holder, int position) {
        Banner currentBanner = _banners.get(position);
        holder._itemBannerCardBinding.setBanner(currentBanner);


        // Use Glide to load the image
        Glide.with(holder._itemBannerCardBinding.getRoot())
                .load(currentBanner.getImageUrl()) // replace with the method to get the image URL from the Banner object
                .into(holder._itemBannerCardBinding.imageCategory); // replace imageView with the actual ImageView id in your ItemBannerCardBinding
    }

    @Override
    public int getItemCount() {
        if (_banners != null)
            return _banners.size();
        return 0;
    }

    public static class CarouselViewHolder extends RecyclerView.ViewHolder {
        private final ItemBannerCardBinding _itemBannerCardBinding;

        public CarouselViewHolder(ItemBannerCardBinding itemBannerCardBinding) {
            super(itemBannerCardBinding.getRoot());
            _itemBannerCardBinding = itemBannerCardBinding;
        }
    }
}
