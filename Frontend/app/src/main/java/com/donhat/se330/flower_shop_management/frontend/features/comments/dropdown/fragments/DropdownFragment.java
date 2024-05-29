package com.donhat.se330.flower_shop_management.frontend.features.comments.dropdown.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donhat.se330.flower_shop_management.frontend.R;
import com.donhat.se330.flower_shop_management.frontend.features.comments.dropdown.adapters.DropdownAdapter;
import com.donhat.se330.flower_shop_management.frontend.features.comments.dropdown.callbacks.SelectionCallback;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class DropdownFragment extends BottomSheetDialogFragment {

    private static final String ARG_PROVINCE_LIST = "province_list";
    private SelectionCallback selectionCallback;

    // Modify newInstance to accept the list of provinces and the callback as arguments
    public static DropdownFragment newInstance(ArrayList<String> provinceList, SelectionCallback callback) {
        DropdownFragment fragment = new DropdownFragment();
        Bundle args = new Bundle();
        args.putStringArrayList(ARG_PROVINCE_LIST, provinceList);
        fragment.setArguments(args);
        fragment.setProvinceSelectionCallback(callback);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        com.donhat.se330.flower_shop_management.frontend.databinding.FragmentDropdownListBinding fragmentDropdownListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_dropdown_list, container, false);

        RecyclerView recyclerView = fragmentDropdownListBinding.dropdownRecyclerview;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        // Retrieve the list of provinces from the arguments
        assert getArguments() != null;
        ArrayList<String> provinceList = getArguments().getStringArrayList(ARG_PROVINCE_LIST);

        DropdownAdapter dropdownAdapter = new DropdownAdapter(provinceList);
        recyclerView.setAdapter(dropdownAdapter);

        dropdownAdapter.setOnItemClickListener(item -> {
            if (selectionCallback != null) {
                selectionCallback.onItemSelected(item);
            }
            dismiss();
        });

        return fragmentDropdownListBinding.getRoot();
    }

    public void setProvinceSelectionCallback(SelectionCallback callback) {
        this.selectionCallback = callback;
    }
}
