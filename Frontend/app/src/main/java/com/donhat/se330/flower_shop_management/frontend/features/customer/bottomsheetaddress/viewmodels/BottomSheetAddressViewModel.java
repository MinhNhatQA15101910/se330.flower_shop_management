package com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class BottomSheetAddressViewModel extends ViewModel {
    private final MutableLiveData<String> currentDropDown = new MutableLiveData<>();
    private final MutableLiveData<String> selectedProvince = new MutableLiveData<>();
    private final MutableLiveData<List<String>> provinceList = new MutableLiveData<>();

    private final MutableLiveData<String> selectedDistrict = new MutableLiveData<>();

    public MutableLiveData<String> getSelectedDistrict() {
        return selectedDistrict;
    }

    public MutableLiveData<List<String>> getDistrictList() {
        return districtList;
    }

    public MutableLiveData<String> getSelectedWard() {
        return selectedWard;
    }

    public MutableLiveData<List<String>> getWardList() {
        return wardList;
    }

    private final MutableLiveData<List<String>> districtList = new MutableLiveData<>();
    private final MutableLiveData<String> selectedWard = new MutableLiveData<>();
    private final MutableLiveData<List<String>> wardList = new MutableLiveData<>();

    public MutableLiveData<String> getSelectedProvince() {
        return selectedProvince;
    }

    public MutableLiveData<List<String>> getProvinceList() {
        return provinceList;
    }

    public MutableLiveData<String> getCurrentDropDown() {
        return currentDropDown;
    }
}
