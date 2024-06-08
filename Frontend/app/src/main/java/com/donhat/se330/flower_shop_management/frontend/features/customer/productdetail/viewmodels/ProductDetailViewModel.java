package com.donhat.se330.flower_shop_management.frontend.features.customer.productdetail.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.List;

public class ProductDetailViewModel extends ViewModel {
    MutableLiveData<List<String>> imageUrlsList = new MutableLiveData<>();
    MutableLiveData<Product> product = new MutableLiveData<>();
    MutableLiveData<List<Product>> suggestProducts = new MutableLiveData<>();
    int productId;
    private Product testProduct = product.getValue();

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public MutableLiveData<List<String>> getImageUrlsList() {
        return imageUrlsList;
    }

    public void setImageUrls(MutableLiveData<List<String>> _imageUrls) {
        this.imageUrlsList = _imageUrls;
    }

    public MutableLiveData<List<Product>> getSuggestProducts() {
        return suggestProducts;
    }

    public void setSuggestProducts(MutableLiveData<List<Product>> suggestProducts) {
        this.suggestProducts = suggestProducts;
    }

    public MutableLiveData<Product> getProduct() {
        return product;
    }

    public void setProduct(MutableLiveData<Product> _product) {
        this.product = _product;
    }
}
