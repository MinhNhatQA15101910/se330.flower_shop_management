package com.donhat.se330.flower_shop_management.frontend.features.customer.search.eventhandlers;

import android.content.Context;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

import com.donhat.se330.flower_shop_management.frontend.features.customer.search.fragments.FilterBtmSheetFragment;
import com.donhat.se330.flower_shop_management.frontend.features.customer.search.fragments.SortBtmSheetFragment;
import com.donhat.se330.flower_shop_management.frontend.features.customer.search.servicehandlers.SearchServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.search.viewmodels.SearchFragmentViewModel;

public class SearchFragmentEventHandler {
    Context context;
    SearchFragmentViewModel searchFragmentViewModel;
    SearchServiceHandler searchServiceHandler;

    public SearchFragmentEventHandler(Context context, SearchFragmentViewModel searchFragmentViewModel) {
        this.context = context;
        this.searchFragmentViewModel = searchFragmentViewModel;
        this.searchServiceHandler = new SearchServiceHandler(context, searchFragmentViewModel);
    }

    public void onInitial() {
        searchFragmentViewModel.setProductsList(searchServiceHandler.getAllProducts());
    }

    public void onFilterBtnClicked(View view) {
        FilterBtmSheetFragment filterBtmSheet = new FilterBtmSheetFragment();
        filterBtmSheet.show(((FragmentActivity) context).getSupportFragmentManager(), filterBtmSheet.getTag());
    }

    public void onSortBtnClicked(View view) {
        SortBtmSheetFragment sortBtmSheet = new SortBtmSheetFragment();
        sortBtmSheet.show(((FragmentActivity) context).getSupportFragmentManager(), sortBtmSheet.getTag());
    }
}
