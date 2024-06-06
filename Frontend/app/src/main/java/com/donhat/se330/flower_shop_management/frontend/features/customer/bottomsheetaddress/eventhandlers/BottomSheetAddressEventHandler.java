package com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.eventhandlers;

import android.content.Context;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

import com.donhat.se330.flower_shop_management.frontend.features.comments.dropdown.callbacks.SelectionCallback;
import com.donhat.se330.flower_shop_management.frontend.features.comments.dropdown.fragments.DropdownFragment;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities.District;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities.Province;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities.Ward;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.servicehandlers.BottomSheetAddressServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.viewmodels.BottomSheetAddressViewModel;

import java.util.ArrayList;
import java.util.List;

public class BottomSheetAddressEventHandler implements SelectionCallback {
    private final BottomSheetAddressViewModel _bottomSheetAddressViewModel;
    private final BottomSheetAddressServiceHandler _bottomSheetAddressServiceHandler;
    private final Context _context;

    public BottomSheetAddressEventHandler(BottomSheetAddressViewModel bottomSheetAddressViewModel, Context context) {
        _bottomSheetAddressViewModel = bottomSheetAddressViewModel;
        _context = context;
        _bottomSheetAddressServiceHandler = new BottomSheetAddressServiceHandler(_context,_bottomSheetAddressViewModel);

    }

    public void onClickDropdownProvince(View view) {
        FragmentActivity activity = (FragmentActivity) _context;
        _bottomSheetAddressViewModel.getCurrentDropDown().setValue("ProvinceDropdown");
        _bottomSheetAddressServiceHandler.getProvinces();
        List<Province>provinceList = _bottomSheetAddressViewModel.getProvinceList().getValue();
        if (provinceList != null) {
            ArrayList<String> stringList = new ArrayList<>();
            for (Province province : provinceList) {
                stringList.add(province.getProvinceName());
            }
            DropdownFragment dropdownFragment = DropdownFragment.newInstance(stringList, this);
            dropdownFragment.show(activity.getSupportFragmentManager(), dropdownFragment.getTag());
        }
    }

    public void onClickDropdownDistrict(View view) {
        FragmentActivity activity = (FragmentActivity) _context;
        _bottomSheetAddressViewModel.getCurrentDropDown().setValue("DistrictDropdown");
        String provinceName= _bottomSheetAddressViewModel.getSelectedProvince().getValue();
        _bottomSheetAddressServiceHandler.getDistricts(provinceName);
        List<District> districtList = _bottomSheetAddressViewModel.getDistrictList().getValue();
        if (districtList != null) {
            ArrayList<String> stringList = new ArrayList<>();
            for (District district : districtList) {
                stringList.add(district.getDistrictName());
            }
            DropdownFragment dropdownFragment = DropdownFragment.newInstance(stringList, this);
            dropdownFragment.show(activity.getSupportFragmentManager(), dropdownFragment.getTag());
        }
    }

    public void onClickDropdownWard(View view) {
        FragmentActivity activity = (FragmentActivity) _context;
        _bottomSheetAddressViewModel.getCurrentDropDown().setValue("WardDropdown");
        _bottomSheetAddressServiceHandler.getWards("1");
        List<Ward> wardList = _bottomSheetAddressViewModel.getWardList().getValue();
        if (wardList != null) {
            ArrayList<String> stringList = new ArrayList<>();
            for (Ward ward : wardList) {
                stringList.add(ward.getWard_name());
            }
            DropdownFragment dropdownFragment = DropdownFragment.newInstance(stringList, this);
            dropdownFragment.show(activity.getSupportFragmentManager(), dropdownFragment.getTag());
        }
    }

    @Override
    public void onItemSelected(String selectedItem) {
        String currentDropDown = _bottomSheetAddressViewModel.getCurrentDropDown().getValue();
        if (currentDropDown != null) {
            switch (currentDropDown) {
                case "ProvinceDropdown":
                    _bottomSheetAddressViewModel.getSelectedProvince().setValue(selectedItem);
                    break;
                case "DistrictDropdown":
                    _bottomSheetAddressViewModel.getSelectedDistrict().setValue(selectedItem);
                    break;
                case "WardDropdown":
                    _bottomSheetAddressViewModel.getSelectedWard().setValue(selectedItem);
                    break;
                default:
                    break;
            }
        }
    }
}
