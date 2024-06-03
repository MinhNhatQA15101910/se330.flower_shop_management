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
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.LoginViewModel;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding _fragmentLoginBinding;
    private AuthViewModel _authViewModel;
    private LoginViewModel _loginViewModel;
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

        // Observe
        observeData();

        return _fragmentLoginBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        _fragmentLoginBinding = null;
    }

    private void setViewModels() {
        _authViewModel = new ViewModelProvider(requireActivity()).get(AuthViewModel.class);
        _loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        _fragmentLoginBinding.setLoginViewModel(_loginViewModel);
    }

    private void setEventHandlers() {
        _loginEventHandler = new LoginEventHandler(getContext(), _authViewModel, _loginViewModel);

        _fragmentLoginBinding.setLoginEventHandler(_loginEventHandler);
    }

    private void observeData() {
        _loginViewModel.getIsEmailEmpty().observe(getViewLifecycleOwner(), isEmailEmpty -> {
            if (isEmailEmpty) {
                _fragmentLoginBinding.emailLayout.setError("Email cannot be empty.");
            } else {
                _fragmentLoginBinding.emailLayout.setErrorEnabled(false);
            }
        });

        _loginViewModel.getIsEmailValid().observe(getViewLifecycleOwner(), isEmailValid -> {
            if (!isEmailValid) {
                _fragmentLoginBinding.emailLayout.setError("Invalid email.");
            } else {
                _fragmentLoginBinding.emailLayout.setErrorEnabled(false);
            }
        });

        _loginViewModel.getIsPasswordEmpty().observe(getViewLifecycleOwner(), isPasswordEmpty -> {
            if (isPasswordEmpty) {
                _fragmentLoginBinding.passwordLayout.setError("Password cannot be empty.");
            } else {
                _fragmentLoginBinding.passwordLayout.setErrorEnabled(false);
            }
        });

        _loginViewModel.getIsPasswordLengthValid().observe(getViewLifecycleOwner(), isPasswordLengthValid -> {
            if (!isPasswordLengthValid) {
                _fragmentLoginBinding.passwordLayout.setError("Password must be at least 8 characters long.");
            } else {
                _fragmentLoginBinding.passwordLayout.setErrorEnabled(false);
            }
        });

        _loginViewModel.getIsLoginLoading().observe(getViewLifecycleOwner(), isLoginLoading -> {
            _fragmentLoginBinding.loginBtn.setVisibility(
                    isLoginLoading ?
                            View.INVISIBLE :
                            View.VISIBLE
            );
            _fragmentLoginBinding.loginLoader.setVisibility(
                    isLoginLoading ?
                            View.VISIBLE :
                            View.INVISIBLE
            );
        });

        _loginViewModel.getIsLoginWithGoogleLoading().observe(getViewLifecycleOwner(), isLoginWithGoogleLoading -> {
            _fragmentLoginBinding.loginWithGoogleBtn.setVisibility(
                    isLoginWithGoogleLoading ?
                            View.INVISIBLE :
                            View.VISIBLE
            );
            _fragmentLoginBinding.loginWithGoogleLoader.setVisibility(
                    isLoginWithGoogleLoading ?
                            View.VISIBLE :
                            View.INVISIBLE
            );
        });
    }
}
