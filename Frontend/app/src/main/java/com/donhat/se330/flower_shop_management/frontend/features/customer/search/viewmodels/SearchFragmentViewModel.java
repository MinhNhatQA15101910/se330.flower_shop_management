package com.donhat.se330.flower_shop_management.frontend.features.customer.search.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.List;

public class SearchFragmentViewModel extends ViewModel {
    private final MutableLiveData<String> query = new MutableLiveData<>();
    private final MutableLiveData<List<Product>> searchResults = new MutableLiveData<>();
    private final MutableLiveData<String> selectedSortOption = new MutableLiveData<>();
    private MutableLiveData<List<Product>> productsList = new MutableLiveData<>();


    public MutableLiveData<List<Product>> getProductsList() {
        return productsList;
    }

    public void setProductsList(MutableLiveData<List<Product>> _productsList) {
        productsList = _productsList;
    }

    public MutableLiveData<String> getSelectedSortOption() {
        return selectedSortOption;
    }

    public void setSelectedSortOption(String _selectedSortOption) {
        selectedSortOption.setValue(_selectedSortOption);
    }

    public MutableLiveData<String> getQuery() {
        return query;
    }

    public void setQuery(String _query) {
        query.setValue(_query);
    }

    public MutableLiveData<List<Product>> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<Product> _searchResults) {
        searchResults.setValue(_searchResults);
    }
}

