package com.donhat.se330.flower_shop_management.frontend.features.auth.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentPinputBinding;
import com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers.SignUpEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;

public class PinputFragment extends Fragment {
    private FragmentPinputBinding _fragmentPinputBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        _fragmentPinputBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_pinput,
                container,
                false
        );

        // Pin View manager
        _fragmentPinputBinding.pinView.requestFocus();

        return _fragmentPinputBinding.getRoot();
    }
}