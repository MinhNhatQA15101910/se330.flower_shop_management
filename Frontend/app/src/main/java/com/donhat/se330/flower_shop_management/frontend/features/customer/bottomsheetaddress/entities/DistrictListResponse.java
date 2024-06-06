package com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities;

import java.util.List;

public class DistrictListResponse {
    private final List<District> results;

    public DistrictListResponse(List<District> results) {
        this.results = results;
    }

    public List<District> getResults() {
        return results;
    }
}
