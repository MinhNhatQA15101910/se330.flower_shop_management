package com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities;

import java.util.List;

public class ProvinceListResponse {
    private final List<Province> results;

    public ProvinceListResponse(List<Province> results) {
        this.results = results;
    }

    public List<Province> getResults() {
        return results;
    }
}
