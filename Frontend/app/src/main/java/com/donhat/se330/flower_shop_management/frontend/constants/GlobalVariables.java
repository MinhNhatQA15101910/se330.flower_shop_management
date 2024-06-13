package com.donhat.se330.flower_shop_management.frontend.constants;

import androidx.lifecycle.MutableLiveData;

import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities.ShippingInfo;
import com.donhat.se330.flower_shop_management.frontend.models.Order;
import com.donhat.se330.flower_shop_management.frontend.models.User;

public class GlobalVariables {
    public static final String BASE_URL = "http://10.45.23.59:3000/";
    private static final MutableLiveData<User> user = new MutableLiveData<>(new User());
    private static final MutableLiveData<ShippingInfo> shippingInfo = new MutableLiveData<>();
    private static final MutableLiveData<Order> order = new MutableLiveData<>();


    public static MutableLiveData<User> getUser() {
        return user;
    }

    public static MutableLiveData<ShippingInfo> getShippingInfo() {
        return shippingInfo;
    }

    public static MutableLiveData<Order> getOrder() {
        return order;
    }
}