package com.donhat.se330.flower_shop_management.frontend.features.intro.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityIntroBinding;
import com.donhat.se330.flower_shop_management.frontend.features.intro.eventhandlers.IntroEventHandler;

public class IntroActivity extends AppCompatActivity {
    private ActivityIntroBinding _activityIntroBinding;
    private IntroEventHandler _introEventHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _activityIntroBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_intro
        );

        // Event handler
        _introEventHandler = new IntroEventHandler(this);

        _activityIntroBinding.setIntroEventHandler(_introEventHandler);
    }
}