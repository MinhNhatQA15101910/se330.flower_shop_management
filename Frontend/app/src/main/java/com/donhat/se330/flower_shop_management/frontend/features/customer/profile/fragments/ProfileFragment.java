package com.donhat.se330.flower_shop_management.frontend.features.customer.profile.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentProfileBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.profile.eventhandlers.ProfileEventHandler;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding _fragmentProfileBinding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        _fragmentProfileBinding= DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_profile,
                container,
                false
        );

        ProfileEventHandler _profileEventHandler = new ProfileEventHandler(getContext());

        _fragmentProfileBinding.setProfileFragmentEventHandler(_profileEventHandler);

        GlobalVariables.getUser().observe(getViewLifecycleOwner(), user -> {
            if(user!=null){
                _fragmentProfileBinding.titleUsername.setText(user.getUsername());
            }
        });

        return _fragmentProfileBinding.getRoot();
    }
}