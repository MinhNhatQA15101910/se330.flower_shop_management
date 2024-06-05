package com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.List;

public class ProductListViewModel extends ViewModel {
    private MutableLiveData<List<Product>> listDoDProducts;

    public MutableLiveData<List<Product>> getListDoDProducts() {
        return listDoDProducts;
    }

    public void setListDoDProducts(List<Product> listDoDProducts) {
        this.listDoDProducts.setValue(listDoDProducts);
    }
}
