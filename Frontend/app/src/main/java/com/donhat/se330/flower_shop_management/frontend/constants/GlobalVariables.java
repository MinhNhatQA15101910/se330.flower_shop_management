package com.donhat.se330.flower_shop_management.frontend.constants;

import androidx.lifecycle.MutableLiveData;

import com.donhat.se330.flower_shop_management.frontend.models.User;

public class GlobalVariables {
    public static final String BASE_URL = "http://192.168.2.237:3000/";
    private static final MutableLiveData<User> user = new MutableLiveData<>(new User());

    public static MutableLiveData<User> getUser() {
        return user;
    }
}
