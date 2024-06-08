package com.donhat.se330.flower_shop_management.frontend.features.customer.home.eventhandlers;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.donhat.se330.flower_shop_management.frontend.features.customer.home.servicehandlers.HomeServiceHandler;
import com.donhat.se330.flower_shop_management.frontend.features.customer.home.viewmodels.HomeFragmentViewModel;
import com.donhat.se330.flower_shop_management.frontend.features.customer.productlist.activities.ProductListActivity;

public class HomeFragmentEventHandlers {
    private final HomeFragmentViewModel _homeFragmentViewModel;
    private final HomeServiceHandler _homeFragmentServiceHandler;
    Context context;

    public HomeFragmentEventHandlers(Context context, HomeFragmentViewModel homeFragmentViewModel) {
        this.context = context;
        _homeFragmentViewModel = homeFragmentViewModel;
        _homeFragmentServiceHandler = new HomeServiceHandler(context, _homeFragmentViewModel);
    }

    public void onInitial() {
        _homeFragmentViewModel.setListDoDProducts(_homeFragmentServiceHandler.getDoDProducts());
        _homeFragmentViewModel.setListRecommendProducts(_homeFragmentServiceHandler.getRecommendProducts());
        _homeFragmentViewModel.setListBanners();
    }

    public void onClickViewMore(View view) {
        Intent intent = new Intent(context, ProductListActivity.class);
        context.startActivity(intent);
    }

}
