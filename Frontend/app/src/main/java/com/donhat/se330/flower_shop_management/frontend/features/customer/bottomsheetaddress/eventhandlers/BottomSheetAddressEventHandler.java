package com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.eventhandlers;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.features.comments.dropdown.callbacks.SelectionCallback;
import com.donhat.se330.flower_shop_management.frontend.features.comments.dropdown.fragments.DropdownFragment;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities.District;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities.Province;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities.ShippingInfo;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities.Ward;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.fragments.BottomSheetAddressFragment;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.servicehandlers.BottomSheetAddressServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.viewmodels.BottomSheetAddressViewModel;

import java.util.ArrayList;
import java.util.List;

import kotlin.contracts.Returns;

public class BottomSheetAddressEventHandler implements SelectionCallback {
    private final BottomSheetAddressViewModel _bottomSheetAddressViewModel;
    private final BottomSheetAddressServiceHandler _bottomSheetAddressServiceHandler;
    private final Context _context;
    private final BottomSheetAddressFragment _fragment;

    public BottomSheetAddressEventHandler(BottomSheetAddressViewModel bottomSheetAddressViewModel, Context context, BottomSheetAddressFragment fragment) {
        _bottomSheetAddressViewModel = bottomSheetAddressViewModel;
        _context = context;
        _fragment = fragment;
        _bottomSheetAddressServiceHandler = new BottomSheetAddressServiceHandler(_context, _bottomSheetAddressViewModel);

        // Observer for Province List
        _bottomSheetAddressViewModel.getProvinceList().observe((FragmentActivity) _context, provinceList -> {
            if (provinceList != null && "ProvinceDropdown".equals(_bottomSheetAddressViewModel.getCurrentDropDown().getValue())) {
                showProvinceDropdown((FragmentActivity) _context, provinceList);
            }
        });

        // Observer for District List
        _bottomSheetAddressViewModel.getDistrictList().observe((FragmentActivity) _context, districtList -> {
            if (districtList != null && "DistrictDropdown".equals(_bottomSheetAddressViewModel.getCurrentDropDown().getValue())) {
                showDistrictDropdown((FragmentActivity) _context, districtList);
            }
        });

        // Observer for Ward List
        _bottomSheetAddressViewModel.getWardList().observe((FragmentActivity) _context, wardList -> {
            if (wardList != null && "WardDropdown".equals(_bottomSheetAddressViewModel.getCurrentDropDown().getValue())) {
                showWardDropdown((FragmentActivity) _context, wardList);
            }
        });
    }

    public void onClickDropdownProvince(View view) {
        _bottomSheetAddressViewModel.getCurrentDropDown().setValue("ProvinceDropdown");
        _bottomSheetAddressServiceHandler.getProvinces();
    }

    public void onClickDropdownDistrict(View view) {
        if (_bottomSheetAddressViewModel.getSelectedProvince().getValue() != null && !_bottomSheetAddressViewModel.getSelectedProvince().getValue().equals("Select province")) {
            _bottomSheetAddressViewModel.getCurrentDropDown().setValue("DistrictDropdown");
            _bottomSheetAddressServiceHandler.getDistricts(_bottomSheetAddressViewModel.getSelectedProvince().getValue());
        }
    }

    public void onClickDropdownWard(View view) {
        if (_bottomSheetAddressViewModel.getSelectedDistrict().getValue() != null && !_bottomSheetAddressViewModel.getSelectedDistrict().getValue().equals("Select district")) {
            _bottomSheetAddressViewModel.getCurrentDropDown().setValue("WardDropdown");
            _bottomSheetAddressServiceHandler.getWards(_bottomSheetAddressViewModel.getSelectedDistrict().getValue());
        }
    }
    public Boolean verifyAddress(View view) {
        ShippingInfo shippingInfo = GlobalVariables.getShippingInfo().getValue();
        if (shippingInfo != null) {
            boolean isEmpty = (shippingInfo.provinceName == null || shippingInfo.provinceName.trim().isEmpty()) &&
                    (shippingInfo.districtName == null || shippingInfo.districtName.trim().isEmpty()) &&
                    (shippingInfo.wardName == null || shippingInfo.wardName.trim().isEmpty()) &&
                    (shippingInfo.street == null || shippingInfo.street.trim().isEmpty()) &&
                    (shippingInfo.fullName == null || shippingInfo.fullName.trim().isEmpty()) &&
                    (shippingInfo.PhoneNumber == null || shippingInfo.PhoneNumber.trim().isEmpty());

            if (isEmpty) {
                Toast.makeText(view.getContext(), "Empty information", Toast.LENGTH_SHORT).show();
                return false; // Address is not valid
            } else {
                return true; // Address is valid
            }
        }
        return false; // Address is not valid (shippingInfo is null)
    }



