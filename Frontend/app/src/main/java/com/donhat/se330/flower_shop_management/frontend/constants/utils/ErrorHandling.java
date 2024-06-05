package com.donhat.se330.flower_shop_management.frontend.constants.utils;

import static com.donhat.se330.flower_shop_management.frontend.constants.utils.Utils.displayErrorToast;
import static com.donhat.se330.flower_shop_management.frontend.constants.utils.Utils.displayInfoToast;
import static com.donhat.se330.flower_shop_management.frontend.constants.utils.Utils.displayWarningToast;

import android.content.Context;

import com.donhat.se330.flower_shop_management.frontend.constants.responses.ErrorResponse;
import com.donhat.se330.flower_shop_management.frontend.constants.responses.MsgResponse;
import com.google.gson.Gson;

import java.util.Objects;

import retrofit2.Response;

public class ErrorHandling {
    public static <T> void httpErrorHandler(Response<T> response, Context context, Runnable onSuccess) {
        if (response.code() == 200) {
            onSuccess.run();
        } else if (response.code() >= 400 && response.code() < 500) {
            try {
                MsgResponse msgResponse = new Gson().fromJson(Objects.requireNonNull(response.errorBody()).string(), MsgResponse.class);
                displayWarningToast(context, msgResponse.getMsg());
            } catch (Exception e) {
                displayErrorToast(context, e.getMessage());
            }
        } else if (response.code() >= 500 && response.code() < 600) {
            try {
                ErrorResponse errorResponse = new Gson().fromJson(Objects.requireNonNull(response.errorBody()).string(), ErrorResponse.class);
                displayErrorToast(context, errorResponse.getError());
            } catch (Exception e) {
                displayErrorToast(context, e.getMessage());
            }
        } else {
            try {
                String responseObj = Objects.requireNonNull(response.errorBody()).toString();
                displayInfoToast(context, responseObj);
            } catch (Exception e) {
                displayErrorToast(context, e.getMessage());
            }
        }
    }
}
