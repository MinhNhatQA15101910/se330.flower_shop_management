package com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.servicehandlers;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.donhat.se330.flower_shop_management.frontend.constants.retrofit.RetrofitAddressAPI;
import com.donhat.se330.flower_shop_management.frontend.constants.utils.ErrorHandling;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities.District;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities.DistrictListResponse;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities.Province;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities.ProvinceListResponse;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities.Ward;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.entities.WardListResponse;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.services.BottomSheetAddressService;
import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.viewmodels.BottomSheetAddressViewModel;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BottomSheetAddressServiceHandler {
    private final Context _context;
    private final BottomSheetAddressService _bottomSheetAddressService;
    private final BottomSheetAddressViewModel _bottomSheetAddressViewModel;

    public BottomSheetAddressServiceHandler(Context _context, BottomSheetAddressViewModel bottomSheetAddressViewModel) {
        this._context = _context;
        _bottomSheetAddressViewModel=bottomSheetAddressViewModel;
        _bottomSheetAddressService = RetrofitAddressAPI.getRetrofitAddressAPI().create(BottomSheetAddressService.class);
    }

    public void getProvinces() {
        _bottomSheetAddressService.getProvinces().enqueue(new Callback<ProvinceListResponse>() {
            @Override
            public void onResponse(@NonNull Call<ProvinceListResponse> call, @NonNull Response<ProvinceListResponse> response) {
                ErrorHandling.httpErrorHandler(response, _context, () -> {
                    ProvinceListResponse provinceListResponse = response.body();
                    if (provinceListResponse != null) {
                        List<Province> provinceList = provinceListResponse.getResults();
                        _bottomSheetAddressViewModel.getProvinceList().setValue(provinceList);
                    }
                });
            }

            @Override
            public void onFailure(@NonNull Call<ProvinceListResponse> call, @NonNull Throwable throwable) {
                Toast.makeText(_context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void getDistricts(String provinceName) {
        List<Province> provinceList=_bottomSheetAddressViewModel.getProvinceList().getValue();
        if(provinceList != null){
            for (Province province : provinceList) {
                if(Objects.equals(province.provinceName, provinceName)){
                    _bottomSheetAddressService.getDistricts(province.provinceId).enqueue(new Callback<DistrictListResponse>() {
                        @Override
                        public void onResponse(@NonNull Call<DistrictListResponse> call, @NonNull Response<DistrictListResponse> response) {
                            ErrorHandling.httpErrorHandler(response, _context, () -> {
                                DistrictListResponse districtListResponse = response.body();
                                if (districtListResponse != null) {
                                    List<District> districtList = districtListResponse.getResults();
                                    _bottomSheetAddressViewModel.getDistrictList().setValue(districtList);
                                }
                            });
                        }

                        @Override
                        public void onFailure(@NonNull Call<DistrictListResponse> call, @NonNull Throwable throwable) {
                            Toast.makeText(_context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }

    }
    public void getWards(String districtName) {
        List<District> districtList=_bottomSheetAddressViewModel.getDistrictList().getValue();
        if(districtList != null){
            for (District district : districtList) {
                if(Objects.equals(district.districtName, districtName)){
                    _bottomSheetAddressService.getWards(district.districtId).enqueue(new Callback<WardListResponse>() {
                        @Override
                        public void onResponse(@NonNull Call<WardListResponse> call, @NonNull Response<WardListResponse> response) {
                            ErrorHandling.httpErrorHandler(response, _context, () -> {
                                WardListResponse wardListResponse = response.body();
                                if (wardListResponse != null) {
                                    List<Ward> wardList = wardListResponse.getResults();
                                    _bottomSheetAddressViewModel.getWardList().setValue(wardList);
                                }
                            });
                        }
                        @Override
                        public void onFailure(@NonNull Call<WardListResponse> call, @NonNull Throwable throwable) {
                            Toast.makeText(_context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }


    }
}
