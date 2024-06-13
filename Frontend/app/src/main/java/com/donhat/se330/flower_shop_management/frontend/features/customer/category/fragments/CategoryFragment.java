package com.donhat.se330.flower_shop_management.frontend.features.customer.category.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentCategoryBinding;
import com.donhat.se330.flower_shop_management.frontend.features.components.adapters.OccasionAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.components.adapters.TypeAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.customer.category.eventhandlers.CategoryEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.category.viewmodels.CategoryViewModel;
import com.donhat.se330.flower_shop_management.frontend.models.Category;

public class CategoryFragment extends Fragment {
    private FragmentCategoryBinding _fragmentCategoryBinding;
    private CategoryEventHandler _categoryEventHandler;

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

        CategoryViewModel _categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);

        // Event Handler
        _categoryEventHandler = new CategoryEventHandler(_categoryViewModel, getContext());

        _fragmentCategoryBinding.setFragmentCategoryEventHandler(_categoryEventHandler);
        _categoryViewModel.getCategoryList().observe(getViewLifecycleOwner(), categoryList -> {
            if (categoryList != null) {
                for (Category category : categoryList) {
                    if (category.getId() == 1) {
                        Glide.with(requireContext())
                                .load(category.getImageUrl())
                                .into(_fragmentCategoryBinding.imageCombos);
                    } else if (category.getId() == 2) {
                        Glide.with(requireContext())
                                .load(category.getImageUrl())
                                .into(_fragmentCategoryBinding.imageFlowers);
                    } else if (category.getId() == 3) {
                        Glide.with(requireContext())
                                .load(category.getImageUrl())
                                .into(_fragmentCategoryBinding.imageCakes);
                    }
                }
            }
        });

        _categoryViewModel.getTypeComboList().observe(getViewLifecycleOwner(), typeComboList -> {
            if (typeComboList != null) {
                RecyclerView typeComboRecyclerView = _fragmentCategoryBinding.typeComboRecyclerView;
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 4);
                typeComboRecyclerView.setLayoutManager(gridLayoutManager);
                typeComboRecyclerView.setHasFixedSize(true);

                TypeAdapter typeAdapter = new TypeAdapter(typeComboList, getContext());
                typeComboRecyclerView.setAdapter(typeAdapter);
            }
        });

        _categoryViewModel.getTypeFlowerList().observe(getViewLifecycleOwner(), typeFlowerList -> {
            if (typeFlowerList != null) {
                RecyclerView typeFlowerRecyclerView = _fragmentCategoryBinding.typeFlowerRecyclerView;
                GridLayoutManager gridLayoutManager3 = new GridLayoutManager(this.getContext(), 4);
                typeFlowerRecyclerView.setLayoutManager(gridLayoutManager3);
                typeFlowerRecyclerView.setHasFixedSize(true);

                TypeAdapter typeAdapter3 = new TypeAdapter(typeFlowerList, getContext());
                typeFlowerRecyclerView.setAdapter(typeAdapter3);
            }
        });

        _categoryViewModel.getTypeCakeList().observe(getViewLifecycleOwner(), typeCakeList -> {
            if (typeCakeList != null) {
                RecyclerView typeCakeRecyclerView = _fragmentCategoryBinding.typeCakeRecyclerView;
                GridLayoutManager gridLayoutManager5 = new GridLayoutManager(this.getContext(), 4);
                typeCakeRecyclerView.setLayoutManager(gridLayoutManager5);
                typeCakeRecyclerView.setHasFixedSize(true);

                TypeAdapter typeAdapter5 = new TypeAdapter(typeCakeList, getContext());
                typeCakeRecyclerView.setAdapter(typeAdapter5);
            }
        });

        _categoryViewModel.getOccasionComboList().observe(getViewLifecycleOwner(), occasionComboList -> {
            if (occasionComboList != null) {
                RecyclerView occasionComboRecyclerView = _fragmentCategoryBinding.occasionComboRecyclerView;
                GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this.getContext(), 4);
                occasionComboRecyclerView.setLayoutManager(gridLayoutManager2);
                occasionComboRecyclerView.setHasFixedSize(true);

                OccasionAdapter occasionAdapter2 = new OccasionAdapter(occasionComboList, getContext());
                occasionComboRecyclerView.setAdapter(occasionAdapter2);
            }
        });

        _categoryViewModel.getOccasionFlowerList().observe(getViewLifecycleOwner(), occasionFlowerList -> {
            if (occasionFlowerList != null) {
                RecyclerView occasionFlowerRecyclerView = _fragmentCategoryBinding.occasionFlowerRecyclerView;
                GridLayoutManager gridLayoutManager4 = new GridLayoutManager(this.getContext(), 4);
                occasionFlowerRecyclerView.setLayoutManager(gridLayoutManager4);
                occasionFlowerRecyclerView.setHasFixedSize(true);

                OccasionAdapter occasionAdapter4 = new OccasionAdapter(occasionFlowerList, getContext());
                occasionFlowerRecyclerView.setAdapter(occasionAdapter4);
            }
        });

        _categoryViewModel.getOccasionCakeList().observe(getViewLifecycleOwner(), occasionCakeList -> {
            if (occasionCakeList != null) {
                RecyclerView occasionCakeRecyclerView = _fragmentCategoryBinding.occasionCakeRecyclerView;
                GridLayoutManager gridLayoutManager6 = new GridLayoutManager(this.getContext(), 4);
                occasionCakeRecyclerView.setLayoutManager(gridLayoutManager6);
                occasionCakeRecyclerView.setHasFixedSize(true);

                OccasionAdapter occasionAdapter6 = new OccasionAdapter(occasionCakeList, getContext());
                occasionCakeRecyclerView.setAdapter(occasionAdapter6);
            }
        });

        _categoryEventHandler.onInitial();

        _fragmentCategoryBinding.comboVector.setRotation(0);

        return _fragmentCategoryBinding.getRoot();
    }

}