package com.donhat.se330.flower_shop_management.frontend.features.components.eventhandlers;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

public class SortOptionEventHandler {
    private Context context;
    private MutableLiveData<String> selectedOption = new MutableLiveData<>();

    public SortOptionEventHandler(Context context) {
        this.context = context;
    }

    public void setSelectedOption(MutableLiveData<String> selectedOption) {
        this.selectedOption = selectedOption;
    }

    public void onOptionClick(String option) {
        selectedOption.setValue(option);
    }
}