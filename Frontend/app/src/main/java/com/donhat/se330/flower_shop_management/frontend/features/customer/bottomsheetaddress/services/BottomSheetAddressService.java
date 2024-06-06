package com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.services;

import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities.DistrictListResponse;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities.ProvinceListResponse;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities.Ward;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BottomSheetAddressService {
    @GET("/api/province")
    Call<ProvinceListResponse> getProvinces();
    @GET("/api/district/{province_id}")
    Call<DistrictListResponse> getDistricts(@Path("province_id") String province_id);
    @GET("/api/province/ward/{district_id}")
    Call<List<Ward>> getWards(@Path("district_id") String district_id);
}
