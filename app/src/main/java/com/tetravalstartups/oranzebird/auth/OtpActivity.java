package com.tetravalstartups.oranzebird.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tetravalstartups.oranzebird.R;
import com.tetravalstartups.oranzebird.common.MainActivity;

public class OtpActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        initViews();
    }

    private void initViews() {
        tvSubmit = findViewById(R.id.tvSubmit);

        tvSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == tvSubmit) {
            goToMain();
        }
    }

    private void goToMain() {
        Intent intent = new Intent(OtpActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}