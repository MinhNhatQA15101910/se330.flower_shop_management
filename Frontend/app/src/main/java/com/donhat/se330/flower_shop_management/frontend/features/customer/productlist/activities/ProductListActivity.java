package com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityProductListBinding;
import com.donhat.se330.flower_shop_management.frontend.features.components.adapters.ItemProductCardAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.eventhandlers.ProductListEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.viewmodels.ProductListViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    private ActivityProductListBinding _activityProductListBinding;
    private ProductListViewModel _productListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String title = getIntent().getSerializableExtra("title").toString();

        _activityProductListBinding = DataBindingUtil.setContentView(this, R.layout.activity_product_list);

        _productListViewModel = new ViewModelProvider(this).get(ProductListViewModel.class);

        _activityProductListBinding.setProductListViewModel(_productListViewModel);

        ProductListEventHandler _productListEventHandler = new ProductListEventHandler(this, _productListViewModel);

        _activityProductListBinding.setProductListEventHandler(_productListEventHandler);

        _productListEventHandler.onInitial();

        _productListViewModel.setTitle(title);

        getAllDoDProducts();
    }

    void getAllDoDProducts() {
        _productListViewModel.getListDoDProducts().observe(this, this::displayDealOfDayRecyclerView);
    }

    void displayDealOfDayRecyclerView(List<Product> productsList) {
        if(productsList!=null){
            RecyclerView _productsListRecyclerView = _activityProductListBinding.productsRecyclerView;
            _activityProductListBinding.textTitle.setText(_productListViewModel.getTitle().getValue());
            ItemProductCardAdapter _productAdapter = new ItemProductCardAdapter(productsList);

            _productsListRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
            _productsListRecyclerView.setHasFixedSize(true);
            _productsListRecyclerView.setAdapter(_productAdapter);
        }

    }

}