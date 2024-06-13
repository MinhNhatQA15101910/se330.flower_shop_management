package com.donhat.se330.flower_shop_management.frontend.features.customer.search.eventhandlers;

import android.content.Context;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

import com.donhat.se330.flower_shop_management.frontend.features.customer.search.fragments.FilterBtmSheetFragment;
import com.donhat.se330.flower_shop_management.frontend.features.customer.search.fragments.SortBtmSheetFragment;
import com.donhat.se330.flower_shop_management.frontend.features.customer.search.servicehandlers.SearchServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.search.viewmodels.SearchFragmentViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.ArrayList;
import java.util.List;

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

    public void onSearchQuerySubmit(String query) {
        searchFragmentViewModel.setQuery(query);
        List<Product> results = performSearch(query);
        searchFragmentViewModel.setSearchResults(results);
    }

    public void onSearchQueryChange(String newText) {
        searchFragmentViewModel.setQuery(newText);
        List<Product> results = performSearch(newText);
        searchFragmentViewModel.setSearchResults(results);
        searchFragmentViewModel.setNoResults(results.isEmpty());
    }

    private List<Product> performSearch(String query) {
        List<Product> allProducts = searchFragmentViewModel.getProductsList().getValue();
        List<Product> filteredProducts = new ArrayList<>();

        assert allProducts != null;
        for (Product product : allProducts) {
            if (product.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredProducts.add(product);
            }
        }

        return filteredProducts;
    }
}
