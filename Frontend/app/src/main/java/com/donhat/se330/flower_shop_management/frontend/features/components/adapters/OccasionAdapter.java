package com.donhat.se330.flower_shop_management.frontend.features.components.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.donhat.se330.flower_shop_management.frontend.databinding.ItemCategoryBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.activities.ProductListActivity;
import com.donhat.se330.flower_shop_management.frontend.models.Occasion;

import java.util.List;

public class OccasionAdapter extends RecyclerView.Adapter<OccasionAdapter.OccasionViewHolder> {
    private final Context context;
    private final List<Occasion> occasionList;

    public OccasionAdapter(List<Occasion> occasionList, Context context) {
        this.occasionList = occasionList;
        this.context = context;
    }

    @NonNull
    @Override
    public OccasionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoryBinding itemCategoryBinding = ItemCategoryBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new OccasionViewHolder(itemCategoryBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull OccasionViewHolder holder, int position) {
        Occasion occasion = occasionList.get(position);
        if (occasion == null) {
            return;
        }

        holder.itemCategoryBinding.labelCategory.setText(occasion.getName());
        Glide.with(context).load(occasion.getImageUrl()).into(holder.itemCategoryBinding.itemImageCategory);

        holder.itemCategoryBinding.categoryItem.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), ProductListActivity.class);
            intent.putExtra("title", occasion.getName());
            v.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return occasionList != null ? occasionList.size() : 0;
    }

    public static class OccasionViewHolder extends RecyclerView.ViewHolder {
        private final ItemCategoryBinding itemCategoryBinding;

        public OccasionViewHolder(@NonNull ItemCategoryBinding itemCategoryBinding) {
            super(itemCategoryBinding.getRoot());
            this.itemCategoryBinding = itemCategoryBinding;
        }
    }
}
