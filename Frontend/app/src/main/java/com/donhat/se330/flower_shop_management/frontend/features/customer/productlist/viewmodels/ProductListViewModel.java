package com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.List;

public class ProductListViewModel extends ViewModel {
    private MutableLiveData<List<Product>> dodProductList = new MutableLiveData<>();
    private MutableLiveData<String> title = new MutableLiveData<>();

    public MutableLiveData<String> getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title.setValue(title);
    }

    public MutableLiveData<List<Product>> getListDoDProducts() {
        return dodProductList;
    }

    public void setListDoDProducts(MutableLiveData<List<Product>> listDoDProducts) {
        this.dodProductList = listDoDProducts;
    }
}
