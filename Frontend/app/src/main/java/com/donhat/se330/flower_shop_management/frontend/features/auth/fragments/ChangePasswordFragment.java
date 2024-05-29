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
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentChangePasswordBinding;
import com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers.ChangePasswordEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.ChangePasswordViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.PinputViewModel;

public class ChangePasswordFragment extends Fragment {
    private FragmentChangePasswordBinding _fragmentChangePasswordBinding;
    private AuthViewModel _authViewModel;
    private ChangePasswordViewModel _changePasswordViewModel;
    private ChangePasswordEventHandler _changePasswordEventHandler;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        _fragmentChangePasswordBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_change_password,
                container,
                false
        );

        // View model
        setViewModels();

        // Event handler
        setEventHandlers();

        // Observe
        observeData();

        return _fragmentChangePasswordBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        _fragmentChangePasswordBinding = null;
    }

    private void setViewModels() {
        _authViewModel = new ViewModelProvider(requireActivity()).get(AuthViewModel.class);
        _changePasswordViewModel = new ViewModelProvider(this).get(ChangePasswordViewModel.class);

        _fragmentChangePasswordBinding.setChangePasswordViewModel(_changePasswordViewModel);
        _fragmentChangePasswordBinding.setLifecycleOwner(this);
    }

    private void setEventHandlers() {
        _changePasswordEventHandler = new ChangePasswordEventHandler(_authViewModel, _changePasswordViewModel, getContext());

        _fragmentChangePasswordBinding.setChangePasswordEventHandler(_changePasswordEventHandler);
    }

    private void observeData() {
        _changePasswordViewModel.getIsPasswordEmpty().observe(getViewLifecycleOwner(), isPasswordEmpty -> {
            if (isPasswordEmpty) {
                _fragmentChangePasswordBinding.passwordLayout.setError("Password cannot be empty.");
            } else {
                _fragmentChangePasswordBinding.passwordLayout.setErrorEnabled(false);
            }
        });

        _changePasswordViewModel.getIsPasswordLengthValid().observe(getViewLifecycleOwner(), isPasswordLengthValid -> {
            if (!isPasswordLengthValid) {
                _fragmentChangePasswordBinding.passwordLayout.setError("Password must be at least 8 characters long.");
            } else {
                _fragmentChangePasswordBinding.passwordLayout.setErrorEnabled(false);
            }
        });

        _changePasswordViewModel.getIsPasswordConfirmedEmpty().observe(getViewLifecycleOwner(), isPasswordConfirmedEmpty -> {
            if (isPasswordConfirmedEmpty) {
                _fragmentChangePasswordBinding.passwordConfirmedLayout.setError("Password cannot be empty.");
            } else {
                _fragmentChangePasswordBinding.passwordConfirmedLayout.setErrorEnabled(false);
            }
        });

        _changePasswordViewModel.getIsPasswordMatch().observe(getViewLifecycleOwner(), isPasswordMatch -> {
            if (!isPasswordMatch) {
                _fragmentChangePasswordBinding.passwordConfirmedLayout.setError("Password not match.");
            } else {
                _fragmentChangePasswordBinding.passwordConfirmedLayout.setErrorEnabled(false);
            }
        });

        _changePasswordViewModel.getIsUpdateLoading().observe(getViewLifecycleOwner(), isUpdateLoading -> {
            _fragmentChangePasswordBinding.updateBtn.setVisibility(
                    isUpdateLoading ?
                            View.INVISIBLE :
                            View.VISIBLE
            );
            _fragmentChangePasswordBinding.updateLoader.setVisibility(
                    isUpdateLoading ?
                            View.VISIBLE :
                            View.INVISIBLE
            );
        });
    }
}