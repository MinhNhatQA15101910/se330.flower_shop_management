package com.donhat.se330.flower_shop_management.frontend.features.comments.dropdown.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.databinding.ItemDropdownBinding;

import java.util.List;

// DropdownProvinceAdapter.java
public class DropdownAdapter extends RecyclerView.Adapter<DropdownAdapter.DropdownViewHolder> {
    private final List<String> stringList;
    private OnItemClickListener itemClickListener;

    public DropdownAdapter(List<String> stringList) {
        this.stringList = stringList;
    }

    // Interface để xử lý sự kiện click
    public interface OnItemClickListener {
        void onItemClick(String item);
    }

    // Phương thức này để thiết lập sự kiện click từ bên ngoài adapter
    public void setOnItemClickListener(OnItemClickListener listener) {
        itemClickListener = listener;
    }

    @NonNull
    @Override
    public DropdownViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDropdownBinding itemDropdownBinding = ItemDropdownBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new DropdownViewHolder(itemDropdownBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DropdownViewHolder holder, int position) {
        String text = stringList.get(position);
        if (text != null) {
            holder.itemDropdownBinding.itemText.setText(text);
            holder.itemDropdownBinding.getRoot().setOnClickListener(v -> {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(text);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public static class DropdownViewHolder extends RecyclerView.ViewHolder {
        private final ItemDropdownBinding itemDropdownBinding;

        public DropdownViewHolder(@NonNull ItemDropdownBinding itemDropdownBinding) {
            super(itemDropdownBinding.getRoot());
            this.itemDropdownBinding = itemDropdownBinding;
        }
    }
}
