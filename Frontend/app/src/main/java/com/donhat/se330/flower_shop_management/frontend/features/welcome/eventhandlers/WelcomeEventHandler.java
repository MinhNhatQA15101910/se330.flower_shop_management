package com.donhat.se330.flower_shop_management.frontend.features.welcome.eventhandlers;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.donhat.se330.flower_shop_management.frontend.features.auth.activities.AuthActivity;
import com.donhat.se330.flower_shop_management.frontend.features.welcome.viewmodels.WelcomeViewModel;

public class WelcomeEventHandler {
    private final Context _context;
    private final WelcomeViewModel _welcomeViewModel;

    public WelcomeEventHandler(Context context, WelcomeViewModel welcomeViewModel) {
        _context = context;
        _welcomeViewModel = welcomeViewModel;
    }

    public void onWelcomeBtnClicked(View view) {
        int fragmentIndex = _welcomeViewModel.getFragmentIndex().getValue();
        if (fragmentIndex == 2) {
            Intent intent = new Intent(_context.getApplicationContext(), AuthActivity.class);
            _context.startActivity(intent);
        } else {
            _welcomeViewModel.getFragmentIndex().setValue(fragmentIndex + 1);
        }
    }

    public void onViewPager2PageChanged(int position) {
        _welcomeViewModel.getFragmentIndex().setValue(position);
    }
}
