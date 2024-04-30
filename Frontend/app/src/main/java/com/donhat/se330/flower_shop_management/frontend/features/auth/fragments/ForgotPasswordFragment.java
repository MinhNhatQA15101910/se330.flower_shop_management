package com.donhat.se330.flower_shop_management.frontend.features.auth.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentForgotPasswordBinding;
import com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers.ForgotPasswordEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.ForgotPasswordViewModel;
import com.donhat.se330.flower_shop_management.frontend.utils.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;

public class ForgotPasswordFragment extends Fragment implements ValidationManager.ErrorSetter {
    private FragmentForgotPasswordBinding _fragmentForgotPasswordBinding;
    private AuthViewModel _authViewModel;
    private ForgotPasswordViewModel _forgotPasswordViewModel;
    private ForgotPasswordEventHandler _forgotPasswordEventHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        _fragmentForgotPasswordBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_forgot_password,
                container,
                false
        );

        // View model
        _authViewModel = new ViewModelProvider(getActivity()).get(AuthViewModel.class);
        _forgotPasswordViewModel = new ViewModelProvider(this).get(ForgotPasswordViewModel.class);

        _fragmentForgotPasswordBinding.setForgotPasswordViewModel(_forgotPasswordViewModel);

        // Event handler
        _forgotPasswordEventHandler = new ForgotPasswordEventHandler(getContext(), _authViewModel, _forgotPasswordViewModel);

        _fragmentForgotPasswordBinding.setForgotPasswordEventHandler(_forgotPasswordEventHandler);

        // Observe
        _forgotPasswordViewModel.getIsEmailEmpty().observe(getViewLifecycleOwner(), isEmailEmpty -> {
            if (isEmailEmpty) {
                _fragmentForgotPasswordBinding.emailLayout.setError("Email cannot be empty.");
            } else {
                _fragmentForgotPasswordBinding.emailLayout.setErrorEnabled(false);
            }
        });

        _forgotPasswordViewModel.getIsEmailValid().observe(getViewLifecycleOwner(), isEmailValid -> {
            if (!isEmailValid) {
                _fragmentForgotPasswordBinding.emailLayout.setError("Invalid email.");
            } else {
                _fragmentForgotPasswordBinding.emailLayout.setErrorEnabled(false);
            }
        });

        return _fragmentForgotPasswordBinding.getRoot();
    }

    @Override
    public void setError(TextInputLayout textInputLayout, String errorMsg) {
        textInputLayout.setError(errorMsg);
    }
}