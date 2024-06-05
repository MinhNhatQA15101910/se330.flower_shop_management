package com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityProductListBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.adapters.ProductAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.eventhandlers.ProductListEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.servicehandlers.ProductListServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.viewmodels.ProductListViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    List<Product> dealsOfDayList;

    private ActivityProductListBinding _activityProductListBinding;
    private ProductListViewModel _productListViewModel;
    private ProductListEventHandler _productListEventHandler;
    private ProductAdapter _productAdapter;
    private ProductListServiceHandler _productListServiceHandler;

    private RecyclerView _productsListRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _activityProductListBinding = DataBindingUtil.setContentView(this, R.layout.activity_product_list);

        _productListViewModel = new ViewModelProvider(this).get(ProductListViewModel.class);

        _activityProductListBinding.setProductListViewModel(_productListViewModel);

        _productListEventHandler = new ProductListEventHandler(this, _productListViewModel);

        _activityProductListBinding.setProductListEventHandler(_productListEventHandler);


        getAllDoDProducts();


    }

    void getAllDoDProducts() {
        _productListViewModel.setListDoDProducts(_productListEventHandler.getProduct());
        dealsOfDayList = _productListViewModel.getListDoDProducts().getValue();
        displayDealOfDayRecyclerView();
    }

    void displayDealOfDayRecyclerView() {
        _productsListRecyclerView = _activityProductListBinding.productsRecyclerView;

        _productAdapter = new ProductAdapter(dealsOfDayList);

        _productsListRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        _productsListRecyclerView.setHasFixedSize(true);
        _productsListRecyclerView.setAdapter(_productAdapter);
    }

}