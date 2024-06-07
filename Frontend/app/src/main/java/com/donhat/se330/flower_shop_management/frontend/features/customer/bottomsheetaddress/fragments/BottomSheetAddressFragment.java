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
import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentBottomSheetAddressBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.eventhandlers.BottomSheetAddressEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.viewmodels.BottomSheetAddressViewModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetAddressFragment extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentBottomSheetAddressBinding _fragmentBottomSheetAddressBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_bottom_sheet_address, container, false);

        BottomSheetAddressViewModel _bottomSheetAddressViewModel = new ViewModelProvider(this).get(BottomSheetAddressViewModel.class);

        BottomSheetAddressEventHandler _bottomSheetAddressEventHandler = new BottomSheetAddressEventHandler(_bottomSheetAddressViewModel, getContext(),this);

        _fragmentBottomSheetAddressBinding.setFragmentBottomSheetAddressViewModel(_bottomSheetAddressViewModel);
        _fragmentBottomSheetAddressBinding.setFragmentBottomSheetAddressEventHandler(_bottomSheetAddressEventHandler);




        _bottomSheetAddressViewModel.getSelectedProvince().observe(getViewLifecycleOwner(), selectedProvince -> {
            if(selectedProvince!=null){
                _fragmentBottomSheetAddressBinding.selectedProvince.setText(selectedProvince);
                _fragmentBottomSheetAddressBinding.selectedDistrict.setText("Select district");
                _fragmentBottomSheetAddressBinding.selectedWard.setText("Select ward");
                _bottomSheetAddressViewModel.getSelectedDistrict().setValue(null);
                _bottomSheetAddressViewModel.getSelectedWard().setValue(null);

            }
        });

        _bottomSheetAddressViewModel.getSelectedDistrict().observe(getViewLifecycleOwner(), selectedDistrict -> {
            if(selectedDistrict!=null){
                _fragmentBottomSheetAddressBinding.selectedDistrict.setText(selectedDistrict);
                _fragmentBottomSheetAddressBinding.selectedWard.setText("Select ward");
                _bottomSheetAddressViewModel.getSelectedWard().setValue(null);

            }
        });

        _bottomSheetAddressViewModel.getSelectedWard().observe(getViewLifecycleOwner(), selectedWard -> {
            if(selectedWard!=null){
                _fragmentBottomSheetAddressBinding.selectedWard.setText(selectedWard);
            }
        });

        return _fragmentBottomSheetAddressBinding.getRoot();
    }
    @Override
    public void onStart() {
        super.onStart();
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) getDialog();
        if (bottomSheetDialog != null) {
            View bottomSheet = bottomSheetDialog.findViewById(com.google.android.material.R.id.design_bottom_sheet);
            BottomSheetBehavior<View> behavior = BottomSheetBehavior.from(bottomSheet);
            behavior.setHideable(false); // Disable hide on swipe down
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED); // Always expanded by default
        }
    }
}
