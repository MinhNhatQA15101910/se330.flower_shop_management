package com.donhat.se330.flower_shop_management.frontend.features.welcome.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentCarousel3Binding;

public class CarouselFragment3 extends Fragment {
    private FragmentCarousel3Binding _fragmentCarousel3Binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        _fragmentCarousel3Binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_carousel3,
                container,
                false
        );

        return _fragmentCarousel3Binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        _fragmentCarousel3Binding = null;
    }
}