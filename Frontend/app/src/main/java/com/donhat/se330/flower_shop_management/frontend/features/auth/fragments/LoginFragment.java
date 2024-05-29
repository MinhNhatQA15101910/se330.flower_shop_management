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
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentLoginBinding;
import com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers.LoginEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding _fragmentLoginBinding;
    private AuthViewModel _authViewModel;
    private LoginEventHandler _loginEventHandler;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        _fragmentLoginBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_login,
                container,
                false
        );

        // View model
        setViewModels();

        // Event handler
        setEventHandlers();

        return _fragmentLoginBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        _fragmentLoginBinding = null;
    }

    private void setViewModels() {
        _authViewModel = new ViewModelProvider(requireActivity()).get(AuthViewModel.class);
    }

    private void setEventHandlers() {
        _loginEventHandler = new LoginEventHandler(getContext(), _authViewModel);

        _fragmentLoginBinding.setLoginEventHandler(_loginEventHandler);
    }
}