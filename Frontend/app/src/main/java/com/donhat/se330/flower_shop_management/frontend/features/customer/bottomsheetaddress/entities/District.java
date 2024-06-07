package com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities;

import com.google.gson.annotations.SerializedName;

public class District {
    @SerializedName("district_id")
    public String districtId;
    @SerializedName("district_name")
    public String districtName;

    public District(String districtId, String districtName) {
        this.districtId = districtId;
        this.districtName = districtName;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
}
