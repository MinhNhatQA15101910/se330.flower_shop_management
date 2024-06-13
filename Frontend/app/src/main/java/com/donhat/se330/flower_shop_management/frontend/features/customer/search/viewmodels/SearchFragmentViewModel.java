package com.donhat.se330.flower_shop_management.frontend.features.customer.search.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.Arrays;
import java.util.List;

public class SearchFragmentViewModel extends ViewModel {
    private final MutableLiveData<String> query = new MutableLiveData<>();
    private final MutableLiveData<List<Product>> searchResults = new MutableLiveData<>();
    private MutableLiveData<List<Product>> productsList = new MutableLiveData<>();
    private List<String> sortOptionList = Arrays.asList("Name: A to Z", "Name: Z to A", "Price: Low to High", "Price: High to Low");
    private MutableLiveData<String> selectedSortOption = new MutableLiveData<>();

    private boolean noResults = false;

    public boolean isNoResults() {
        return noResults;
    }

    public void setNoResults(boolean noResults) {
        this.noResults = noResults;
    }

    public MutableLiveData<List<Product>> getProductsList() {
        return productsList;
    }

    public void setProductsList(MutableLiveData<List<Product>> _productsList) {
        productsList = _productsList;
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

    public List<String> getSortOptionList() {
        return sortOptionList;
    }

    public MutableLiveData<String> getSelectedSortOption() {
        return selectedSortOption;
    }

    public void setSelectedSortOption(String selectedSortOption) {
        this.selectedSortOption.setValue(selectedSortOption);
    }
}

