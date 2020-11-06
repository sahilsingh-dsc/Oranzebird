package com.tetravalstartups.oranzebird.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tetravalstartups.oranzebird.R;

public class PhoneActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvGetOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        initView();
    }

    private void initView() {
        tvGetOTP = findViewById(R.id.tvGetOTP);

        tvGetOTP.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == tvGetOTP) {
            goToOTPActivity();
        }
    }

    private void goToOTPActivity() {
        Intent intent = new Intent(PhoneActivity.this, OtpActivity.class);
        startActivity(intent);
    }
}