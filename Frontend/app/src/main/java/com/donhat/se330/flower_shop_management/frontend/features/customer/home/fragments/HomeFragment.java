package com.donhat.se330.flower_shop_management.frontend.features.customer.home.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentHomeBinding;
import com.donhat.se330.flower_shop_management.frontend.features.customer.home.viewmodels.HomeFragmentViewModel;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding _fragmentHomeBinding;
    private HomeFragmentViewModel _homeFragmentViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        

        _fragmentHomeBinding.setHomeFragmentViewModel(_homeFragmentViewModel);

        return _fragmentHomeBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        _fragmentHomeBinding = null;
    }
}