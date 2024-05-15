package com.donhat.se330.flower_shop_management.frontend.features.customer.category.fragments;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentCategoryBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.category.adapters.CategoryAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.category.entities.Category;
import com.donhat.se330.flower_shop_management.frontend.features.customer.category.eventhandlers.CategoryEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.category.viewmodels.CategoryViewModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryFragment extends Fragment {
    private List<Category> categoryList = new ArrayList<>();
    private CategoryViewModel _categoryViewModel;
    private CategoryEventHandler _categoryEventHandler;
    private FragmentCategoryBinding _fragmentCategoryBinding;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment using DataBindingUtil
        _fragmentCategoryBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_category,
                container,
                false
        );

        _categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);

        // Event Handler
        _categoryEventHandler = new CategoryEventHandler(_categoryViewModel, getContext());
        _fragmentCategoryBinding.setFragmentCategoryEventHandler(_categoryEventHandler);
        _fragmentCategoryBinding.comboVector.setRotation(0);
        _categoryViewModel.getIsComboClicked().observe(getViewLifecycleOwner(), isComboClicked -> {
            _fragmentCategoryBinding.typeComboRecyclerView.setVisibility(View.GONE);
            _fragmentCategoryBinding.occasionComboRecyclerView.setVisibility(View.GONE);
            _fragmentCategoryBinding.typeComboVector.setRotation(0);
            _fragmentCategoryBinding.occasionComboVector.setRotation(0);


            Animation fadeAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fade);
            if (isComboClicked) {
                _fragmentCategoryBinding.typeComboLayout.setVisibility(View.VISIBLE);
                _fragmentCategoryBinding.occasionComboLayout.setVisibility(View.VISIBLE);

                _fragmentCategoryBinding.typeComboLayout.startAnimation(fadeAnimation);
                _fragmentCategoryBinding.occasionComboLayout.startAnimation(fadeAnimation);
                _fragmentCategoryBinding.comboVector.setRotation(180);

            }
            else {
                _fragmentCategoryBinding.typeComboLayout.setVisibility(View.GONE);
                _fragmentCategoryBinding.occasionComboLayout.setVisibility(View.GONE);
                _fragmentCategoryBinding.comboVector.setRotation(0);
            }
        });

        _categoryViewModel.getIsFlowerClicked().observe(getViewLifecycleOwner(), isFlowerClicked -> {
            _fragmentCategoryBinding.typeFlowerRecyclerView.setVisibility(View.GONE);
            _fragmentCategoryBinding.occasionFlowerRecyclerView.setVisibility(View.GONE);
            _fragmentCategoryBinding.typeFlowerVector.setRotation(0);
            _fragmentCategoryBinding.occasionFlowerVector.setRotation(0);

            Animation fadeAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fade);
            if (isFlowerClicked) {
                _fragmentCategoryBinding.typeFlowerLayout.setVisibility(View.VISIBLE);
                _fragmentCategoryBinding.occasionFlowerLayout.setVisibility(View.VISIBLE);

                _fragmentCategoryBinding.typeFlowerLayout.startAnimation(fadeAnimation);
                _fragmentCategoryBinding.occasionFlowerLayout.startAnimation(fadeAnimation);
                _fragmentCategoryBinding.flowerVector.setRotation(180);

            }
            else {
                _fragmentCategoryBinding.typeFlowerLayout.setVisibility(View.GONE);
                _fragmentCategoryBinding.occasionFlowerLayout.setVisibility(View.GONE);
                _fragmentCategoryBinding.flowerVector.setRotation(0);
            }
        });

        _categoryViewModel.getIsCakeClicked().observe(getViewLifecycleOwner(), isCakeClicked -> {
            _fragmentCategoryBinding.typeCakeRecyclerView.setVisibility(View.GONE);
            _fragmentCategoryBinding.occasionCakeRecyclerView.setVisibility(View.GONE);
            _fragmentCategoryBinding.typeCakeVector.setRotation(0);
            _fragmentCategoryBinding.occasionCakeVector.setRotation(0);
            Animation fadeAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fade);
            if (isCakeClicked) {
                _fragmentCategoryBinding.typeCakeLayout.setVisibility(View.VISIBLE);
                _fragmentCategoryBinding.occasionCakeLayout.setVisibility(View.VISIBLE);

                _fragmentCategoryBinding.typeCakeLayout.startAnimation(fadeAnimation);
                _fragmentCategoryBinding.occasionCakeLayout.startAnimation(fadeAnimation);
                _fragmentCategoryBinding.cakeVector.setRotation(180);

            }
            else {
                _fragmentCategoryBinding.typeCakeLayout.setVisibility(View.GONE);
                _fragmentCategoryBinding.occasionCakeLayout.setVisibility(View.GONE);
                _fragmentCategoryBinding.cakeVector.setRotation(0);
            }
        });

        _categoryViewModel.getIsTypeComboClicked().observe(getViewLifecycleOwner(), isTypeComboClicked -> {
            Animation fadeAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fade);
            if (isTypeComboClicked) {
                _fragmentCategoryBinding.typeComboRecyclerView.setVisibility(View.VISIBLE);
                _fragmentCategoryBinding.typeComboRecyclerView.startAnimation(fadeAnimation);
                _fragmentCategoryBinding.typeComboVector.setRotation(180);

            }
            else {
                _fragmentCategoryBinding.typeComboRecyclerView.setVisibility(View.GONE);
                _fragmentCategoryBinding.typeComboVector.setRotation(0);
            }
        });

        _categoryViewModel.getIsOccasionComboClicked().observe(getViewLifecycleOwner(), isOccasionComboClicked -> {
            Animation fadeAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fade);
            if (isOccasionComboClicked) {
                _fragmentCategoryBinding.occasionComboRecyclerView.setVisibility(View.VISIBLE);
                _fragmentCategoryBinding.occasionComboRecyclerView.startAnimation(fadeAnimation);
                _fragmentCategoryBinding.occasionComboVector.setRotation(180);

            }
            else {
                _fragmentCategoryBinding.occasionComboRecyclerView.setVisibility(View.GONE);
                _fragmentCategoryBinding.occasionComboVector.setRotation(0);
            }
        });

        _categoryViewModel.getIsTypeFlowerClicked().observe(getViewLifecycleOwner(), isTypeFlowerClicked -> {
            Animation fadeAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fade);
            if (isTypeFlowerClicked) {
                _fragmentCategoryBinding.typeFlowerRecyclerView.setVisibility(View.VISIBLE);
                _fragmentCategoryBinding.typeFlowerRecyclerView.startAnimation(fadeAnimation);
                _fragmentCategoryBinding.typeFlowerVector.setRotation(180);

            }
            else {
                _fragmentCategoryBinding.typeFlowerRecyclerView.setVisibility(View.GONE);
                _fragmentCategoryBinding.typeFlowerVector.setRotation(0);
            }
        });

        _categoryViewModel.getIsOccasionFlowerClicked().observe(getViewLifecycleOwner(), isOccasionFlowerClicked -> {
            Animation fadeAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fade);
            if (isOccasionFlowerClicked) {
                _fragmentCategoryBinding.occasionFlowerRecyclerView.setVisibility(View.VISIBLE);
                _fragmentCategoryBinding.occasionFlowerRecyclerView.startAnimation(fadeAnimation);
                _fragmentCategoryBinding.occasionFlowerVector.setRotation(180);

            }
            else {
                _fragmentCategoryBinding.occasionFlowerRecyclerView.setVisibility(View.GONE);
                _fragmentCategoryBinding.occasionFlowerVector.setRotation(0);
            }
        });

        _categoryViewModel.getIsTypeCakeClicked().observe(getViewLifecycleOwner(), isTypeCakeClicked -> {
            Animation fadeAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fade);
            if (isTypeCakeClicked) {
                _fragmentCategoryBinding.typeCakeRecyclerView.setVisibility(View.VISIBLE);
                _fragmentCategoryBinding.typeCakeRecyclerView.startAnimation(fadeAnimation);
                _fragmentCategoryBinding.typeCakeVector.setRotation(180);

            }
            else {
                _fragmentCategoryBinding.typeCakeRecyclerView.setVisibility(View.GONE);
                _fragmentCategoryBinding.typeCakeVector.setRotation(0);
            }
        });

        _categoryViewModel.getIsOccasionCakeClicked().observe(getViewLifecycleOwner(), isOccasionCakeClicked -> {
            Animation fadeAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fade);
            if (isOccasionCakeClicked) {
                _fragmentCategoryBinding.occasionCakeRecyclerView.setVisibility(View.VISIBLE);
                _fragmentCategoryBinding.occasionCakeRecyclerView.startAnimation(fadeAnimation);
                _fragmentCategoryBinding.occasionCakeVector.setRotation(180);

            }
            else {
                _fragmentCategoryBinding.occasionCakeRecyclerView.setVisibility(View.GONE);
                _fragmentCategoryBinding.occasionCakeVector.setRotation(0);
            }
        });




        // typeComboRecyclerView
        // Initialize RecyclerView and set its properties
        RecyclerView typeComboRecyclerView = _fragmentCategoryBinding.typeComboRecyclerView;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(),4);
        typeComboRecyclerView.setLayoutManager(gridLayoutManager);
        typeComboRecyclerView.setHasFixedSize(true);

        // Add sample data to categoryList
        categoryList = addCategory();

        // Set up the adapter
        CategoryAdapter categoryAdapter = new CategoryAdapter(categoryList, getContext());
        typeComboRecyclerView.setAdapter(categoryAdapter);


        // occasionComboRecyclerView
        RecyclerView occasionComboRecyclerView = _fragmentCategoryBinding.occasionComboRecyclerView;
        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this.getContext(),4);
        occasionComboRecyclerView.setLayoutManager(gridLayoutManager2);
        occasionComboRecyclerView.setHasFixedSize(true);

        // Add sample data to categoryList
        categoryList = addCategory();

        // Set up the adapter
        CategoryAdapter categoryAdapter2 = new CategoryAdapter(categoryList, getContext());
        occasionComboRecyclerView.setAdapter(categoryAdapter2);

        // typeFloweRecyclerView
        RecyclerView typeFlowerRecyclerView = _fragmentCategoryBinding.typeFlowerRecyclerView;
        GridLayoutManager gridLayoutManager3 = new GridLayoutManager(this.getContext(),4);
        typeFlowerRecyclerView.setLayoutManager(gridLayoutManager3);
        typeFlowerRecyclerView.setHasFixedSize(true);

        // Add sample data to categoryList
        categoryList = addCategory();

        // Set up the adapter
        CategoryAdapter categoryAdapter3 = new CategoryAdapter(categoryList, getContext());
        typeFlowerRecyclerView.setAdapter(categoryAdapter3);

        // occasionFloweRecyclerView
        RecyclerView occasionFlowerRecyclerView = _fragmentCategoryBinding.occasionFlowerRecyclerView;
        GridLayoutManager gridLayoutManager4 = new GridLayoutManager(this.getContext(),4);
        occasionFlowerRecyclerView.setLayoutManager(gridLayoutManager4);
        occasionFlowerRecyclerView.setHasFixedSize(true);

        // Add sample data to categoryList
        categoryList = addCategory();

        // Set up the adapter
        CategoryAdapter categoryAdapter4 = new CategoryAdapter(categoryList, getContext());
        occasionFlowerRecyclerView.setAdapter(categoryAdapter4);

        // typeCakeRecyclerView
        RecyclerView typeCakeRecyclerView = _fragmentCategoryBinding.typeCakeRecyclerView;
        GridLayoutManager gridLayoutManager5 = new GridLayoutManager(this.getContext(),4);
        typeCakeRecyclerView.setLayoutManager(gridLayoutManager5);
        typeCakeRecyclerView.setHasFixedSize(true);

        // Add sample data to categoryList
        categoryList = addCategory();

        // Set up the adapter
        CategoryAdapter categoryAdapter5 = new CategoryAdapter(categoryList, getContext());
        typeCakeRecyclerView.setAdapter(categoryAdapter5);

        // occasionCakeRecyclerView
        RecyclerView occasionCakeRecyclerView = _fragmentCategoryBinding.occasionCakeRecyclerView;
        GridLayoutManager gridLayoutManager6 = new GridLayoutManager(this.getContext(),4);
        occasionCakeRecyclerView.setLayoutManager(gridLayoutManager6);
        occasionCakeRecyclerView.setHasFixedSize(true);

        // Add sample data to categoryList
        categoryList = addCategory();

        // Set up the adapter
        CategoryAdapter categoryAdapter6 = new CategoryAdapter(categoryList, getContext());
        occasionCakeRecyclerView.setAdapter(categoryAdapter6);

        // Return the root view
        return _fragmentCategoryBinding.getRoot();
    }

    private List<Category> addCategory() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Category 1", "@drawable/img_background1"));
        categories.add(new Category("Category 2", "@drawable/img_background2"));
        categories.add(new Category("Category 3", "@drawable/img_background3"));
        categories.add(new Category("Category 4", "@drawable/img_background4"));
        categories.add(new Category("Category 5", "@drawable/img_background5"));
        return categories;
    }
}
