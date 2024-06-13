package com.donhat.se330.flower_shop_management.frontend.features.auth.eventhandlers;

import static com.donhat.se330.flower_shop_management.frontend.constants.utils.Utils.displayErrorToast;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.LoginFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.servicehandlers.AuthServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.SignUpViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.customer.navbar.activities.CustomerNavBarActivity;
import com.donhat.se330.flower_shop_management.frontend.models.User;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.common.api.ApiException;

import java.util.ArrayList;
import java.util.Objects;

public class SignUpEventHandler {
    private final Context _context;
    private final AuthViewModel _authViewModel;
    private static SignUpViewModel _signUpViewModel;
    private static AuthServiceHandler _authServiceHandler;

    private static SignInClient _oneTapClient;
    private static BeginSignInRequest _signInRequest;
    private static ActivityResultLauncher<IntentSenderRequest> _intentSenderLauncher;

    public SignUpEventHandler(Context context, AuthViewModel authViewModel, SignUpViewModel signUpViewModel) {
        _context = context;
        _authViewModel = authViewModel;
        _signUpViewModel = signUpViewModel;
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
                        } catch (ApiException e) {
                            displayErrorToast(context, e.getMessage());
                        }
                    }

                    _signUpViewModel.getIsSignUpWithGoogleLoading().setValue(false);
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

    public void navigateToLoginFragment(View view) {
        _authViewModel.getAuthFragment().setValue(new LoginFragment());
    }

    public void navigateToPinputFragment(View view) {
        if (isValidAll()) {
            _signUpViewModel.getIsSignUpLoading().setValue(true);

            Handler handler = new Handler();
            handler.postDelayed(
                    () -> {
                        SignUpViewModel.signUpUser = new User(
                                0,
                                _signUpViewModel.getUsername().getValue(),
                                _signUpViewModel.getEmail().getValue(),
                                _signUpViewModel.getPassword().getValue(),
                                "",
                                "",
                                "",
                                new ArrayList<>(),
                                new ArrayList<>()
                        );

                        _authServiceHandler.checkEmailExistsToSignUp(
                                _signUpViewModel.getEmail().getValue()
                        );

                        _signUpViewModel.getIsSignUpLoading().setValue(false);
                    },
                    2000
            );
        }
    }

    public void signUpWithGoogle(View view) {
        _signUpViewModel.getIsSignUpWithGoogleLoading().setValue(true);

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
                        displayErrorToast(_context, e.getMessage());
                    }
                }).addOnFailureListener(e -> displayErrorToast(_context, e.getMessage()));
    }

    public void continueAsAGuess(View view) {
        _signUpViewModel.getIsContinueAsAGuessLoading().setValue(true);

        Handler handler = new Handler();
        handler.postDelayed(
                () -> {
                    Intent intent = new Intent(_context, CustomerNavBarActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    _context.startActivity(intent);

                    _signUpViewModel.getIsContinueAsAGuessLoading().setValue(false);
                },
                2000
        );
    }

    private boolean isValidAll() {
        String email = _signUpViewModel.getEmail().getValue();
        String username = _signUpViewModel.getUsername().getValue();
        String password = _signUpViewModel.getPassword().getValue();
        String passwordConfirmed = _signUpViewModel.getPasswordConfirmed().getValue();
        boolean isValidAll = true;

        // Validate email is not empty
        if (Objects.requireNonNull(email).trim().isEmpty()) {
            _signUpViewModel.getIsPasswordEmpty().setValue(true);
            isValidAll = false;
        } else {
            _signUpViewModel.getIsPasswordEmpty().setValue(false);
        }

        // Validate email is valid
        String emailPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if (!email.matches(emailPattern)) {
            _signUpViewModel.getIsEmailValid().setValue(false);
            isValidAll = false;
        } else {
            _signUpViewModel.getIsEmailValid().setValue(true);
        }

        // Validate username is not empty
        if (Objects.requireNonNull(username).trim().isEmpty()) {
            _signUpViewModel.getIsUsernameEmpty().setValue(true);
            isValidAll = false;
        } else {
            _signUpViewModel.getIsUsernameEmpty().setValue(false);
        }

        // Validate username length is valid
        if (username.trim().length() < 6) {
            _signUpViewModel.getIsUsernameLengthValid().setValue(false);
            isValidAll = false;
        } else {
            _signUpViewModel.getIsUsernameLengthValid().setValue(true);
        }

        // Validate password is not empty
        if (Objects.requireNonNull(password).trim().isEmpty()) {
            _signUpViewModel.getIsPasswordEmpty().setValue(true);
            isValidAll = false;
        } else {
            _signUpViewModel.getIsPasswordEmpty().setValue(false);
        }

        // Validate password length is valid
        if (password.trim().length() < 8) {
            _signUpViewModel.getIsPasswordLengthValid().setValue(false);
            isValidAll = false;
        } else {
            _signUpViewModel.getIsPasswordLengthValid().setValue(true);
        }

        // Validate password confirmed is not empty
        if (Objects.requireNonNull(passwordConfirmed).trim().isEmpty()) {
            _signUpViewModel.getIsPasswordConfirmedEmpty().setValue(true);
            isValidAll = false;
        } else {
            _signUpViewModel.getIsPasswordConfirmedEmpty().setValue(false);
        }

        // Validate password is match
        if (!passwordConfirmed.equals(password)) {
            _signUpViewModel.getIsPasswordMatch().setValue(false);
            isValidAll = false;
        } else {
            _signUpViewModel.getIsPasswordMatch().setValue(true);
        }

        return isValidAll;
    }
}
