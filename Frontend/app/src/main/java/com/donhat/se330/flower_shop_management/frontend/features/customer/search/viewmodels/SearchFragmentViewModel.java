package com.donhat.se330.flower_shop_management.frontend.features.customer.search.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.List;

public class SearchFragmentViewModel extends ViewModel {
    MutableLiveData<List<Product>> productsList = new MutableLiveData<>();

    public MutableLiveData<List<Product>> getProductsList() {
        return productsList;
    }

    public void setProductsList(MutableLiveData<List<Product>> _productsList) {
        productsList = _productsList;
    }
}

