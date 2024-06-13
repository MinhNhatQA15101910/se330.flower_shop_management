package com.donhat.se330.flower_shop_management.frontend.features.customer.search.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentSearchBinding;
import com.donhat.se330.flower_shop_management.frontend.features.components.adapters.ItemProductCardAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.search.eventhandlers.SearchFragmentEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.search.viewmodels.SearchFragmentViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    private Handler handler = new Handler();
    private Runnable runnable;
    List<Product> _products = new ArrayList<>();

    private FragmentSearchBinding _fragmentSearchBinding;

    private SearchFragmentViewModel _searchFragmentViewModel;

    private SearchFragmentEventHandler _searchFragmentEventHandler;
    private ItemProductCardAdapter productAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        _fragmentSearchBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
        _searchFragmentViewModel =  new ViewModelProvider(this).get(SearchFragmentViewModel.class);
        _fragmentSearchBinding.setSearchFragmentViewModel(_searchFragmentViewModel);

        _searchFragmentEventHandler = new SearchFragmentEventHandler(this.getContext(), _searchFragmentViewModel);
        _fragmentSearchBinding.setSearchFragmentEventHandler(_searchFragmentEventHandler);

        _searchFragmentEventHandler.onInitial();

        _searchFragmentViewModel.getProductsList().observe(getViewLifecycleOwner(), products -> {
            _products = products;
            displaySearchRecyclerView();
        });

        handleSearchView();

        _searchFragmentViewModel.getSelectedSortOption().observe(getViewLifecycleOwner(), newSelectedSortOption -> {
            _fragmentSearchBinding.labelSortProduct.setText(newSelectedSortOption);
            handleSortLogic(newSelectedSortOption);
        });
        return _fragmentSearchBinding.getRoot();
    }


    private void displaySearchRecyclerView() {
        RecyclerView searchRecyclerView = _fragmentSearchBinding.searchRecyclerView;
        ItemProductCardAdapter adapter = new ItemProductCardAdapter(_products);

        searchRecyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        searchRecyclerView.setHasFixedSize(true);
        searchRecyclerView.setAdapter(adapter);
    }

    private void handleSearchView() {
        SearchView searchView = _fragmentSearchBinding.searchBar;
        List<Product> searchResults = new ArrayList<>();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                _searchFragmentEventHandler.onSearchQuerySubmit(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                handler.removeCallbacks(runnable);
                runnable = () -> {
                    _searchFragmentEventHandler.onSearchQueryChange(newText);
                    updateUIBasedOnSearchResults();
                };
                handler.postDelayed(runnable, 500); // 500 ms delay
                return true;
            }
        });
    }

    private void updateUIBasedOnSearchResults() {
        if (_searchFragmentViewModel.isNoResults()) {
            _fragmentSearchBinding.labelSuggestList.setVisibility(View.VISIBLE);
            _fragmentSearchBinding.noResultConstraintLayout.setVisibility(View.VISIBLE);

            _searchFragmentViewModel.getProductsList().observe(getViewLifecycleOwner(), products -> {
                _products = products;
                displaySearchRecyclerView();
            });
        } else {
            _fragmentSearchBinding.labelSuggestList.setVisibility(View.GONE);
            _fragmentSearchBinding.noResultConstraintLayout.setVisibility(View.GONE);

            _searchFragmentViewModel.getSearchResults().observe(getViewLifecycleOwner(), products -> {
                _products = products;
                displaySearchRecyclerView();
            });
        }
    }

    private void handleSortLogic(String newSelectedSortOption) {
        // Add your logic here
    }
}