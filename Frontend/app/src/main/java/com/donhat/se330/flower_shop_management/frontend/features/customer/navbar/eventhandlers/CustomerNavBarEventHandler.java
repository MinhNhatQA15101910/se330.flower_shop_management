package com.donhat.se330.flower_shop_management.frontend.features.customer.navbar.eventhandlers;

import android.content.Context;
import android.view.View;

import com.donhat.se330.flower_shop_management.frontend.features.customer.bottomsheetaddress.fragments.BottomSheetAddressFragment;
import com.donhat.se330.flower_shop_management.frontend.features.customer.home.fragments.HomeFragment;
import com.donhat.se330.flower_shop_management.frontend.features.customer.navbar.viewmodels.CustomerNavBarViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.customer.category.fragments.CategoryFragment;
import com.donhat.se330.flower_shop_management.frontend.features.customer.search.fragments.SearchFragment;
import com.donhat.se330.flower_shop_management.frontend.features.customer.profile.fragments.ProfileFragment;



public class CustomerNavBarEventHandler {
    private final CustomerNavBarViewModel _customerNavBarViewModel;
    private final Context _context;

    public CustomerNavBarEventHandler(CustomerNavBarViewModel customerNavBarViewModel, Context context) {
        _customerNavBarViewModel = customerNavBarViewModel;
        _context = context;
    }
    public void navigateToHomeFragment(View view) {
        _customerNavBarViewModel.getCustomerFragment().setValue(new HomeFragment());
        _customerNavBarViewModel.getIsHomeClicked().setValue(true);
        _customerNavBarViewModel.getIsCategoryClicked().setValue(false);
        _customerNavBarViewModel.getIsSearchClicked().setValue(false);
        _customerNavBarViewModel.getIsProfileClicked().setValue(false);
    }
    public void navigateToCategoryFragment(View view) {
        _customerNavBarViewModel.getCustomerFragment().setValue(new CategoryFragment());
        _customerNavBarViewModel.getIsHomeClicked().setValue(false);
        _customerNavBarViewModel.getIsCategoryClicked().setValue(true);
        _customerNavBarViewModel.getIsSearchClicked().setValue(false);
        _customerNavBarViewModel.getIsProfileClicked().setValue(false);
    }
    public void navigateToSearchFragment(View view) {
        _customerNavBarViewModel.getCustomerFragment().setValue(new SearchFragment());
        _customerNavBarViewModel.getIsHomeClicked().setValue(false);
        _customerNavBarViewModel.getIsCategoryClicked().setValue(false);
        _customerNavBarViewModel.getIsSearchClicked().setValue(true);
        _customerNavBarViewModel.getIsProfileClicked().setValue(false);
    }
    public void navigateToProfileFragment(View view) {
        _customerNavBarViewModel.getCustomerFragment().setValue(new ProfileFragment());
        _customerNavBarViewModel.getIsHomeClicked().setValue(false);
        _customerNavBarViewModel.getIsCategoryClicked().setValue(false);
        _customerNavBarViewModel.getIsSearchClicked().setValue(false);
        _customerNavBarViewModel.getIsProfileClicked().setValue(true);
    }

}
