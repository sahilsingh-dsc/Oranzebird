package com.tetravalstartups.oranzebird.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tetravalstartups.oranzebird.R;
import com.tetravalstartups.oranzebird.apis.APIClient;
import com.tetravalstartups.oranzebird.apis.RequestInterface;
import com.tetravalstartups.oranzebird.common.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtpActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvSubmit;
    private static final String TAG = "OtpActivity";
    private EditText etOTP;
    private String number;
    private TextView tvUserNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        initViews();
    }

    private void initViews() {
        tvSubmit = findViewById(R.id.tvSubmit);
        etOTP = findViewById(R.id.etOTP);
        Intent intent = getIntent();
        tvUserNumber = findViewById(R.id.tvUserNumber);
        number = intent.getStringExtra("number");
        tvSubmit.setOnClickListener(this);
        tvUserNumber.setText(number);
    }

    @Override
    public void onClick(View v) {
        if (v == tvSubmit) {
            CheckUIValidation();
        }
    }

    private void CheckUIValidation() {
        String otp = etOTP.getText().toString();
        if (TextUtils.isEmpty(otp)) {
            etOTP.requestFocus();
            etOTP.setError("Enter Otp");
            return;
        } else {
            goToMainActivity(otp, number);
        }
    }

    private void goToMainActivity(String otp, String number) {
        RequestInterface requestInterface = APIClient.getRetrofitInstance().create(RequestInterface.class);
        Call<UserOTP> call = requestInterface.doUserLogIn(otp, number);
        call.enqueue(new Callback<UserOTP>() {
            @Override
            public void onResponse(Call<UserOTP> call, Response<UserOTP> response) {
                Log.e(TAG, "onResponse: " + response.code() + " " + response.message());
                if (response.code() == 200) {
                    goToMain();
                }
            }

            @Override
            public void onFailure(Call<UserOTP> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    private void goToMain() {
        Intent intent = new Intent(OtpActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}