package com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ItemSingleProductCardBinding;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private ArrayList<Product> _products;

    public ProductAdapter(ArrayList<Product> products) {
        _products = products;
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSingleProductCardBinding itemSingleProductCardBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_single_product_card, parent, false);
        return new ProductViewHolder(itemSingleProductCardBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product currentProduct = _products.get(position);

        holder._itemSingleProductCardBinding.setProduct(currentProduct);
    }


    @Override
    public int getItemCount() {
        if(_products != null)
            return _products.size();
        return 0;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        private final ItemSingleProductCardBinding _itemSingleProductCardBinding;
        public ProductViewHolder(ItemSingleProductCardBinding itemSingleProductCardBinding) {
            super(itemSingleProductCardBinding.getRoot());
            _itemSingleProductCardBinding = itemSingleProductCardBinding;
        }
    }
}
