package com.donhat.se330.flower_shop_management.frontend.features.components.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.donhat.se330.flower_shop_management.frontend.databinding.ItemCategoryBinding;
import com.donhat.se330.flower_shop_management.frontend.features.components.eventhandlers.ItemCategoryEventHandler;
import com.donhat.se330.flower_shop_management.frontend.models.Occasion;

import java.util.List;

public class OccasionAdapter extends RecyclerView.Adapter<OccasionAdapter.CategoryViewHolder> {
    private final Context _context;
    private final List<Occasion> occasionList;
    private ItemCategoryEventHandler _itemCategoryEventHandler;

    public OccasionAdapter(List<Occasion> occasionList, Context context) {
        this.occasionList = occasionList;
        this._context=context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewOccasion) {
        ItemCategoryBinding _itemCategoryBinding = ItemCategoryBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        _itemCategoryEventHandler = new ItemCategoryEventHandler(_context);
        return new CategoryViewHolder(_itemCategoryBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Occasion occasion = occasionList.get(position);
        if(occasion==null){
            return;
        }
        _itemCategoryEventHandler.setTitle(occasion.getName());

        Glide.with(_context).load(occasion.getImageUrl()).into(holder.itemCategoryBinding.itemImageCategory);
        holder.itemCategoryBinding.labelCategory.setText(occasion.getName());
    }

    @Override
    public int getItemCount() {
        if (occasionList != null) {
            return occasionList.size();
        }
        return 0;
    }
    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        private final ItemCategoryBinding itemCategoryBinding;
        public CategoryViewHolder(@NonNull ItemCategoryBinding itemCategoryBinding) {
            super(itemCategoryBinding.getRoot());
            this.itemCategoryBinding = itemCategoryBinding;
        }
    }
}

