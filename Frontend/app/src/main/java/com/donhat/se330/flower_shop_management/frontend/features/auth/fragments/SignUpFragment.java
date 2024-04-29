package com.donhat.se330.flower_shop_management.frontend.features.auth.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentSignUpBinding;
import com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers.SignUpEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;

public class SignUpFragment extends Fragment {
    private FragmentSignUpBinding _fragmentSignUpBinding;
    private AuthViewModel _authViewModel;
    private SignUpEventHandler _signUpEventHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        _fragmentSignUpBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_sign_up,
                container,
                false
        );

        // View model
        _authViewModel = new ViewModelProvider(getActivity()).get(AuthViewModel.class);

        // Event handler
        _signUpEventHandler = new SignUpEventHandler(getContext(), _authViewModel);

        _fragmentSignUpBinding.setSignUpEventHandler(_signUpEventHandler);

        return _fragmentSignUpBinding.getRoot();
    }
}