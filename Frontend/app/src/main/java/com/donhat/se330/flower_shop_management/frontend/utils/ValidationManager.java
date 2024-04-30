package com.donhat.se330.flower_shop_management.frontend.utils;

import android.content.Context;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class ValidationManager {
    private static ValidationManager instance = null;
    private TextInputLayout textInputLayout;
    private EditText editText;
    private ErrorSetter errorSetter;
    private String emailPattern = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

    private final String ERR_MSG_CHECK_EMPTY = "Field cannot be empty.";
    private final String ERR_MSG_CHECK_EMAIL = "Invalid email.";
    private final String ERR_MSG_MATCH_PASSWORD = "Password does not match.";
    private final String ERR_MSG_CHECK_PASSWORD_LENGTH = "Password must be at least 8 characters long.";
    private final String ERR_MSG_CHECK_USERNAME_LENGTH = "Username must be at least 6 characters long.";

    private boolean isAllValid = false;
    private boolean isEmpty = true;
    private boolean isEmptyValid = false;
    private boolean isEmailValid = false;
    private boolean isPasswordValid = false;
    private boolean isUsernameValid = false;
    private boolean isPasswordMatch = false;

    private ValidationManager() {
    }

    public static ValidationManager getInstance() {
        if (instance == null) {
            instance = new ValidationManager();
        }

        return instance;
    }

    public interface ErrorSetter {
        void setError(TextInputLayout textInputLayout, String errorMsg);
    }

    ValidationManager doValidation(Context context, TextInputLayout textInputLayout) {
        errorSetter = (ErrorSetter) context;
        this.textInputLayout = textInputLayout;
        this.editText = textInputLayout.getEditText();
        return instance;
    }

    ValidationManager checkEmpty() {
        if (editText.getText().toString().isEmpty()) {
            errorSetter.setError(textInputLayout, ERR_MSG_CHECK_EMPTY);
            isEmpty = true;
            isEmptyValid = false;
        } else {
            isEmpty = false;
            isEmptyValid = true;
        }
        return instance;
    }

    ValidationManager checkEmail() {
        if (!isEmpty && !editText.getText().toString().matches(emailPattern)) {
            errorSetter.setError(textInputLayout, ERR_MSG_CHECK_EMAIL);
            isEmailValid = false;
        } else {
            isEmailValid = true;
        }
        return instance;
    }

    ValidationManager matchPassword(TextInputLayout firstPasswordLayout, TextInputLayout secondPasswordLayout) {
        if (!isEmpty &&
                !firstPasswordLayout
                        .getEditText()
                        .getText()
                        .toString()
                        .trim()
                        .equals(
                                secondPasswordLayout
                                        .getEditText()
                                        .getText()
                                        .toString()
                                        .trim()
                        )
        ) {
            errorSetter.setError(textInputLayout, ERR_MSG_MATCH_PASSWORD);
            isPasswordMatch = false;
        } else {
            isPasswordMatch = true;
        }
        return instance;
    }

    boolean isAllValid() {
        isAllValid = isEmptyValid && isEmailValid && isPasswordValid && isUsernameValid && isPasswordMatch;

        return isAllValid;
    }
}
