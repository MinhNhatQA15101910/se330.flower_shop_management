package com.donhat.se330.flower_shop_management.frontend.features.auth.services;

import com.donhat.se330.flower_shop_management.frontend.constants.responses.MsgResponse;
import com.donhat.se330.flower_shop_management.frontend.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {
    @POST("email-exists")
    Call<Boolean> checkEmailExists(@Body Object emailExistsRequestBody);

    @POST("send-email")
    Call<MsgResponse> sendVerifyEmail(@Body Object sendEmailRequestBody);

    @POST("change-password")
    Call<User> changePassword(@Body Object changePasswordRequestBody);
}
