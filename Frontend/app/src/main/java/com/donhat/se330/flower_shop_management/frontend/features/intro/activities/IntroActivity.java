package com.donhat.se330.flower_shop_management.frontend.features.intro.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.databinding.ActivityIntroBinding;
import com.donhat.se330.flower_shop_management.frontend.features.auth.activities.AuthActivity;
import com.donhat.se330.flower_shop_management.frontend.features.auth.servicehandlers.AuthServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.navbar.activities.CustomerNavBarActivity;
import com.donhat.se330.flower_shop_management.frontend.features.intro.eventhandlers.IntroEventHandler;
import com.donhat.se330.flower_shop_management.frontend.models.User;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class IntroActivity extends AppCompatActivity {
    private ActivityIntroBinding _activityIntroBinding;
    private IntroEventHandler _introEventHandler;

    @Override
    protected void onStart() {
        super.onStart();

        checkAndNavigate();
    }

    private void checkAndNavigate() {
        SharedPreferences prefs = getSharedPreferences(
                getString(R.string.token_prefs_name),
                Context.MODE_PRIVATE
        );

        boolean isFirstLaunch = prefs.getBoolean("is-first-launch", true);
        if (isFirstLaunch) {
            return;
        }

        AuthServiceHandler authServiceHandler = new AuthServiceHandler(this);
        CompletableFuture<Void> future = authServiceHandler.getUserData();
        future.thenAccept(result -> {
            User currentUser = GlobalVariables.getUser().getValue();
            if (Objects.requireNonNull(currentUser).getRole().equals("user")) {
                Intent intent = new Intent(IntroActivity.this, CustomerNavBarActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            } else {
                Intent intent = new Intent(IntroActivity.this, AuthActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _activityIntroBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_intro
        );

        // Event handler
        setEventHandlers();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        _activityIntroBinding = null;
    }

    private void setEventHandlers() {
        _introEventHandler = new IntroEventHandler(this);

        _activityIntroBinding.setIntroEventHandler(_introEventHandler);
    }
}