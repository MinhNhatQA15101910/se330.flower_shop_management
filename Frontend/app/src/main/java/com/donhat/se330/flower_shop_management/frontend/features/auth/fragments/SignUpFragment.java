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
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentSignUpBinding;
import com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers.SignUpEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.SignUpViewModel;

public class SignUpFragment extends Fragment {
    private FragmentSignUpBinding _fragmentSignUpBinding;
    private AuthViewModel _authViewModel;
    private SignUpViewModel _signUpViewModel;
    private SignUpEventHandler _signUpEventHandler;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        _fragmentSignUpBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_sign_up,
                container,
                false
        );

        // View model
        setViewModels();

        // Event handler
        setEventHandlers();

        // Observe
        observeData();

        return _fragmentSignUpBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        _fragmentSignUpBinding = null;
    }

    private void setViewModels() {
        _authViewModel = new ViewModelProvider(requireActivity()).get(AuthViewModel.class);
        _signUpViewModel = new ViewModelProvider(this).get(SignUpViewModel.class);

        _fragmentSignUpBinding.setSignUpViewModel(_signUpViewModel);
    }

    private void setEventHandlers() {
        _signUpEventHandler = new SignUpEventHandler(getContext(), _authViewModel, _signUpViewModel);

        _fragmentSignUpBinding.setSignUpEventHandler(_signUpEventHandler);
    }

    private void observeData() {
        _signUpViewModel.getIsEmailEmpty().observe(getViewLifecycleOwner(), isEmailEmpty -> {
            if (isEmailEmpty) {
                _fragmentSignUpBinding.emailLayout.setError("Email cannot be empty.");
            } else {
                _fragmentSignUpBinding.emailLayout.setErrorEnabled(false);
            }
        });

        _signUpViewModel.getIsEmailValid().observe(getViewLifecycleOwner(), isEmailValid -> {
            if (!isEmailValid) {
                _fragmentSignUpBinding.emailLayout.setError("Invalid email.");
            } else {
                _fragmentSignUpBinding.emailLayout.setErrorEnabled(false);
            }
        });

        _signUpViewModel.getIsUsernameEmpty().observe(getViewLifecycleOwner(), isUsernameEmpty -> {
            if (isUsernameEmpty) {
                _fragmentSignUpBinding.usernameLayout.setError("Username cannot be empty.");
            } else {
                _fragmentSignUpBinding.usernameLayout.setErrorEnabled(false);
            }
        });

        _signUpViewModel.getIsUsernameLengthValid().observe(getViewLifecycleOwner(), isUsernameLengthValid -> {
            if (!isUsernameLengthValid) {
                _fragmentSignUpBinding.usernameLayout.setError("Username must be at least 6 characters long.");
            } else {
                _fragmentSignUpBinding.usernameLayout.setErrorEnabled(false);
            }
        });

        _signUpViewModel.getIsPasswordEmpty().observe(getViewLifecycleOwner(), isPasswordEmpty -> {
            if (isPasswordEmpty) {
                _fragmentSignUpBinding.passwordLayout.setError("Password cannot be empty.");
            } else {
                _fragmentSignUpBinding.passwordLayout.setErrorEnabled(false);
            }
        });

        _signUpViewModel.getIsPasswordLengthValid().observe(getViewLifecycleOwner(), isPasswordLengthValid -> {
            if (!isPasswordLengthValid) {
                _fragmentSignUpBinding.passwordLayout.setError("Password must be at least 8 characters long.");
            } else {
                _fragmentSignUpBinding.passwordLayout.setErrorEnabled(false);
            }
        });

        _signUpViewModel.getIsPasswordConfirmedEmpty().observe(getViewLifecycleOwner(), isPasswordConfirmedEmpty -> {
            if (isPasswordConfirmedEmpty) {
                _fragmentSignUpBinding.passwordConfirmedLayout.setError("Password confirm cannot be empty.");
            } else {
                _fragmentSignUpBinding.passwordConfirmedLayout.setErrorEnabled(false);
            }
        });

        _signUpViewModel.getIsPasswordMatch().observe(getViewLifecycleOwner(), isUsernameLengthValid -> {
            if (!isUsernameLengthValid) {
                _fragmentSignUpBinding.passwordConfirmedLayout.setError("Password not match.");
            } else {
                _fragmentSignUpBinding.passwordConfirmedLayout.setErrorEnabled(false);
            }
        });

        _signUpViewModel.getIsSignUpLoading().observe(getViewLifecycleOwner(), isSignUpLoading -> {
            _fragmentSignUpBinding.signUpBtn.setVisibility(
                    isSignUpLoading ?
                            View.INVISIBLE :
                            View.VISIBLE
            );
            _fragmentSignUpBinding.signUpLoader.setVisibility(
                    isSignUpLoading ?
                            View.VISIBLE :
                            View.INVISIBLE
            );
        });

        _signUpViewModel.getIsSignUpWithGoogleLoading().observe(getViewLifecycleOwner(), isSignUpWithGoogleLoading -> {
            _fragmentSignUpBinding.signUpWithGoogleBtn.setVisibility(
                    isSignUpWithGoogleLoading ?
                            View.INVISIBLE :
                            View.VISIBLE
            );
            _fragmentSignUpBinding.signUpWithGoogleLoader.setVisibility(
                    isSignUpWithGoogleLoading ?
                            View.VISIBLE :
                            View.INVISIBLE
            );
        });

        _signUpViewModel.getIsContinueAsAGuessLoading().observe(getViewLifecycleOwner(), isContinueAsAGuessLoading -> {
            _fragmentSignUpBinding.continueAsAGuestBtn.setVisibility(
                    isContinueAsAGuessLoading ?
                            View.INVISIBLE :
                            View.VISIBLE
            );
            _fragmentSignUpBinding.continueAsAGuessLoader.setVisibility(
                    isContinueAsAGuessLoading ?
                            View.VISIBLE :
                            View.INVISIBLE
            );
        });
    }
}