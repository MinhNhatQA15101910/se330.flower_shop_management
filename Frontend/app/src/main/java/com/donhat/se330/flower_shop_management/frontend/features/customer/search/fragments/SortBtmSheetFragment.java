package com.donhat.se330.flower_shop_management.frontend.features.customer.search.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentProductSortBtmSheetBinding;
import com.donhat.se330.flower_shop_management.frontend.features.components.adapters.SortOptionAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.search.eventhandlers.SortBtmSheetEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.search.viewmodels.SearchFragmentViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class SortBtmSheetFragment extends BottomSheetDialogFragment {

    private FragmentProductSortBtmSheetBinding _sortBtmSheetFragmentBinding;
    private SearchFragmentViewModel _searchFragmentViewModel;
    private SortBtmSheetEventHandler _eventHandler = new SortBtmSheetEventHandler(this);
    private SortOptionAdapter sortOptionAdapter;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_filter_btm_sheet, container, true);
        _sortBtmSheetFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_sort_btm_sheet, container, false);

        _searchFragmentViewModel = new ViewModelProvider(this).get(SearchFragmentViewModel.class);

        _sortBtmSheetFragmentBinding.setViewModel(_searchFragmentViewModel);
        _sortBtmSheetFragmentBinding.setEventHandler(_eventHandler);

        handleRecyclerView();

        return _sortBtmSheetFragmentBinding.getRoot();
    }

    void handleRecyclerView() {
        RecyclerView recyclerView = _sortBtmSheetFragmentBinding.sortOptionRecyclerView;
        sortOptionAdapter = new SortOptionAdapter(_searchFragmentViewModel.getSortOptionList(), _searchFragmentViewModel);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(sortOptionAdapter);
    }

}
