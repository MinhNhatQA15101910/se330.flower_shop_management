package com.donhat.se330.flower_shop_management.frontend.features.customer.order.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ItemOrderCardBinding;
import com.donhat.se330.flower_shop_management.frontend.models.Order;

import java.util.ArrayList;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.OrderViewHolder> {
    private ArrayList<Order> _orders;

    public OrdersAdapter(ArrayList<Order> orders) {
        _orders = orders;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemOrderCardBinding _itemOrderCardBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_order_card, parent, false);
        return new OrderViewHolder(_itemOrderCardBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        Order currentOrder = _orders.get(position);

        holder._itemOrderCardBinding.setOrder(currentOrder);
    }

    @Override
    public int getItemCount() {
        if(_orders != null)
            return _orders.size();
        return 0;
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        ItemOrderCardBinding _itemOrderCardBinding;

        public OrderViewHolder(ItemOrderCardBinding itemOrderCardBinding) {
            super(itemOrderCardBinding.getRoot());
            _itemOrderCardBinding = itemOrderCardBinding;
        }
    }
}
