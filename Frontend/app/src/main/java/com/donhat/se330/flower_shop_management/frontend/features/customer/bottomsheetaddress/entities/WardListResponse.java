package com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities;

import java.util.List;

public class WardListResponse {
    private final List<Ward> results;

    public WardListResponse(List<Ward> results) {
        this.results = results;
    }

    public List<Ward> getResults() {
        return results;
    }
}
