package com.donhat.se330.flower_shop_management.frontend.features.components.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.donhat.se330.flower_shop_management.frontend.databinding.ItemCategoryBinding;
import com.donhat.se330.flower_shop_management.frontend.features.components.eventhandlers.ItemCategoryEventHandler;
import com.donhat.se330.flower_shop_management.frontend.models.Type;

import java.util.List;

public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.CategoryViewHolder> {
    private final Context _context;
    private final List<Type> typeList;

    private ItemCategoryEventHandler _itemCategoryEventHandler;

    public TypeAdapter(List<Type> typeList, Context context) {
        _context = context;
        this.typeList = typeList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoryBinding _itemCategoryBinding = ItemCategoryBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        _itemCategoryEventHandler = new ItemCategoryEventHandler(parent.getContext());
        return new CategoryViewHolder(_itemCategoryBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Type type = typeList.get(position);
        if(type==null){
            return;
        }
        _itemCategoryEventHandler.setTitle(type.getName());

        Glide.with(_context).load(type.getImageUrl()).into(holder.itemCategoryBinding.itemImageCategory);
        holder.itemCategoryBinding.labelCategory.setText(type.getName());
    }

    @Override
    public int getItemCount() {
        if (typeList != null) {
            return typeList.size();
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