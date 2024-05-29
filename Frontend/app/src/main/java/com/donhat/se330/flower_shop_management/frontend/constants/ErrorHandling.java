package com.donhat.se330.flower_shop_management.frontend.constants;

import android.content.Context;
import android.widget.Toast;

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
                Toast.makeText(context, msgResponse.getMsg(), Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else if (response.code() >= 500 && response.code() < 600) {
            try {
                ErrorResponse errorResponse = new Gson().fromJson(Objects.requireNonNull(response.errorBody()).string(), ErrorResponse.class);
                Toast.makeText(context, errorResponse.getError(), Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else {
            try {
                assert response.errorBody() != null;
                String responseObj = response.errorBody().toString();
                Toast.makeText(context, responseObj, Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
