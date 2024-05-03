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
import com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers.PinputEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.PinputViewModel;

public class PinputFragment extends Fragment {
    private FragmentPinputBinding _fragmentPinputBinding;
    private AuthViewModel _authViewModel;
    private PinputViewModel _pinputViewModel;
    private PinputEventHandler _pinputEventHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        _fragmentPinputBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_pinput,
                container,
                false
        );

        // View Models
        _authViewModel = new ViewModelProvider(getActivity()).get(AuthViewModel.class);
        _pinputViewModel = new ViewModelProvider(this).get(PinputViewModel.class);

        _fragmentPinputBinding.setPinputViewModel(_pinputViewModel);

        // Event handler
        _pinputEventHandler = new PinputEventHandler(_authViewModel, _pinputViewModel);

        _fragmentPinputBinding.setPinputEventHandler(_pinputEventHandler);

        // Pin View manager
        _fragmentPinputBinding.pinView.requestFocus();

        // Observe
        _authViewModel.getResentEmail().observe(getViewLifecycleOwner(), resentEmail -> {
            _fragmentPinputBinding.emailTextView.setText(resentEmail);
        });

        return _fragmentPinputBinding.getRoot();
    }
}