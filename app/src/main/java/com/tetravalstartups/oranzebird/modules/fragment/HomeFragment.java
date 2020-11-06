package com.tetravalstartups.oranzebird.modules.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.tetravalstartups.oranzebird.R;
import com.tetravalstartups.oranzebird.common.FruitDetailActivity;


public class HomeFragment extends Fragment implements View.OnClickListener {
    private View view;
    private CardView cvBanana;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initView();
        return view;
    }

    private void initView() {
        cvBanana = view.findViewById(R.id.cvBanana);

        cvBanana.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == cvBanana) {
            goToDetailsActivity();
        }
    }

    private void goToDetailsActivity() {
        Intent intent = new Intent(getActivity(), FruitDetailActivity.class);
        startActivity(intent);
    }
}