package com.tetravalstartups.oranzebird.modules.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.tetravalstartups.oranzebird.R;
import com.tetravalstartups.oranzebird.apis.APIClient;
import com.tetravalstartups.oranzebird.apis.RequestInterface;
import com.tetravalstartups.oranzebird.modules.fragment.adapter.GetUserOrderAdapter;
import com.tetravalstartups.oranzebird.modules.fragment.model.GetUserOrder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MyOrdersFragment extends Fragment {
    private View view;
    private static final String TAG = "MyOrdersFragment";
    private RecyclerView getUserOderRecyclerView;
    private GetUserOrderAdapter getUserOrderAdapter;

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
        getUserOderRecyclerView = view.findViewById(R.id.getUserOderRecyclerView);

        setGetUserOrderRecyclerView();
    }

    private void setGetUserOrderRecyclerView() {
        RequestInterface requestInterface = APIClient.getRetrofitInstance().create(RequestInterface.class);
        Call<GetUserOrder> call = requestInterface.getUserOrder("1");
        call.enqueue(new Callback<GetUserOrder>() {
            @Override
            public void onResponse(Call<GetUserOrder> call, Response<GetUserOrder> response) {
                Log.e(TAG, "onResponse: " + response.code() + " " + response.message());
                getUserOrderAdapter = new GetUserOrderAdapter(getContext(), response.body().getOrder());
                getUserOderRecyclerView.setAdapter(getUserOrderAdapter);
                getUserOrderAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<GetUserOrder> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}