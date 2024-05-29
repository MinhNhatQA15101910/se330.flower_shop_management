package com.donhat.se330.flower_shop_management.frontend.features.customer.home.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentHomeBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.home.adapters.CarouselBannerAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.home.adapters.CategoryAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.home.viewmodels.HomeFragmentViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.adapters.ProductAdapter;
import com.donhat.se330.flower_shop_management.frontend.models.Banner;
import com.donhat.se330.flower_shop_management.frontend.models.Category;
import com.donhat.se330.flower_shop_management.frontend.models.Product;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.carousel.HeroCarouselStrategy;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ArrayList<Product> _products = new ArrayList<>();
    ArrayList<Category> _category = new ArrayList<>();
    ArrayList<Banner> _banner = new ArrayList<>();
    private FragmentHomeBinding _fragmentHomeBinding;
    private HomeFragmentViewModel _homeFragmentViewModel;
    private ProductAdapter _productAdapter;
    private CategoryAdapter _categoryAdapter;
    private CarouselBannerAdapter _carouselBannerAdapter;

    PagerSnapHelper snapHelper = new PagerSnapHelper();


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        _fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        _homeFragmentViewModel = new ViewModelProvider(this).get(HomeFragmentViewModel.class);

        _fragmentHomeBinding.setHomeFragmentViewModel(_homeFragmentViewModel);

        _fragmentHomeBinding.setLifecycleOwner(this);

        addProducts();
        _productAdapter = new ProductAdapter(_products);

        addCategories();
        _categoryAdapter = new CategoryAdapter(_category);

        addBanners();
        _carouselBannerAdapter = new CarouselBannerAdapter(_banner);

        handleProductDealsView(_productAdapter);
        handleProductRecommendView(_productAdapter);
        handleCategoryView(_categoryAdapter);
        handleCarouselBannerView(_carouselBannerAdapter);

        return _fragmentHomeBinding.getRoot();
    }

    private void handleProductDealsView(RecyclerView.Adapter adapter) {
        _fragmentHomeBinding.productsDealsRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
        _fragmentHomeBinding.productsDealsRecyclerView.setHasFixedSize(true);
        _fragmentHomeBinding.productsDealsRecyclerView.setAdapter(adapter);
    }

    private void handleProductRecommendView(RecyclerView.Adapter adapter) {
        _fragmentHomeBinding.recommendRecyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        _fragmentHomeBinding.recommendRecyclerView.setHasFixedSize(true);
        _fragmentHomeBinding.recommendRecyclerView.setNestedScrollingEnabled(false);
        _fragmentHomeBinding.recommendRecyclerView.setAdapter(adapter);
    }

    private void handleCategoryView(RecyclerView.Adapter adapter) {
        _fragmentHomeBinding.categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
        _fragmentHomeBinding.categoryRecyclerView.setHasFixedSize(true);
        _fragmentHomeBinding.categoryRecyclerView.setAdapter(adapter);
    }

    private void handleCarouselBannerView(RecyclerView.Adapter adapter){
        _fragmentHomeBinding.carouselRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
        snapHelper.attachToRecyclerView(_fragmentHomeBinding.carouselRecyclerView);
        _fragmentHomeBinding.carouselRecyclerView.setHasFixedSize(true);
        _fragmentHomeBinding.carouselRecyclerView.setAdapter(adapter);
    }

    private void addProducts() {
//        _products.add(new Product("Rose", 4.5f, "100", "$10"));
//        _products.add(new Product("Lily", 4.0f, "50", "$15"));
//        _products.add(new Product("Sunflower", 4.2f, "70", "$20"));
//        _products.add(new Product("Tulip", 4.3f, "80", "$25"));
//        _products.add(new Product("Daisy", 4.1f, "60", "$30"));
    }

    private void addCategories() {
//        _category.add(new Category("Rose"));
//        _category.add(new Category("Lily"));
//        _category.add(new Category("Sunflower"));
//        _category.add(new Category("Tulip"));
//        _category.add(new Category("Daisy"));
    }

    private void addBanners() {
        // Add your Banner objects to the _banner list here
        _banner.add(new Banner("https://www.solaflowerstore.com/cdn/shop/products/il_fullxfull.1763644196_mvcl_1024x1024@2x.jpg?v=1626975302"));
        _banner.add(new Banner("https://mcdn.coolmate.me/image/October2023/nhan-vat-doraemon-3012_329.jpg"));
        // Add more Banner objects as needed
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        _fragmentHomeBinding = null;

    }

}
