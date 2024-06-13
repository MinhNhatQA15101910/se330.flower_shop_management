package com.donhat.se330.flower_shop_management.frontend.features.components.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ItemBannerCardBinding;
import com.donhat.se330.flower_shop_management.frontend.models.Banner;

import java.util.List;

public class ItemBannerAdapter extends RecyclerView.Adapter<ItemBannerAdapter.CarouselViewHolder> {

    private List<Banner> _banners;

    public ItemBannerAdapter(List<Banner> banners) {
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

        //Glide.with(_context).load(productCart.getImgURL()).into(holder.itemCartBinding.itemImageListCart);
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
