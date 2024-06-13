package com.donhat.se330.flower_shop_management.frontend.constants.utils;

import android.app.Activity;
import android.content.Context;

import androidx.core.content.res.ResourcesCompat;

import com.donhat.se330.flower_shop_management.frontend.R;

import java.util.Objects;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class Utils {
    public static void displayErrorToast(Context context, String content) {
        MotionToast.Companion.createColorToast(
                (Activity) context,
                "Error",
                Objects.requireNonNull(content),
                MotionToastStyle.ERROR,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.SHORT_DURATION,
                ResourcesCompat.getFont(context, R.font.helvetica)
        );
    }

    public static void displaySuccessToast(Context context, String content) {
        MotionToast.Companion.createColorToast(
                (Activity) context,
                "Success",
                Objects.requireNonNull(content),
                MotionToastStyle.SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.SHORT_DURATION,
                ResourcesCompat.getFont(context, R.font.helvetica)
        );
    }

    public static void displayInfoToast(Context context, String content) {
        MotionToast.Companion.createColorToast(
                (Activity) context,
                "Info",
                Objects.requireNonNull(content),
                MotionToastStyle.INFO,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.SHORT_DURATION,
                ResourcesCompat.getFont(context, R.font.helvetica)
        );
    }

    public static void displayWarningToast(Context context, String content) {
        MotionToast.Companion.createColorToast(
                (Activity) context,
                "Warning",
                Objects.requireNonNull(content),
                MotionToastStyle.WARNING,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.SHORT_DURATION,
                ResourcesCompat.getFont(context, R.font.helvetica)
        );
    }
}
