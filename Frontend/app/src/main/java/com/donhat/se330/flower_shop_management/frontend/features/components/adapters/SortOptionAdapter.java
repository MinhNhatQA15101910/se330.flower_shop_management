package com.donhat.se330.flower_shop_management.frontend.features.components.adapters;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ItemSortOptionBinding;
import com.donhat.se330.flower_shop_management.frontend.features.components.eventhandlers.SortOptionEventHandler;

import java.util.List;

public class SortOptionAdapter extends RecyclerView.Adapter<SortOptionAdapter.SortOptionViewHolder> {

    private final List<String> items;
    private int selectedPosition = -1;

    private SortOptionEventHandler _sortOptionEventHandler;

    public SortOptionAdapter(List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public SortOptionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSortOptionBinding itemSortOptionBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_sort_option, parent, false);

        _sortOptionEventHandler = new SortOptionEventHandler(parent.getContext());
        itemSortOptionBinding.setSortOptionEventHandler(_sortOptionEventHandler);
        return new SortOptionViewHolder(itemSortOptionBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SortOptionAdapter.SortOptionViewHolder holder, int position) {
        String item = items.get(position);
        holder._itemSortOptionBinding.setOption(item);

        if (position == selectedPosition) {
            holder._itemSortOptionBinding.getRoot().setBackgroundResource(R.drawable.option_item_color);
            holder._itemSortOptionBinding.optionText.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.green));
            //set the text style to bold
            holder._itemSortOptionBinding.optionText.setTypeface(null, Typeface.BOLD);
            holder._itemSortOptionBinding.selectIcon.setVisibility(View.VISIBLE);
        } else {
            holder._itemSortOptionBinding.getRoot().setBackgroundResource(R.drawable.option_item);
            holder._itemSortOptionBinding.optionText.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), R.color.black));
            holder._itemSortOptionBinding.optionText.setTypeface(null, Typeface.NORMAL);
            holder._itemSortOptionBinding.selectIcon.setVisibility(View.INVISIBLE);
        }

        holder.itemView.setOnClickListener(v -> {
            // Update the selected position
            selectedPosition = position;
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class SortOptionViewHolder extends RecyclerView.ViewHolder {
        private final ItemSortOptionBinding _itemSortOptionBinding;

        public SortOptionViewHolder(ItemSortOptionBinding itemSortOptionBinding) {
            super(itemSortOptionBinding.getRoot());
            _itemSortOptionBinding = itemSortOptionBinding;
        }
    }
}
