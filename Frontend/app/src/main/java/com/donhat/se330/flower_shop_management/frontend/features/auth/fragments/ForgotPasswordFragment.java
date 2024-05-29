package com.donhat.se330.flower_shop_management.frontend.features.auth.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
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

public class ForgotPasswordFragment extends Fragment {
    private FragmentForgotPasswordBinding _fragmentForgotPasswordBinding;
    private AuthViewModel _authViewModel;
    private ForgotPasswordViewModel _forgotPasswordViewModel;
    private ForgotPasswordEventHandler _forgotPasswordEventHandler;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        _fragmentForgotPasswordBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_forgot_password,
                container,
                false
        );

        // View model
        setViewModels();

        // Event handler
        setEventHandlers();

        // Observe
        observeData();

        return _fragmentForgotPasswordBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        _fragmentForgotPasswordBinding = null;
    }

    private void setViewModels() {
        _authViewModel = new ViewModelProvider(requireActivity()).get(AuthViewModel.class);
        _forgotPasswordViewModel = new ViewModelProvider(this).get(ForgotPasswordViewModel.class);

        _fragmentForgotPasswordBinding.setForgotPasswordViewModel(_forgotPasswordViewModel);
        _fragmentForgotPasswordBinding.setLifecycleOwner(this);
    }

    private void setEventHandlers() {
        _forgotPasswordEventHandler = new ForgotPasswordEventHandler(_authViewModel, _forgotPasswordViewModel, getContext());

        _fragmentForgotPasswordBinding.setForgotPasswordEventHandler(_forgotPasswordEventHandler);
    }

    private void observeData() {
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

        _forgotPasswordViewModel.getIsVerifyLoading().observe(getViewLifecycleOwner(), isVerifyLoading -> {
            _fragmentForgotPasswordBinding.verifyBtn.setVisibility(
                    isVerifyLoading ?
                            View.INVISIBLE :
                            View.VISIBLE
            );
            _fragmentForgotPasswordBinding.verifyLoader.setVisibility(
                    isVerifyLoading ?
                            View.VISIBLE :
                            View.INVISIBLE
            );
        });
    }
}