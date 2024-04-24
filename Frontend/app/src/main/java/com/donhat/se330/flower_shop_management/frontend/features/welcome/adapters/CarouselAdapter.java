package com.donhat.se330.flower_shop_management.frontend.features.welcome.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class CarouselAdapter extends FragmentStateAdapter {
    private final ArrayList<Fragment> _carouselFragments = new ArrayList<>();

    public CarouselAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return _carouselFragments.get(position);
    }

    @Override
    public int getItemCount() {
        return _carouselFragments.size();
    }

    public void addCarouselFragment(Fragment carouselFragment) {
        _carouselFragments.add(carouselFragment);
    }
}
