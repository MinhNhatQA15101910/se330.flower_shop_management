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
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentProductFilterBtmSheetBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.search.adapters.SelectionChipAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.search.eventhandlers.FilterBtmSheetEventHandler;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Arrays;
import java.util.List;

public class FilterBtmSheetFragment extends BottomSheetDialogFragment {
    private List<String> productTypes = Arrays.asList("New", "On sale", "Best seller", "Top rated");
    private List<String> priceRanges = Arrays.asList("Under $10", "$10 - $50", "$50 - $100", "Over $100");
    private FragmentProductFilterBtmSheetBinding _filterBtmSheetFragmentBinding;
    private FilterBtmSheetEventHandler filterBtmSheetEventHandler = new FilterBtmSheetEventHandler(this);
    private SelectionChipAdapter productTypesChipAdapter = new SelectionChipAdapter(productTypes);
    private SelectionChipAdapter priceRangesChipAdapter = new SelectionChipAdapter(priceRanges);

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_filter_btm_sheet, container, true);
        _filterBtmSheetFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_filter_btm_sheet, container, false);

        handleRecyclerView(_filterBtmSheetFragmentBinding.productTypeRecyclerView, productTypesChipAdapter);
        handleRecyclerView(_filterBtmSheetFragmentBinding.priceRangesRecyclerView, priceRangesChipAdapter);

        // TODO: Handle the logic for the filter options and the apply button click
        _filterBtmSheetFragmentBinding.setEventHandler(filterBtmSheetEventHandler);

        return _filterBtmSheetFragmentBinding.getRoot();
    }

    void handleRecyclerView(RecyclerView recyclerView, SelectionChipAdapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
    }
}
