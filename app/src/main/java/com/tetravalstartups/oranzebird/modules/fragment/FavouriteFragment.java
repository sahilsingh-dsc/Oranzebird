package com.tetravalstartups.oranzebird.modules.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.tetravalstartups.oranzebird.R;
import com.tetravalstartups.oranzebird.modules.CartActivity;

public class FavouriteFragment extends Fragment implements View.OnClickListener {
    private View view;
    private TextView tvGoToCart;

    public FavouriteFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_favourite, container, false);
        initViews();
        return view;
    }

    private void initViews() {
        tvGoToCart = view.findViewById(R.id.tvGoToCart);

        tvGoToCart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == tvGoToCart) {
            goToCart();
        }
    }

    private void goToCart() {

        Intent intent = new Intent(getActivity(), CartActivity.class);
        startActivity(intent);

    }
}