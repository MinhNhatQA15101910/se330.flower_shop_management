package com.donhat.se330.flower_shop_management.frontend.features.auth.servicehandlers;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.donhat.se330.flower_shop_management.frontend.constants.retrofit.RetrofitClient;
import com.donhat.se330.flower_shop_management.frontend.features.auth.fragments.PinputFragment;
import com.donhat.se330.flower_shop_management.frontend.features.auth.requests.EmailRequest;
import com.donhat.se330.flower_shop_management.frontend.features.auth.services.AuthService;
import com.donhat.se330.flower_shop_management.frontend.features.auth.viewmodels.AuthViewModel;

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

    public void checkEmailExists(String email) {
        EmailRequest emailRequest = new EmailRequest(email);
        Call<Boolean> call = _authService.checkEmailExists(emailRequest);
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(@NonNull Call<Boolean> call, @NonNull Response<Boolean> response) {
                if (response.body() != null) {
                    boolean isEmailExist = response.body();
                    if (isEmailExist) {
                        _authViewModel.getResentEmail().setValue(email);
                        _authViewModel.getAuthFragment().setValue(new PinputFragment());
                    } else {
                        Toast.makeText(_context, "Email not exist.", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Boolean> call, @NonNull Throwable throwable) {
                Toast.makeText(_context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
