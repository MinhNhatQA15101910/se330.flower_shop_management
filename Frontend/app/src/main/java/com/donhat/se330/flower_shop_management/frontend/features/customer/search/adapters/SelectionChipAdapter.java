package com.donhat.se330.flower_shop_management.frontend.features.customer.search.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ItemSelectionChipBinding;

import java.util.List;

public class SelectionChipAdapter extends RecyclerView.Adapter<SelectionChipAdapter.ChipViewHolder> {

    private final List<String> items;

    public SelectionChipAdapter(List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ChipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSelectionChipBinding itemSelectionChipBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_selection_chip, parent, false);
        return new ChipViewHolder(itemSelectionChipBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ChipViewHolder holder, int position) {
        String item = items.get(position);
        holder._itemSelectionChipBinding.setData(item);

        // Initialize the selected state to false
        holder.itemView.setTag(R.id.selected, false);

        holder.itemView.setOnClickListener(v -> {
            // Toggle the selected state
            boolean selected = !(boolean) v.getTag(R.id.selected);
            v.setTag(R.id.selected, selected);

            // Update the background and text color based on the selected state
            if (selected) {
                holder._itemSelectionChipBinding.getRoot().setBackgroundResource(R.drawable.vector_white_background_btn);
                holder._itemSelectionChipBinding.itemText.setTextColor(ContextCompat.getColor(v.getContext(), R.color.green));
            } else {
                holder._itemSelectionChipBinding.getRoot().setBackgroundResource(R.drawable.white_background_grey_btn);
                holder._itemSelectionChipBinding.itemText.setTextColor(ContextCompat.getColor(v.getContext(), R.color.black));
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ChipViewHolder extends RecyclerView.ViewHolder {
        private final ItemSelectionChipBinding _itemSelectionChipBinding;
        public ChipViewHolder(ItemSelectionChipBinding itemSelectionChipBinding) {
            super(itemSelectionChipBinding.getRoot());
            _itemSelectionChipBinding = itemSelectionChipBinding;
        }

    }
}