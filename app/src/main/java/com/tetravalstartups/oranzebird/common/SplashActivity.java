package com.tetravalstartups.oranzebird.common;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.tetravalstartups.oranzebird.R;
import com.tetravalstartups.oranzebird.auth.PhoneActivity;
import com.tetravalstartups.oranzebird.utils.Constant;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, PhoneActivity.class);
                startActivity(intent);
                finish();
            }
        }, Constant.SPLASH_DELAY);
    }
}