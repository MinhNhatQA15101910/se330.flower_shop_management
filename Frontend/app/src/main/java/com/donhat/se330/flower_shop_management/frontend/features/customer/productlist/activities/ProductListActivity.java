package com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityProductListBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.adapters.ProductAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.eventhandlers.ProductListEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.viewmodels.ProductListViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    ArrayList<Product> _products = new ArrayList<>();
    private ActivityProductListBinding _activityProductListBinding;
    private ProductListViewModel _productListViewModel;
    private ProductListEventHandler _productListEventHandler;

    private ProductAdapter _productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _activityProductListBinding = DataBindingUtil.setContentView(this, R.layout.activity_product_list);

        _productListViewModel = new ViewModelProvider(this).get(ProductListViewModel.class);

        _activityProductListBinding.setProductListViewModel(_productListViewModel);

        _productListEventHandler = new ProductListEventHandler();

        addProducts();
        _productAdapter = new ProductAdapter(_products);

        _activityProductListBinding.productsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        _activityProductListBinding.productsRecyclerView.setHasFixedSize(true);
        _activityProductListBinding.productsRecyclerView.setAdapter(_productAdapter);


    }

    //add some products to the list
    private void addProducts() {
        _products.add(new Product("Rose", 4.5f, "100", "$10"));
        _products.add(new Product("Lily", 4.0f, "50", "$15"));
        _products.add(new Product("Sunflower", 4.2f, "70", "$20"));
        _products.add(new Product("Tulip", 4.3f, "80", "$25"));
        _products.add(new Product("Daisy", 4.1f, "60", "$30"));
    }
}