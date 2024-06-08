package com.donhat.se330.flower_shop_management.frontend.features.customer.home.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.donhat.se330.flower_shop_management.frontend.models.Banner;
import com.donhat.se330.flower_shop_management.frontend.models.Category;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.ArrayList;
import java.util.List;

public class HomeFragmentViewModel extends ViewModel {
    MutableLiveData<List<Product>> listRecommendProducts = new MutableLiveData<>();
    MutableLiveData<List<Product>> listDoDProducts = new MutableLiveData<>();
    MutableLiveData<List<Category>> listCategories = new MutableLiveData<>();
    MutableLiveData<List<Banner>> listBanners = new MutableLiveData<>();
    List<Banner> imagesList = new ArrayList<>();

    public MutableLiveData<List<Product>> getListRecommendProducts() {
        return listRecommendProducts;
    }

    public void setListRecommendProducts(MutableLiveData<List<Product>> listRecommendProducts) {
        this.listRecommendProducts = listRecommendProducts;
    }

    public MutableLiveData<List<Product>> getListDoDProducts() {
        return listDoDProducts;
    }

    public void setListDoDProducts(MutableLiveData<List<Product>> listDoDProducts) {
        this.listDoDProducts = listDoDProducts;
    }

    public MutableLiveData<List<Category>> getListCategories() {
        return listCategories;
    }

    public void setListCategories(MutableLiveData<List<Category>> listCategories) {
        this.listCategories = listCategories;
    }

    public MutableLiveData<List<Banner>> getListBanners() {
        return listBanners;
    }

    public void setListBanners() {
        addBanners();
        listBanners.setValue(imagesList);
    }

    private void addBanners() {
        // Add banners
        imagesList.add(new Banner("https://shorturl.at/BL50H"));
        imagesList.add(new Banner("https://shorturl.at/eZGo3"));
        imagesList.add(new Banner("https://shorturl.at/kFliy"));
    }
}

