package com.donhat.se330.flower_shop_management.frontend.features.customer.search.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentSearchBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.adapters.ProductAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.search.eventhandlers.SearchEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.search.viewmodels.SearchFragmentViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.ArrayList;

public class SearchFragment extends Fragment {
    ArrayList<Product> _products = new ArrayList<>();

    private FragmentSearchBinding _fragmentSearchBinding;

    private SearchFragmentViewModel _searchFragmentViewModel;

    private SearchEventHandler _searchEventHandler;
    private ProductAdapter productAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        _fragmentSearchBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
        _searchFragmentViewModel =  new ViewModelProvider(this).get(SearchFragmentViewModel.class);

        _searchEventHandler = new SearchEventHandler(this.getContext(), _searchFragmentViewModel);
        _fragmentSearchBinding.setSearchEventHandler(_searchEventHandler);

        addProducts();
        productAdapter = new ProductAdapter(_products);
        handleProductReyclerView(productAdapter);

        return _fragmentSearchBinding.getRoot();
    }

    private void addProducts() {
        /*_products.add(new Product("Rose", 4.5f, "100", "$10"));
        _products.add(new Product("Lily", 4.0f, "50", "$15"));
        _products.add(new Product("Sunflower", 4.2f, "70", "$20"));
        _products.add(new Product("Tulip", 4.3f, "80", "$25"));
        _products.add(new Product("Daisy", 4.1f, "60", "$30"));*/
    }

    private void handleProductReyclerView(RecyclerView.Adapter adapter) {
        _fragmentSearchBinding.searchRecyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        _fragmentSearchBinding.searchRecyclerView.setHasFixedSize(true);
        _fragmentSearchBinding.searchRecyclerView.setAdapter(adapter);
    }
}