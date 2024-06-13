package com.donhat.se330.flower_shop_management.frontend.features.components.eventhandlers;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

public class SortOptionEventHandler {
    private Context context;
    private MutableLiveData<String> selectedOption = new MutableLiveData<>();

    public SortOptionEventHandler(Context context) {
        this.context = context;
    }

    public MutableLiveData<String> getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption.setValue(selectedOption);
        onOptionClick();
    }

    public void onOptionClick() {
        //Log.i("SortOptionEventHandler", "Option clicked: " + getSelectedOption().getValue());
    }
}