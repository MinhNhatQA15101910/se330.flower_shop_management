package com.donhat.se330.flower_shop_management.frontend.features.customer.category.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.donhat.se330.flower_shop_management.frontend.features.customer.category.entities.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryViewModel extends ViewModel {

    private MutableLiveData<Boolean> isComboClicked = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> isFlowerClicked = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> isCakeClicked = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> isTypeComboClicked = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> isOccasionComboClicked = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> isTypeFlowerClicked = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> isOccasionFlowerClicked = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> isTypeCakeClicked = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> isOccasionCakeClicked = new MutableLiveData<>(false);

    public MutableLiveData<Boolean> getIsComboClicked() {
        return isComboClicked;
    }

    public MutableLiveData<Boolean> getIsFlowerClicked() {
        return isFlowerClicked;
    }

    public MutableLiveData<Boolean> getIsCakeClicked() {
        return isCakeClicked;
    }

    public MutableLiveData<Boolean> getIsTypeComboClicked() {
        return isTypeComboClicked;
    }

    public MutableLiveData<Boolean> getIsOccasionComboClicked() {
        return isOccasionComboClicked;
    }

    public MutableLiveData<Boolean> getIsTypeFlowerClicked() {
        return isTypeFlowerClicked;
    }

    public MutableLiveData<Boolean> getIsOccasionFlowerClicked() {
        return isOccasionFlowerClicked;
    }

    public MutableLiveData<Boolean> getIsTypeCakeClicked() {
        return isTypeCakeClicked;
    }

    public MutableLiveData<Boolean> getIsOccasionCakeClicked() {
        return isOccasionCakeClicked;
    }
}
