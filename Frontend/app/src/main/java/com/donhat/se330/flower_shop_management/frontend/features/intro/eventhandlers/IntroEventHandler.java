package com.donhat.se330.flower_shop_management.frontend.features.intro.eventhandlers;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.donhat.se330.flower_shop_management.frontend.features.welcome.activities.WelcomeActivity;

public class IntroEventHandler {
    private final Context _context;

    public IntroEventHandler(Context context) {
        _context = context;
    }

    public void onIntroClicked(View view) {
        Intent intent = new Intent(_context.getApplicationContext(), WelcomeActivity.class);
        _context.startActivity(intent);
    }
}
