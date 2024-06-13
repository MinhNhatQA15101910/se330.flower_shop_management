package com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities;

public class ShippingInfo {
    public String provinceName;
    public String districtName;
    public String wardName;
    public String street;
    public String fullName;
    public String PhoneNumber;

    public ShippingInfo(String provinceName, String districtName, String wardName, String street, String fullName, String phoneNumber) {
        this.provinceName = provinceName;
        this.districtName = districtName;
        this.wardName = wardName;
        this.street = street;
        this.fullName = fullName;
        PhoneNumber = phoneNumber;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
