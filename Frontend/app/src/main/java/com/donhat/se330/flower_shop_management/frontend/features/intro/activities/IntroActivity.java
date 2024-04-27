package com.donhat.se330.flower_shop_management.frontend.features.intro.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        _activityIntroBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_intro
        );

        _introEventHandler = new IntroEventHandler(this);

        _activityIntroBinding.setIntroEventHandler(_introEventHandler);
    }
}