package com.donhat.se330.flower_shop_management.frontend.features.customer.category.eventhandlers;

import android.content.Context;
import android.view.View;

import com.donhat.se330.flower_shop_management.frontend.features.customer.category.viewmodels.CategoryViewModel;

public class CategoryEventHandler {
    private final CategoryViewModel _categoryViewModel;
    private final Context _context;

    public CategoryEventHandler(CategoryViewModel categoryViewModel, Context context) {
        _categoryViewModel = categoryViewModel;
        _context = context;
    }

    public void onComboClick(View view) {
        Boolean currentValue = _categoryViewModel.getIsComboClicked().getValue();
        _categoryViewModel.getIsComboClicked().setValue(currentValue == null || !currentValue);
    }
    public void onTypeComboClick(View view) {
        Boolean currentValue = _categoryViewModel.getIsTypeComboClicked().getValue();
        _categoryViewModel.getIsTypeComboClicked().setValue(currentValue == null || !currentValue);
    }
    public void onOccasionComboClick(View view) {
        Boolean currentValue = _categoryViewModel.getIsOccasionComboClicked().getValue();
        _categoryViewModel.getIsOccasionComboClicked().setValue(currentValue == null || !currentValue);
    }
    public void onFlowerClick(View view) {
        Boolean currentValue = _categoryViewModel.getIsFlowerClicked().getValue();
        _categoryViewModel.getIsFlowerClicked().setValue(currentValue == null || !currentValue);
    }
    public void onTypeFlowerClick(View view) {
        Boolean currentValue = _categoryViewModel.getIsTypeFlowerClicked().getValue();
        _categoryViewModel.getIsTypeFlowerClicked().setValue(currentValue == null || !currentValue);
    }
    public void onOccasionFlowerClick(View view) {
        Boolean currentValue = _categoryViewModel.getIsOccasionFlowerClicked().getValue();
        _categoryViewModel.getIsOccasionFlowerClicked().setValue(currentValue == null || !currentValue);
    }
    public void onCakeClick(View view) {
        Boolean currentValue = _categoryViewModel.getIsCakeClicked().getValue();
        _categoryViewModel.getIsCakeClicked().setValue(currentValue == null || !currentValue);
    }
    public void onTypeCakeClick(View view) {
        Boolean currentValue = _categoryViewModel.getIsTypeCakeClicked().getValue();
        _categoryViewModel.getIsTypeCakeClicked().setValue(currentValue == null || !currentValue);
    }
    public void onOccasionCakeClick(View view) {
        Boolean currentValue = _categoryViewModel.getIsOccasionCakeClicked().getValue();
        _categoryViewModel.getIsOccasionCakeClicked().setValue(currentValue == null || !currentValue);
    }
}
