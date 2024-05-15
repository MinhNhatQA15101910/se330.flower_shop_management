package com.donhat.se330.flower_shop_management.frontend.features.customer.category.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.donhat.se330.flower_shop_management.frontend.databinding.ItemCategoryBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.category.entities.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private final Context _context;
    private final List<Category> categoryList;

    public CategoryAdapter(List<Category> categoryList, Context context) {
        this.categoryList = categoryList;
        this._context=context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoryBinding _itemCategoryBinding = ItemCategoryBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CategoryViewHolder(_itemCategoryBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categoryList.get(position);
        if(category==null){
            return;

        }

        Glide.with(_context).load(category.getImgPath()).into(holder.itemCategoryBinding.itemImageCategory);
        holder.itemCategoryBinding.labelCategory.setText(category.getName());
    }

    @Override
    public int getItemCount() {
        if (categoryList != null) {
            return categoryList.size();
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
