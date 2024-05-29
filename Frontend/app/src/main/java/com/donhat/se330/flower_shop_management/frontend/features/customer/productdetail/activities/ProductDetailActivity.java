package com.donhat.se330.flower_shop_management.frontend.features.customer.productdetail.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityProductDetailBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productdetail.viewmodels.ProductDetailViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.adapters.ProductAdapter;
import com.donhat.se330.flower_shop_management.frontend.models.Product;

import java.util.ArrayList;

public class ProductDetailActivity extends AppCompatActivity {

    ArrayList<Product> _products = new ArrayList<>();
    private ActivityProductDetailBinding _activityProductDetailBinding;
    private ProductDetailViewModel _productDetailViewModel;

    private ProductAdapter _productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _activityProductDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail);

        _productDetailViewModel = new ViewModelProvider(this).get(ProductDetailViewModel.class);

        _activityProductDetailBinding.setProductDetailViewModel(_productDetailViewModel);

        addProducts();
        _productAdapter = new ProductAdapter(_products);


    }

    //add some products to the list
    private void addProducts() {
       /* _products.add(new Product("Rose", 4.5f, "100", "$10"));
        _products.add(new Product("Lily", 4.0f, "50", "$15"));
        _products.add(new Product("Sunflower", 4.2f, "70", "$20"));
        _products.add(new Product("Tulip", 4.3f, "80", "$25"));
        _products.add(new Product("Daisy", 4.1f, "60", "$30"));*/
    }
}