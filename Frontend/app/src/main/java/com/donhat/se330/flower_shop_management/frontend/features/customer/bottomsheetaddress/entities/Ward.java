package com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities;

import com.google.gson.annotations.SerializedName;

public class Ward {
    @SerializedName("ward_id")
    public String wardId;
    @SerializedName("ward_name")
    public String wardName;

    public Ward(String wardId, String wardName) {
        this.wardId = wardId;
        this.wardName = wardName;
    }

    public String getWardId() {
        return wardId;
    }

    public void setWardId(String wardId) {
        this.wardId = wardId;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }
}
