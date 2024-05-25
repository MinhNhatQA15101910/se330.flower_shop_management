package com.donhat.se330.flower_shop_management.frontend.features.customer.search.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ItemProductSortBtmSheetBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.search.adapters.SortOptionAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.search.eventhandlers.SortBtmSheetEventHandler;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Arrays;
import java.util.List;

public class SortBtmSheetFragment extends BottomSheetDialogFragment {
    private List<String> optionList = Arrays.asList("Popular", "Top selling", "Price: Low to High", "Price: High to Low");

    private ItemProductSortBtmSheetBinding _sortBtmSheetFragmentBinding;

    private SortBtmSheetEventHandler _eventHandler = new SortBtmSheetEventHandler(this);
    private SortOptionAdapter sortOptionAdapter = new SortOptionAdapter(optionList);

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_product_filter_btm_sheet, container, true);
        _sortBtmSheetFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.item_product_sort_btm_sheet, container, false);

        handleRecyclerView(_sortBtmSheetFragmentBinding.sortOptionRecyclerView, sortOptionAdapter);

        _sortBtmSheetFragmentBinding.setEventHandler(_eventHandler);

        return _sortBtmSheetFragmentBinding.getRoot();
    }

    void handleRecyclerView(RecyclerView recyclerView, SortOptionAdapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }
}
