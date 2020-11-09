package com.tetravalstartups.oranzebird.modules.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.tetravalstartups.oranzebird.R;
import com.tetravalstartups.oranzebird.apis.APIClient;
import com.tetravalstartups.oranzebird.apis.RequestInterface;
import com.tetravalstartups.oranzebird.common.FruitDetailActivity;
import com.tetravalstartups.oranzebird.modules.fragment.adapter.AllCategoryAdapter;
import com.tetravalstartups.oranzebird.modules.fragment.model.AllCategory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment implements View.OnClickListener {
    private View view;
    private CardView cvBanana;
    private static final String TAG = "HomeFragment";
    private RecyclerView allCategoryRecyclerView;
    private AllCategoryAdapter allCategoryAdapter;

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
        allCategoryRecyclerView = view.findViewById(R.id.allCategoryRecyclerView);
        cvBanana.setOnClickListener(this);

        addCategory();
    }

    private void addCategory() {
        RequestInterface requestInterface = APIClient.getRetrofitInstance().create(RequestInterface.class);
        Call<AllCategory> call = requestInterface.getCategories();
        call.enqueue(new Callback<AllCategory>() {
            @Override
            public void onResponse(Call<AllCategory> call, Response<AllCategory> response) {
                Log.e(TAG, "onResponse: " + response.code() + " " + response.message());
                if (response.code() == 200) {

                    allCategoryAdapter = new AllCategoryAdapter(getContext(), response.body().getAllCategoryData());
                    allCategoryRecyclerView.setAdapter(allCategoryAdapter);
                    allCategoryAdapter.notifyDataSetChanged();
                } else if (response.code() == 400) {
                    Log.e(TAG, "onResponse: " + response.message());
                } else {
                    Log.e(TAG, "onResponse: Something Went Wrong");
                }

            }

            @Override
            public void onFailure(Call<AllCategory> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
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