package com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities.District;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities.Province;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities.Ward;

import java.util.List;

public class BottomSheetAddressViewModel extends ViewModel {
    private final MutableLiveData<String> currentDropDown = new MutableLiveData<>();
    private final MutableLiveData<String> selectedProvince = new MutableLiveData<>();
    private final MutableLiveData<List<Province>> provinceList = new MutableLiveData<>();

    private final MutableLiveData<String> selectedDistrict = new MutableLiveData<>();
    private final MutableLiveData<List<District>> districtList = new MutableLiveData<>();
    private final MutableLiveData<String> selectedWard = new MutableLiveData<>();
    private final MutableLiveData<List<Ward>> wardList = new MutableLiveData<>();

    private final MutableLiveData<String> currProvinceId = new MutableLiveData<>();
    private final MutableLiveData<String> currDistrictId = new MutableLiveData<>();
    public MutableLiveData<String> getCurrentDropDown() {
        return currentDropDown;
    }

    public MutableLiveData<String> getSelectedProvince() {
        return selectedProvince;
    }

    public MutableLiveData<List<Province>> getProvinceList() {
        return provinceList;
    }

    public MutableLiveData<String> getSelectedDistrict() {
        return selectedDistrict;
    }

    public MutableLiveData<List<District>> getDistrictList() {
        return districtList;
    }

    public MutableLiveData<String> getSelectedWard() {
        return selectedWard;
    }

    public MutableLiveData<List<Ward>> getWardList() {
        return wardList;
    }

    public MutableLiveData<String> getCurrProvinceId() {
        return currProvinceId;
    }

    public MutableLiveData<String> getCurrDistrictId() {
        return currDistrictId;
    }
}
