package com.donhat.se330.flower_shop_management.frontend.features.auth.services;

import com.donhat.se330.flower_shop_management.frontend.features.auth.requests.EmailRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {
    @POST("email-exists")
    Call<Boolean> checkEmailExists(@Body EmailRequest emailRequest);
}
