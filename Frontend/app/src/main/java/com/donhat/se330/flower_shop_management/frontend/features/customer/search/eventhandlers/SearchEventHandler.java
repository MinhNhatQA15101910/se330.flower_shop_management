package com.donhat.se330.flower_shop_management.frontend.features.customer.search.eventhandlers;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.donhat.se330.flower_shop_management.frontend.features.customer.search.fragments.FilterBtmSheetFragment;
import com.donhat.se330.flower_shop_management.frontend.features.customer.search.fragments.SortBtmSheetFragment;
import com.donhat.se330.flower_shop_management.frontend.features.customer.search.viewmodels.SearchFragmentViewModel;

public class SearchEventHandler {
    Context context;
    SearchFragmentViewModel searchFragmentViewModel;

    public SearchEventHandler(Context context, SearchFragmentViewModel searchFragmentViewModel) {
        this.context = context;
        this.searchFragmentViewModel = searchFragmentViewModel;
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
