package com.donhat.se330.flower_shop_management.frontend.features.customer.home.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ItemSingleCategoryCardBinding;
import com.donhat.se330.flower_shop_management.frontend.models.Category;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    ArrayList<Category> _categories;

    public CategoryAdapter(ArrayList<Category> categories) {
        _categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSingleCategoryCardBinding itemSingleCategoryCardBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_single_category_card, parent, false);
        return new CategoryViewHolder(itemSingleCategoryCardBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category currentCategory = _categories.get(position);
        holder._itemSingleCategoryCardBinding.setCategory(currentCategory);
    }

    @Override
    public int getItemCount() {
        if(_categories != null)
            return _categories.size();
        return 0;
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        private final ItemSingleCategoryCardBinding _itemSingleCategoryCardBinding;
        public CategoryViewHolder(ItemSingleCategoryCardBinding itemSingleCategoryCardBinding) {
            super(itemSingleCategoryCardBinding.getRoot());
            _itemSingleCategoryCardBinding = itemSingleCategoryCardBinding;
        }
    }
}
