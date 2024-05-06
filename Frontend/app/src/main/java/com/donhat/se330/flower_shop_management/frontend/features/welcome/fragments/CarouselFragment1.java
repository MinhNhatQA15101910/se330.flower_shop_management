package com.donhat.se330.flower_shop_management.frontend.features.welcome.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.FragmentCarousel1Binding;

public class CarouselFragment1 extends Fragment {
    private FragmentCarousel1Binding _fragmentCarousel1Binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        _fragmentCarousel1Binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_carousel1,
                container,
                false
        );

        return _fragmentCarousel1Binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        _fragmentCarousel1Binding = null;
    }
}