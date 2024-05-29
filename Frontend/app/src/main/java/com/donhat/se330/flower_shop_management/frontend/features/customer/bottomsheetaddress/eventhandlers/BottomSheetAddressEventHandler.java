package com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.eventhandlers;

import android.content.Context;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

import com.donhat.se330.flower_shop_management.frontend.features.comments.dropdown.callbacks.SelectionCallback;
import com.donhat.se330.flower_shop_management.frontend.features.comments.dropdown.fragments.DropdownFragment;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.viewmodels.BottomSheetAddressViewModel;

import java.util.ArrayList;

public class BottomSheetAddressEventHandler implements SelectionCallback {
    private final BottomSheetAddressViewModel _bottomSheetAddressViewModel;
    private final Context _context;

    public BottomSheetAddressEventHandler(BottomSheetAddressViewModel bottomSheetAddressViewModel, Context context) {
        _bottomSheetAddressViewModel = bottomSheetAddressViewModel;
        _context = context;
    }

    public void onClickDropdownProvince(View view) {
        FragmentActivity activity = (FragmentActivity) _context;
        _bottomSheetAddressViewModel.getCurrentDropDown().setValue("ProvinceDropdown");

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("Province 1");
        stringList.add("Province 2");
        stringList.add("Province 3");
        _bottomSheetAddressViewModel.getProvinceList().setValue(stringList);
        DropdownFragment dropdownFragment = DropdownFragment.newInstance(stringList, this);
        dropdownFragment.show(activity.getSupportFragmentManager(), dropdownFragment.getTag());
    }

    public void onClickDropdownDistrict(View view) {
        FragmentActivity activity = (FragmentActivity) _context;
        _bottomSheetAddressViewModel.getCurrentDropDown().setValue("DistrictDropdown");

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("District 1");
        stringList.add("District 2");
        stringList.add("District 3");
        _bottomSheetAddressViewModel.getDistrictList().setValue(stringList);
        DropdownFragment dropdownFragment = DropdownFragment.newInstance(stringList, this);
        dropdownFragment.show(activity.getSupportFragmentManager(), dropdownFragment.getTag());
    }

    public void onClickDropdownWard(View view) {
        FragmentActivity activity = (FragmentActivity) _context;
        _bottomSheetAddressViewModel.getCurrentDropDown().setValue("WardDropdown");

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("District 1");
        stringList.add("District 2");
        stringList.add("District 3");
        _bottomSheetAddressViewModel.getWardList().setValue(stringList);
        DropdownFragment dropdownFragment = DropdownFragment.newInstance(stringList, this);
        dropdownFragment.show(activity.getSupportFragmentManager(), dropdownFragment.getTag());
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
