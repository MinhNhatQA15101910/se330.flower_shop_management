package com.donhat.se330.flower_shop_management.frontend.features.customer.rating.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.donhat.se330.flower_shop_management.frontend.models.Product;

public class RatingViewModels extends ViewModel {
    MutableLiveData<Product> product = new MutableLiveData<>();
    int productId;

    public MutableLiveData<Product> getProduct() {
        return product;
    }

    public void setProduct(MutableLiveData<Product> product) {
        this.product = product;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
