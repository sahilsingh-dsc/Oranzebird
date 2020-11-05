package com.tetravalstartups.oranzebird.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.tetravalstartups.oranzebird.R;
import com.tetravalstartups.oranzebird.auth.LogInActivity;
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
                Intent intent = new Intent(SplashActivity.this, LogInActivity.class);
                startActivity(intent);
                finish();
            }
        }, Constant.SPLASH_DELAY);
    }
}