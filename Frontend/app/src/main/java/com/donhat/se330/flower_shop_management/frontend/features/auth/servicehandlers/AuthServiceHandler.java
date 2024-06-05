package com.donhat.se330.flower_shop_management.frontend.features.auth.servicehandlers;

import static com.donhat.se330.flower_shop_management.frontend.constants.utils.Utils.displayErrorToast;
import static com.donhat.se330.flower_shop_management.frontend.constants.utils.Utils.displaySuccessToast;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.constants.utils.ErrorHandling;
import com.donhat.se330.flower_shop_management.frontend.constants.GlobalVariables;
import com.donhat.se330.flower_shop_management.frontend.constants.responses.MsgResponse;
import com.donhat.se330.flower_shop_management.frontend.constants.retrofit.RetrofitClient;
import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.ForgotPasswordFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.LoginFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.PinputFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.SignUpFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.services.AuthService;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.PinputViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.customer.navbar.activities.CustomerNavBarActivity;
import com.donhat.se330.flower_shop_management.frontend.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.android.gms.auth.api.identity.SignInCredential;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthServiceHandler {
    private final Context _context;
    private final AuthService _authService;
    private AuthViewModel _authViewModel;

    public AuthServiceHandler(Context context, AuthViewModel authViewModel) {
        _authService = RetrofitClient.getRetrofitInstance().create(AuthService.class);
        _context = context;
        _authViewModel = authViewModel;
    }

    public AuthServiceHandler(Context context) {
        _authService = RetrofitClient.getRetrofitInstance().create(AuthService.class);
        _context = context;
    }

    public void checkEmailExistsToChangePassword(String email) {
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);

        ObjectMapper objectMapper = new ObjectMapper();
        Object requestBody = objectMapper.convertValue(map, Object.class);

        Call<Boolean> call = _authService.checkEmailExists(requestBody);
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(@NonNull Call<Boolean> call, @NonNull Response<Boolean> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> {
                    boolean isEmailExist = Boolean.TRUE.equals(response.body());
                    if (isEmailExist) {
                        PinputViewModel.isNavigatingBack = false;
                        PinputViewModel.isSigningIn = false;

                        _authViewModel.getResentEmail().setValue(email);
                        _authViewModel.getAuthFragment().setValue(new PinputFragment());
                        _authViewModel.setPreviousFragment(new ForgotPasswordFragment());
                    } else {
                        displayErrorToast(_context, "Email not exist");
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<Boolean> call, @NonNull Throwable throwable) {
                displayErrorToast(_context, throwable.getMessage());
            }
        });
    }

    public void checkEmailExistsToSignUp(String email) {
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);

        ObjectMapper objectMapper = new ObjectMapper();
        Object requestBody = objectMapper.convertValue(map, Object.class);

        Call<Boolean> call = _authService.checkEmailExists(requestBody);
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(@NonNull Call<Boolean> call, @NonNull Response<Boolean> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> {
                    boolean isEmailExist = Boolean.TRUE.equals(response.body());
                    if (isEmailExist) {
                        displayErrorToast(_context, "User with this email already exist");
                    } else {
                        PinputViewModel.isNavigatingBack = false;
                        PinputViewModel.isSigningIn = true;

                        _authViewModel.getResentEmail().setValue(email);
                        _authViewModel.getAuthFragment().setValue(new PinputFragment());
                        _authViewModel.setPreviousFragment(new SignUpFragment());
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<Boolean> call, @NonNull Throwable throwable) {
                displayErrorToast(_context, throwable.getMessage());
            }
        });
    }

    public void sendVerifyEmail(String email, String pincode) {
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        map.put("pincode", pincode);

        ObjectMapper objectMapper = new ObjectMapper();
        Object requestBody = objectMapper.convertValue(map, Object.class);

        Call<MsgResponse> call = _authService.sendVerifyEmail(requestBody);
        call.enqueue(new Callback<MsgResponse>() {
            @Override
            public void onResponse(@NonNull Call<MsgResponse> call, @NonNull Response<MsgResponse> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> {
                });
            }

            @Override
            public void onFailure(@NonNull Call<MsgResponse> call, @NonNull Throwable throwable) {
                displayErrorToast(_context, throwable.getMessage());
            }
        });
    }

    public void changePassword(String email, String newPassword) {
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        map.put("newPassword", newPassword);

        ObjectMapper objectMapper = new ObjectMapper();
        Object requestBody = objectMapper.convertValue(map, Object.class);

        Call<User> call = _authService.changePassword(requestBody);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> {
                    GlobalVariables.getUser().setValue(response.body());

                    displaySuccessToast(_context, "Change password successfully");

                    _authViewModel.getAuthFragment().setValue(new LoginFragment());
                });
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable throwable) {
                displayErrorToast(_context, throwable.getMessage());
            }
        });
    }

    public void signUpUser(String username, String email, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("email", email);
        map.put("password", password);

        ObjectMapper objectMapper = new ObjectMapper();
        Object requestBody = objectMapper.convertValue(map, Object.class);

        Call<User> call = _authService.signUpUser(requestBody);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> {
                    GlobalVariables.getUser().setValue(response.body());

                    displaySuccessToast(_context, "Sign up successfully");

                    _authViewModel.getAuthFragment().setValue(new LoginFragment());
                });
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable throwable) {
                displayErrorToast(_context, throwable.getMessage());
            }
        });
    }

    public void loginUser(String email, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
        map.put("password", password);

        ObjectMapper objectMapper = new ObjectMapper();
        Object requestBody = objectMapper.convertValue(map, Object.class);

        Call<User> call = _authService.loginUser(requestBody);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> {
                    GlobalVariables.getUser().setValue(response.body());

                    SharedPreferences prefs = _context.getSharedPreferences(_context.getString(R.string.token_prefs_name), Context.MODE_PRIVATE);
                    prefs.edit()
                            .putString("x-auth-token", Objects.requireNonNull(GlobalVariables.getUser().getValue()).getToken())
                            .apply();

                    displaySuccessToast(_context, "Login successfully");

                    Intent intent = new Intent(_context, CustomerNavBarActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    _context.startActivity(intent);
                });
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable throwable) {
                displayErrorToast(_context, throwable.getMessage());
            }
        });
    }

    public void loginWithGoogle(SignInCredential credential) {
        Map<String, Object> map = new HashMap<>();
        map.put("email", credential.getId());
        map.put("password", credential.getGoogleIdToken());
        map.put("username", credential.getDisplayName());
        map.put("imageUrl", credential.getProfilePictureUri() != null ? credential.getProfilePictureUri().toString() : "");

        ObjectMapper objectMapper = new ObjectMapper();
        Object requestBody = objectMapper.convertValue(map, Object.class);

        Call<User> call = _authService.loginWithGoogle(requestBody);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> {
                    GlobalVariables.getUser().setValue(response.body());

                    SharedPreferences prefs = _context.getSharedPreferences(_context.getString(R.string.token_prefs_name), Context.MODE_PRIVATE);
                    prefs.edit()
                            .putString("x-auth-token", Objects.requireNonNull(GlobalVariables.getUser().getValue()).getToken())
                            .apply();

                    displaySuccessToast(_context, "Login successfully");

                    Intent intent = new Intent(_context, CustomerNavBarActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    _context.startActivity(intent);
                });
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable throwable) {
                displayErrorToast(_context, throwable.getMessage());
            }
        });
    }

    public CompletableFuture<Void> getUserData() {
        CompletableFuture<Void> future = new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {
            SharedPreferences prefs = _context.getSharedPreferences(
                    _context.getString(R.string.token_prefs_name),
                    Context.MODE_PRIVATE
            );
            String token = prefs.getString("x-auth-token", "");

            if (token.isEmpty()) {
                prefs.edit().putString("x-auth-token", "").apply();
                future.complete(null);
                return;
            }

            Call<Boolean> validateTokenCall = _authService.tokenIsValid(token);
            validateTokenCall.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(@NonNull Call<Boolean> call, @NonNull Response<Boolean> response) {
                    ErrorHandling.httpErrorHandler(response, _context, () -> {
                        boolean isValidToken = Boolean.TRUE.equals(response.body());
                        if (isValidToken) {
                            Call<User> getUserCall = _authService.getUserData(token);
                            getUserCall.enqueue(new Callback<User>() {
                                @Override
                                public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                                    User user = response.body();
                                    GlobalVariables.getUser().setValue(user);
                                    future.complete(null);
                                }

                                @Override
                                public void onFailure(@NonNull Call<User> call, @NonNull Throwable throwable) {
                                    displayErrorToast(_context, throwable.getMessage());
                                    future.completeExceptionally(throwable);
                                }
                            });
                        } else {
                            displayErrorToast(_context, "Invalid token.");
                            future.completeExceptionally(new Exception("Invalid token."));
                        }
                    });
                }

                @Override
                public void onFailure(@NonNull Call<Boolean> call, @NonNull Throwable throwable) {
                    displayErrorToast(_context, throwable.getMessage());
                    future.completeExceptionally(throwable);
                }
            });
        });

        return future;
    }
}
