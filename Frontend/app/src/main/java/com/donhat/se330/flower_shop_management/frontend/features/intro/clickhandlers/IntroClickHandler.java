package com.donhat.se330.flower_shop_management.frontend.features.intro.clickhandlers;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.donhat.se330.flower_shop_management.frontend.features.intro.activities.WelcomeActivity;

public class IntroClickHandler {
    private final Context _context;

    public IntroClickHandler(Context context) {
        _context = context;
    }

    public void onIntroClicked(View view) {
        Intent intent = new Intent(_context.getApplicationContext(), WelcomeActivity.class);
        _context.startActivity(intent);
    }
}
