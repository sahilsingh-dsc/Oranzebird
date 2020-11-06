package com.tetravalstartups.oranzebird.modules.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.tetravalstartups.oranzebird.R;


public class MyOrdersFragment extends Fragment {
    private View view;

    public MyOrdersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_my_orders, container, false);
        initViews();
        return view;
    }

    private void initViews() {
    }
}