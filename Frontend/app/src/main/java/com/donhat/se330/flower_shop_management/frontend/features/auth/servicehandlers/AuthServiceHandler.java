package com.donhat.se330.flower_shop_management.frontend.features.auth.servicehandlers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.donhat.se330.flower_shop_management.frontend.constants.ErrorHandling;
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

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthServiceHandler {
    private final Context _context;
    private final AuthService _authService;
    private final AuthViewModel _authViewModel;

    public AuthServiceHandler(Context context, AuthViewModel authViewModel) {
        _authService = RetrofitClient.getRetrofitInstance().create(AuthService.class);
        _context = context;
        _authViewModel = authViewModel;
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

                        _authViewModel.setPreviousFragment(new ForgotPasswordFragment());
                        _authViewModel.getResentEmail().setValue(email);
                        _authViewModel.getAuthFragment().setValue(new PinputFragment());
                    } else {
                        Toast.makeText(_context, "Email not exist.", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<Boolean> call, @NonNull Throwable throwable) {
                Toast.makeText(_context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(_context, "User with this email already exist.", Toast.LENGTH_SHORT).show();
                    } else {
                        PinputViewModel.isNavigatingBack = false;
                        PinputViewModel.isSigningIn = true;

                        _authViewModel.setPreviousFragment(new SignUpFragment());
                        _authViewModel.getResentEmail().setValue(email);
                        _authViewModel.getAuthFragment().setValue(new PinputFragment());
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<Boolean> call, @NonNull Throwable throwable) {
                Toast.makeText(_context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
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
                Toast.makeText(_context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
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
                    GlobalVariables.setUser(response.body());

                    Toast.makeText(_context, "Change password successfully.", Toast.LENGTH_SHORT).show();

                    _authViewModel.getAuthFragment().setValue(new LoginFragment());
                });
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable throwable) {
                Toast.makeText(_context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
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
                    GlobalVariables.setUser(response.body());

                    Toast.makeText(_context, "Sign up successfully.", Toast.LENGTH_SHORT).show();

                    _authViewModel.getAuthFragment().setValue(new LoginFragment());
                });
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable throwable) {
                Toast.makeText(_context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
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
                    GlobalVariables.setUser(response.body());

                    SharedPreferences prefs = _context.getSharedPreferences("TOKEN", Context.MODE_PRIVATE);
                    prefs.edit()
                            .putString("x-auth-token", GlobalVariables.getUser().getToken())
                            .apply();

                    Toast.makeText(_context, "Login successfully.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(_context, CustomerNavBarActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    _context.startActivity(intent);
                });
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable throwable) {
                Toast.makeText(_context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
