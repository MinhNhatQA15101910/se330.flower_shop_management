package com.donhat.se330.flower_shop_management.frontend.features.customer.productdetail.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityProductDetailBinding;
import com.donhat.se330.flower_shop_management.frontend.features.components.adapters.ItemProductCardAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.components.adapters.ProductImageAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productdetail.eventhandlers.ProductDetailEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productdetail.viewmodels.ProductDetailViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailActivity extends AppCompatActivity {

    ActivityProductDetailBinding _activityProductDetailBinding;
    ProductDetailViewModel _productDetailViewModel;
    private Product _product;
    private List<Product> _suggestProducts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int productId = (int) getIntent().getSerializableExtra("product");

        _activityProductDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail);

        _productDetailViewModel = new ViewModelProvider(this).get(ProductDetailViewModel.class);

        ProductDetailEventHandler _productDetailEventHandler = new ProductDetailEventHandler(_productDetailViewModel, this, this);

        _activityProductDetailBinding.setProductDetailViewModel(_productDetailViewModel);

        _activityProductDetailBinding.setProductDetailEventHandler(_productDetailEventHandler);

        _productDetailViewModel.setProductId(productId);

        _productDetailEventHandler.onInitial();
        _product = _productDetailViewModel.getProduct().getValue();

        displayProductDetail();

        _productDetailViewModel.getSuggestProducts().observe(this, products -> {
            _suggestProducts = products;
            displaySuggestProductList();
        });
    }

    @SuppressLint("DefaultLocale")
    void displayProductDetail() {

        _productDetailViewModel.getProduct().observe(this, product -> {
            _product = product;
            _activityProductDetailBinding.ratingBar.setRating(Float.parseFloat(_product.getRatingAvg()));
            _activityProductDetailBinding.setProduct(_product);
            displayProductImageList();
        });
    }

    void displayProductImageList() {
        List<String> _imagesUrl = _product.getImageUrls();
        ProductImageAdapter adapter = new ProductImageAdapter(_imagesUrl);
        PagerSnapHelper snapHelper = new PagerSnapHelper();

        RecyclerView recyclerView = _activityProductDetailBinding.productImagesRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        snapHelper.attachToRecyclerView(recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    void displaySuggestProductList() {
        RecyclerView _suggestRecyclerView = _activityProductDetailBinding.suggestionsRecyclerView;
        ItemProductCardAdapter adapter = new ItemProductCardAdapter(_suggestProducts);

        _suggestRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        _suggestRecyclerView.setHasFixedSize(true);
        //_suggestRecyclerView.setNestedScrollingEnabled(false);
        _suggestRecyclerView.setAdapter(adapter);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}