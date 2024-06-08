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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentHomeBinding;
import com.donhat.se330.flower_shop_management.frontend.features.components.adapters.ItemBannerAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.components.adapters.ItemProductCardAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.home.eventhandlers.HomeFragmentEventHandlers;
import com.donhat.se330.flower_shop_management.frontend.features.customer.home.viewmodels.HomeFragmentViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Banner;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.List;

public class HomeFragment extends Fragment {
    List<Banner> _banner;
    private FragmentHomeBinding _fragmentHomeBinding;
    private ItemProductCardAdapter _productAdapter;
    private ItemBannerAdapter _itemBannerAdapter;

    PagerSnapHelper snapHelper = new PagerSnapHelper();


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        _fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        HomeFragmentViewModel _homeFragmentViewModel = new ViewModelProvider(this).get(HomeFragmentViewModel.class);
        HomeFragmentEventHandlers _homeFragmentEventHandlers = new HomeFragmentEventHandlers(getContext(), _homeFragmentViewModel);

        _fragmentHomeBinding.setHomeFragmentViewModel(_homeFragmentViewModel);
        _fragmentHomeBinding.setHomeFragmentEventHandler(_homeFragmentEventHandlers);

        _homeFragmentEventHandlers.onInitial();

        _homeFragmentViewModel.getListDoDProducts().observe(getViewLifecycleOwner(), this::displayProductDealsView);
        _homeFragmentViewModel.getListRecommendProducts().observe(getViewLifecycleOwner(), this::displayProductRecommendView);
        _homeFragmentViewModel.getListBanners().observe(getViewLifecycleOwner(), this::displayCarouselBannerView);

        return _fragmentHomeBinding.getRoot();
    }

    private void displayProductDealsView(List<Product> dealsOfDayList) {
        RecyclerView _productsDealsRecyclerView = _fragmentHomeBinding.productsDealsRecyclerView;

        ItemProductCardAdapter adapter = new ItemProductCardAdapter(dealsOfDayList);

        _productsDealsRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
        _productsDealsRecyclerView.setHasFixedSize(true);
        _productsDealsRecyclerView.setAdapter(adapter);
    }

    private void displayProductRecommendView(List<Product> recommendList) {
        RecyclerView _recommendRecyclerView = _fragmentHomeBinding.recommendRecyclerView;

        ItemProductCardAdapter adapter = new ItemProductCardAdapter(recommendList);

        _recommendRecyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        _recommendRecyclerView.setHasFixedSize(true);
        _recommendRecyclerView.setNestedScrollingEnabled(false);
        _recommendRecyclerView.setAdapter(adapter);
    }

    private void displayCarouselBannerView(List<Banner> _banner) {
        RecyclerView _carouselRecyclerView = _fragmentHomeBinding.carouselRecyclerView;

        ItemBannerAdapter adapter = new ItemBannerAdapter(_banner);

        _carouselRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
        snapHelper.attachToRecyclerView(_carouselRecyclerView);
        _carouselRecyclerView.setHasFixedSize(true);
        _carouselRecyclerView.setAdapter(adapter);
    }

    /*private void displayCategoryView(List<Category> categoryList) {
        RecyclerView _categoryRecyclerView = _fragmentHomeBinding.categoryRecyclerView;

        CategoryAdapter adapter = new CategoryAdapter(categoryList);

        _categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
        _categoryRecyclerView.setHasFixedSize(true);
        _categoryRecyclerView.setAdapter(adapter);
    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        _fragmentHomeBinding = null;

    }

}
