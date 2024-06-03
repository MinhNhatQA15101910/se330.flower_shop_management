package com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.ForgotPasswordFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.LoginFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.SignUpFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.servicehandlers.AuthServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.LoginViewModel;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.common.api.ApiException;

import java.util.Objects;

public class LoginEventHandler {
    private final Context _context;
    private final AuthViewModel _authViewModel;
    private static LoginViewModel _loginViewModel;
    private static AuthServiceHandler _authServiceHandler;

    private static SignInClient _oneTapClient;
    private static BeginSignInRequest _signInRequest;
    private static ActivityResultLauncher<IntentSenderRequest> _intentSenderLauncher;

    public LoginEventHandler(Context context, AuthViewModel authViewModel, LoginViewModel loginViewModel) {
        _context = context;
        _authViewModel = authViewModel;
        _loginViewModel = loginViewModel;
        _authServiceHandler = new AuthServiceHandler(context, authViewModel);

        initialGoogleSignIn();
    }

    public static void initialIntentSenderLauncher(Context context) {
        _intentSenderLauncher = ((AppCompatActivity) context).registerForActivityResult(
                new ActivityResultContracts.StartIntentSenderForResult(),
                activityResult -> {
                    if (activityResult.getResultCode() == Activity.RESULT_OK) {
                        try {
                            SignInCredential credential = _oneTapClient.getSignInCredentialFromIntent(activityResult.getData());
                            _authServiceHandler.loginWithGoogle(credential);

                            _loginViewModel.getIsLoginWithGoogleLoading().setValue(false);
                        } catch (ApiException e) {
                            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void initialGoogleSignIn() {
        _oneTapClient = Identity.getSignInClient(_context.getApplicationContext());
        _signInRequest = BeginSignInRequest.builder()
                .setPasswordRequestOptions(
                        BeginSignInRequest.PasswordRequestOptions.builder()
                                .setSupported(true)
                                .build()
                )
                .setGoogleIdTokenRequestOptions(
                        BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                                .setSupported(true)
                                .setServerClientId(_context.getString(R.string.default_web_client_id))
                                .setFilterByAuthorizedAccounts(false)
                                .build()
                )
                .setAutoSelectEnabled(true)
                .build();
    }

    public void navigateToSignUpFragment(View view) {
        _authViewModel.getAuthFragment().setValue(new SignUpFragment());
    }

    public void navigateToForgotPasswordFragment(View view) {
        _authViewModel.setPreviousFragment(new LoginFragment());
        _authViewModel.getAuthFragment().setValue(new ForgotPasswordFragment());
    }

    public void login(View view) {
        if (isValidAll()) {
            _loginViewModel.getIsLoginLoading().setValue(true);

            Handler handler = new Handler();
            handler.postDelayed(
                    () -> {
                        _authServiceHandler.loginUser(
                                Objects.requireNonNull(_loginViewModel.getEmail().getValue()).trim(),
                                Objects.requireNonNull(_loginViewModel.getPassword().getValue()).trim()
                        );

                        _loginViewModel.getIsLoginLoading().setValue(false);
                    },
                    2000
            );
        }
    }

    public void loginWithGoogle(View view) {
        _loginViewModel.getIsLoginWithGoogleLoading().setValue(true);

        _oneTapClient.beginSignIn(_signInRequest)
                .addOnSuccessListener(beginSignInResult -> {
                    try {
                        _intentSenderLauncher
                                .launch(
                                        new IntentSenderRequest.Builder(
                                                beginSignInResult.getPendingIntent().getIntentSender()
                                        )
                                                .setFillInIntent(null)
                                                .setFlags(0, 0)
                                                .build()
                                );
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(_context, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(e -> Toast.makeText(_context, e.getMessage(), Toast.LENGTH_SHORT).show());
    }

    private boolean isValidAll() {
        String email = Objects.requireNonNull(_loginViewModel.getEmail().getValue()).trim();
        String password = Objects.requireNonNull(_loginViewModel.getPassword().getValue()).trim();
        boolean isValidAll = true;

        // Validate email is not empty
        if (Objects.requireNonNull(email).trim().isEmpty()) {
            _loginViewModel.getIsPasswordEmpty().setValue(true);
            isValidAll = false;
        } else {
            _loginViewModel.getIsPasswordEmpty().setValue(false);
        }

        // Validate email is valid
        String emailPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if (!email.matches(emailPattern)) {
            _loginViewModel.getIsEmailValid().setValue(false);
            isValidAll = false;
        } else {
            _loginViewModel.getIsEmailValid().setValue(true);
        }

        // Validate password is not empty
        if (Objects.requireNonNull(password).trim().isEmpty()) {
            _loginViewModel.getIsPasswordEmpty().setValue(true);
            isValidAll = false;
        } else {
            _loginViewModel.getIsPasswordEmpty().setValue(false);
        }

        // Validate password length is valid
        if (password.trim().length() < 8) {
            _loginViewModel.getIsPasswordLengthValid().setValue(false);
            isValidAll = false;
        } else {
            _loginViewModel.getIsPasswordLengthValid().setValue(true);
        }

        return isValidAll;
    }
}
