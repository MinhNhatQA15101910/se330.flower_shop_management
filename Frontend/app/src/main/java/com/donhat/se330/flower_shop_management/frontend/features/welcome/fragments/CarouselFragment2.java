package com.donhat.se330.flower_shop_management.frontend.features.welcome.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentCarousel2Binding;

public class CarouselFragment2 extends Fragment {
    private FragmentCarousel2Binding _fragmentCarousel2Binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        _fragmentCarousel2Binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_carousel2,
                container,
                false
        );

        return _fragmentCarousel2Binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        _fragmentCarousel2Binding = null;
    }
}