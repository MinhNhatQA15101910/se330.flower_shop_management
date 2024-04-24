package com.donhat.se330.flower_shop_management.frontend.features.welcome.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityWelcomeBinding;
import com.donhat.se330.flower_shop_management.frontend.features.welcome.adapters.CarouselAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.welcome.fragments.CarouselFragment1;
import com.donhat.se330.flower_shop_management.frontend.features.welcome.fragments.CarouselFragment2;
import com.donhat.se330.flower_shop_management.frontend.features.welcome.fragments.CarouselFragment3;
import com.google.android.material.tabs.TabLayoutMediator;

public class WelcomeActivity extends AppCompatActivity {
    private ActivityWelcomeBinding _activityWelcomeBinding;

    private CarouselAdapter _carouselAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        _activityWelcomeBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_welcome
        );

        _carouselAdapter = new CarouselAdapter(
                getSupportFragmentManager(),
                getLifecycle()
        );
        _carouselAdapter.addCarouselFragment(new CarouselFragment1());
        _carouselAdapter.addCarouselFragment(new CarouselFragment2());
        _carouselAdapter.addCarouselFragment(new CarouselFragment3());

        _activityWelcomeBinding.viewPager2.setAdapter(_carouselAdapter);

        _activityWelcomeBinding.dotsIndicator.attachTo(_activityWelcomeBinding.viewPager2);
    }
}