package com.donhat.se330.flower_shop_management.frontend.features.customer.checkout.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.donhat.se330.flower_shop_management.frontend.models.Voucher;

import java.util.List;

public class CheckoutViewModel extends ViewModel {
    private MutableLiveData<List<Voucher>> _voucherList = new MutableLiveData<>();
    private MutableLiveData<Voucher> _selectedVoucher = new MutableLiveData<>();

    public MutableLiveData<List<Voucher>> get_voucherList() {
        return _voucherList;
    }

    public void set_voucherList(MutableLiveData<List<Voucher>> _voucherList) {
        this._voucherList = _voucherList;
    }

    public MutableLiveData<Voucher> get_selectedVoucher() {
        return _selectedVoucher;
    }

    public void set_selectedVoucher(MutableLiveData<Voucher> _selectedVoucher) {
        this._selectedVoucher = _selectedVoucher;
    }
}
