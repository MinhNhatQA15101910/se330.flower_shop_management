package com.donhat.se330.flower_shop_management.frontend.constants;

import com.donhat.se330.flower_shop_management.frontend.models.User;

public class GlobalVariables {
    public static final String BASE_URL = "http://192.168.1.8:3000/";
    private static User _user = new User();

    public static void setUser(User user) {
        _user = user;
    }

    public static User getUser() {
        return _user;
    }
}
