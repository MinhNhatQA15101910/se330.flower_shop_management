package com.donhat.se330.flower_shop_management.frontend.features.customer.order.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.donhat.se330.flower_shop_management.frontend.features.customer.order.fragments.AllOrderFragment;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.fragments.DeliveredOrderFragment;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.fragments.InDeliveryOrderFragment;
import com.donhat.se330.flower_shop_management.frontend.features.customer.order.fragments.PendingOrderFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new AllOrderFragment();
            case 1:
                return new PendingOrderFragment();
            case 2:
                return new DeliveredOrderFragment();
            case 3:
                return new InDeliveryOrderFragment();
            default:
                return new AllOrderFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
