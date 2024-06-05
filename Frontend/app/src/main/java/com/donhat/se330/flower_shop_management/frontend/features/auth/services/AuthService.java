package com.donhat.se330.flower_shop_management.frontend.features.auth.services;

import com.donhat.se330.flower_shop_management.frontend.constants.responses.MsgResponse;
import com.donhat.se330.flower_shop_management.frontend.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface AuthService {
    @POST("email-exists")
    Call<Boolean> checkEmailExists(@Body Object emailExistsRequestBody);

    @POST("send-email")
    Call<MsgResponse> sendVerifyEmail(@Body Object sendEmailRequestBody);

    @PATCH("change-password")
    Call<User> changePassword(@Body Object changePasswordRequestBody);

    @POST("signup")
    Call<User> signUpUser(@Body Object signUpRequestBody);

    @POST("login")
    Call<User> loginUser(@Body Object loginRequestBody);

    @POST("login/google")
    Call<User> loginWithGoogle(@Body Object loginWithGoogleRequestBody);

    @POST("tokenIsValid")
    Call<Boolean> tokenIsValid(@Header("x-auth-token") String token);

    @GET("user")
    Call<User> getUserData(@Header("x-auth-token") String token);
}