    private void showProvinceDropdown(FragmentActivity activity, List<Province> provinceList) {
        ArrayList<String> stringList = new ArrayList<>();
        for (Province province : provinceList) {
            stringList.add(province.getProvinceName());
        }
        DropdownFragment dropdownFragment = DropdownFragment.newInstance(stringList, this);
        dropdownFragment.show(activity.getSupportFragmentManager(), dropdownFragment.getTag());
    }

    private void showDistrictDropdown(FragmentActivity activity, List<District> districtList) {
        ArrayList<String> stringList = new ArrayList<>();
        for (District district : districtList) {
            stringList.add(district.getDistrictName());
        }
        DropdownFragment dropdownFragment = DropdownFragment.newInstance(stringList, this);
        dropdownFragment.show(activity.getSupportFragmentManager(), dropdownFragment.getTag());
    }

    private void showWardDropdown(FragmentActivity activity, List<Ward> wardList) {
        ArrayList<String> stringList = new ArrayList<>();
        for (Ward ward : wardList) {
            stringList.add(ward.getWardName());
        }
        DropdownFragment dropdownFragment = DropdownFragment.newInstance(stringList, this);
        dropdownFragment.show(activity.getSupportFragmentManager(), dropdownFragment.getTag());
    }

    public void onConfirm(View view) {
        String provinceName = _bottomSheetAddressViewModel.getSelectedProvince().getValue();
        String districtName = _bottomSheetAddressViewModel.getSelectedDistrict().getValue();
        String wardName = _bottomSheetAddressViewModel.getSelectedWard().getValue();
        String streetName = _bottomSheetAddressViewModel.getStreetNumber().getValue();
        String fullName = _bottomSheetAddressViewModel.getFullName().getValue();
        String phoneNumber = _bottomSheetAddressViewModel.getPhoneNumber().getValue();

        // Check for empty values
        if (provinceName == null || provinceName.trim().isEmpty() ||
                districtName == null || districtName.trim().isEmpty() ||
                wardName == null || wardName.trim().isEmpty() ||
                streetName == null || streetName.trim().isEmpty() ||
                fullName == null || fullName.trim().isEmpty() ||
                phoneNumber == null || phoneNumber.trim().isEmpty()) {

            // Show Toast message indicating which field(s) are empty
            Toast.makeText(view.getContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return; // Exit method and prevent confirmation
        }

        // If all fields are filled, proceed to set shipping info and dismiss fragment
        ShippingInfo shippingInfo = new ShippingInfo(provinceName, districtName, wardName, streetName, fullName, phoneNumber);
        GlobalVariables.getShippingInfo().setValue(shippingInfo);

        // Dismiss the fragment
        _fragment.dismiss();
    }


    public void onDismiss(View view){
        _fragment.dismiss();
    }

    @Override
    public void onItemSelected(String selectedItem) {
        String currentDropDown = _bottomSheetAddressViewModel.getCurrentDropDown().getValue();
        if (currentDropDown != null) {
            switch (currentDropDown) {
                case "ProvinceDropdown":
                    _bottomSheetAddressViewModel.getSelectedProvince().setValue(selectedItem);
                    _bottomSheetAddressViewModel.getSelectedDistrict().setValue("Select district");
                    _bottomSheetAddressViewModel.getSelectedWard().setValue("Select ward");
                    break;
                case "DistrictDropdown":
                    _bottomSheetAddressViewModel.getSelectedDistrict().setValue(selectedItem);
                    // Clear selected ward when district changes
                    _bottomSheetAddressViewModel.getSelectedWard().setValue("Select ward");
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
