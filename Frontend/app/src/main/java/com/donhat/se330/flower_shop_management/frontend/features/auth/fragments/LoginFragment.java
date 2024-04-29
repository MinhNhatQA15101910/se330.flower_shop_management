package com.donhat.se330.flower_shop_management.frontend.features.auth.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentLoginBinding;
import com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers.LoginEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;

public class LoginFragment extends Fragment implements HasDefaultViewModelProviderFactory {
    private FragmentLoginBinding _fragmentLoginBinding;
    private AuthViewModel _authViewModel;
    private LoginEventHandler _loginEventHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        _fragmentLoginBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_login,
                container,
                false
        );

        // View model
        _authViewModel = new ViewModelProvider(getActivity()).get(AuthViewModel.class);

        // Event handler
        _loginEventHandler = new LoginEventHandler(getContext(), _authViewModel);

        _fragmentLoginBinding.setLoginEventHandler(_loginEventHandler);

        return _fragmentLoginBinding.getRoot();
    }
}