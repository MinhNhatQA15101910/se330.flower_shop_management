package com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities;

import com.google.gson.annotations.SerializedName;

public class Province {
    @SerializedName("province_id")
    public String provinceId;
    @SerializedName("province_name")
    public String provinceName;
    @SerializedName("province_type")
    public String provinceType;

    public Province(String provinceId, String provinceName, String provinceType) {
        this.provinceId = provinceId;
        this.provinceName = provinceName;
        this.provinceType = provinceType;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceType() {
        return provinceType;
    }

    public void setProvinceType(String provinceType) {
        this.provinceType = provinceType;
    }
}
