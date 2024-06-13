package com.donhat.se330.flower_shop_management.frontend.features.customer.search.viewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Arrays;
import java.util.List;

public class SortFragmentViewModel extends ViewModel {
    private List<String> sortOptionList = Arrays.asList("Popular", "Top selling", "Price: Low to High", "Price: High to Low");
    private MutableLiveData<String> selectedOption = new MutableLiveData<>();

    public List<String> getSortOptionList() {
        return sortOptionList;
    }

    public MutableLiveData<String> getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption.setValue(selectedOption);
        Log.i("SortFragmentViewModel", "Option in ViewModel selected: " + selectedOption);
    }
}
