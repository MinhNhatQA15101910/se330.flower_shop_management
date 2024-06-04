package com.donhat.se330.flower_shop_management.frontend.features.customer.category.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.donhat.se330.flower_shop_management.frontend.models.Category;
import com.donhat.se330.flower_shop_management.frontend.models.Occasion;
import com.donhat.se330.flower_shop_management.frontend.models.Type;

import java.util.List;

public class CategoryViewModel extends ViewModel {


    private final MutableLiveData<List<Category>> categoryList = new MutableLiveData<>();
    private final MutableLiveData<List<Type>> typeList = new MutableLiveData<>();
    private final MutableLiveData<List<Occasion>> occasionList = new MutableLiveData<>();
    private final MutableLiveData<Boolean> isComboClicked = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isFlowerClicked = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isCakeClicked = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isTypeComboClicked = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isOccasionComboClicked = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isTypeFlowerClicked = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isOccasionFlowerClicked = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isTypeCakeClicked = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> isOccasionCakeClicked = new MutableLiveData<>(false);

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

    public MutableLiveData<List<Category>> getCategoryList() {
        return categoryList;
    }

    public MutableLiveData<List<Type>> getTypeList() {
        return typeList;
    }

    public MutableLiveData<List<Occasion>> getOccasionList() {
        return occasionList;
    }
}
