package com.donhat.se330.flower_shop_management.frontend.features.auth.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
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
        setViewModels();

        // Event handler
        setEventHandlers();

        // Observe
        observeData();

        // Listeners
        setListeners();

        return _fragmentPinputBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        _fragmentPinputBinding = null;
    }

    private void setViewModels() {
        _authViewModel = new ViewModelProvider(getActivity()).get(AuthViewModel.class);
        _pinputViewModel = new ViewModelProvider(this).get(PinputViewModel.class);

        _fragmentPinputBinding.setPinputViewModel(_pinputViewModel);
    }

    private void setEventHandlers() {
        _pinputEventHandler = new PinputEventHandler(_authViewModel, _pinputViewModel, getContext());

        _fragmentPinputBinding.setPinputEventHandler(_pinputEventHandler);
    }

    private void observeData() {
        _authViewModel.getResentEmail().observe(getViewLifecycleOwner(), resentEmail -> {
            _fragmentPinputBinding.emailTextView.setText(resentEmail);
        });

        _pinputViewModel.getIsVerifyLoading().observe(getViewLifecycleOwner(), isVerifyLoading -> {
            _fragmentPinputBinding.verifyBtn.setVisibility(
                    isVerifyLoading ?
                            View.INVISIBLE :
                            View.VISIBLE
            );
            _fragmentPinputBinding.verifyLoader.setVisibility(
                    isVerifyLoading ?
                            View.VISIBLE :
                            View.INVISIBLE
            );
        });
    }

    private void setListeners() {
        _fragmentPinputBinding.pinView.requestFocus();

        _fragmentPinputBinding.pinView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() == 6) {
                    _pinputEventHandler.verifyPincode();
                }
            }
        });
    }
}