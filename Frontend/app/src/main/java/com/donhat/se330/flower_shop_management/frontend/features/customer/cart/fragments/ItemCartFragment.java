package com.donhat.se330.flower_shop_management.frontend.features.customer.cart.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ItemCartBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.eventhandlers.ItemCartEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.cart.viewmodel.ItemCartViewModel;

public class ItemCartFragment extends Fragment {
    private ItemCartViewModel _itemCartViewModel;
    private ItemCartEventHandler _itemCartEventHandler;
    private ItemCartBinding _itemCartBinding;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment using DataBindingUtil
        _itemCartBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.item_cart,
                container,
                false
        );

        _itemCartViewModel = new ViewModelProvider(this).get(ItemCartViewModel.class);

        // Event Handler
        _itemCartEventHandler = new ItemCartEventHandler(_itemCartViewModel, getContext());

        _itemCartBinding.setFragmentItemCartEventHandler(_itemCartEventHandler);

        _itemCartViewModel.getCurrentQuantity().observe(getViewLifecycleOwner(), currentQuantity -> {
            _itemCartBinding.inputValue.setText(String.valueOf(currentQuantity));
        });


        return _itemCartBinding.getRoot();
    }
}