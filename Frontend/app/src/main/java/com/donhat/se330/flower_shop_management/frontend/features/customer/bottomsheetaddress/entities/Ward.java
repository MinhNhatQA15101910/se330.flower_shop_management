package com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities;

public class Ward {
    public String ward_id;
    public String ward_name;

    public Ward(String ward_id, String ward_name) {
        this.ward_id = ward_id;
        this.ward_name = ward_name;
    }

    public String getWard_id() {
        return ward_id;
    }

    public void setWard_id(String ward_id) {
        this.ward_id = ward_id;
    }

    public String getWard_name() {
        return ward_name;
    }

    public void setWard_name(String ward_name) {
        this.ward_name = ward_name;
    }
}
