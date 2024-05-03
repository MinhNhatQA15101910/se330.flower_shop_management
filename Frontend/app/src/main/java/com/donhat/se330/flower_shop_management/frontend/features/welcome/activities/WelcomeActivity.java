package com.donhat.se330.flower_shop_management.frontend.features.welcome.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityWelcomeBinding;
import com.donhat.se330.flower_shop_management.frontend.features.welcome.adapters.CarouselAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.welcome.eventhandlers.WelcomeEventHandler;
import com.donhat.se330.flower_shop_management.frontend.features.welcome.fragments.CarouselFragment1;
import com.donhat.se330.flower_shop_management.frontend.features.welcome.fragments.CarouselFragment2;
import com.donhat.se330.flower_shop_management.frontend.features.welcome.fragments.CarouselFragment3;
import com.donhat.se330.flower_shop_management.frontend.features.welcome.viewmodels.WelcomeViewModel;

public class WelcomeActivity extends AppCompatActivity {
    private ActivityWelcomeBinding _activityWelcomeBinding;

    private CarouselAdapter _carouselAdapter;
    private WelcomeViewModel _welcomeViewModel;
    private WelcomeEventHandler _welcomeEventHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _activityWelcomeBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_welcome
        );

        // Carousel view
        _carouselAdapter = new CarouselAdapter(
                getSupportFragmentManager(),
                getLifecycle()
        );
        _carouselAdapter.addCarouselFragment(new CarouselFragment1());
        _carouselAdapter.addCarouselFragment(new CarouselFragment2());
        _carouselAdapter.addCarouselFragment(new CarouselFragment3());

        _activityWelcomeBinding.viewPager2.setAdapter(_carouselAdapter);

        _activityWelcomeBinding.dotsIndicator.attachTo(_activityWelcomeBinding.viewPager2);

        // View model
        _welcomeViewModel = new ViewModelProvider(this).get(WelcomeViewModel.class);

        // Event handler
        _welcomeEventHandler = new WelcomeEventHandler(this, _welcomeViewModel);

        _activityWelcomeBinding.setWelcomeEventHandler(_welcomeEventHandler);

        _activityWelcomeBinding.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                _welcomeEventHandler.onViewPager2PageChanged(position);
            }
        });

        // Observe
        _welcomeViewModel.getFragmentIndex().observe(this, fragmentIndex -> {
            _activityWelcomeBinding.viewPager2.setCurrentItem(fragmentIndex, true);
            _activityWelcomeBinding.welcomeBtn.setText(
                    fragmentIndex == 0 ?
                            "Get Started" :
                            fragmentIndex == 1 ?
                                    "Next" :
                                    "Ready"
            );
        });
    }
}