package com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentBottomSheetAddressBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.eventhandlers.BottomSheetAddressEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.viewmodels.BottomSheetAddressViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetAddressFragment extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentBottomSheetAddressBinding _fragmentBottomSheetAddressBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_bottom_sheet_address, container, false);

        BottomSheetAddressViewModel _bottomSheetAddressViewModel = new ViewModelProvider(this).get(BottomSheetAddressViewModel.class);

        BottomSheetAddressEventHandler _bottomSheetAddressEventHandler = new BottomSheetAddressEventHandler(_bottomSheetAddressViewModel, getContext());

        _fragmentBottomSheetAddressBinding.setFragmentBottomSheetAddressViewModel(_bottomSheetAddressViewModel);
        _fragmentBottomSheetAddressBinding.setFragmentBottomSheetAddressEventHandler(_bottomSheetAddressEventHandler);

        _bottomSheetAddressViewModel.getSelectedProvince().observe(getViewLifecycleOwner(), _fragmentBottomSheetAddressBinding.selectedProvince::setText);

        _bottomSheetAddressViewModel.getSelectedDistrict().observe(getViewLifecycleOwner(), _fragmentBottomSheetAddressBinding.selectedDistrict::setText);

        _bottomSheetAddressViewModel.getSelectedWard().observe(getViewLifecycleOwner(), _fragmentBottomSheetAddressBinding.selectedWard::setText);

        return _fragmentBottomSheetAddressBinding.getRoot();
    }
}
