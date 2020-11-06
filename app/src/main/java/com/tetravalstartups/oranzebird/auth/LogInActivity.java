package com.tetravalstartups.oranzebird.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tetravalstartups.oranzebird.R;
import com.tetravalstartups.oranzebird.common.MainActivity;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvLogin;
    private TextView tvSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        tvLogin = findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(this);
        tvSignup = findViewById(R.id.tvSignup);
        tvSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == tvLogin) {
            gotoMainScreen();
        }
        if (view == tvSignup) {
            gotoSignUpScreen();
        }
    }

    private void gotoSignUpScreen() {
        Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

    private void gotoMainScreen() {
        Intent intent = new Intent(LogInActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}