package com.tetravalstartups.oranzebird.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tetravalstartups.oranzebird.R;
import com.tetravalstartups.oranzebird.apis.APIClient;
import com.tetravalstartups.oranzebird.apis.RequestInterface;
import com.tetravalstartups.oranzebird.common.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvLogin;
    private TextView tvSignup;
    private static final String TAG = "LogInActivity";
    private EditText etEmail;
    private EditText etPassword;

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

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
    }

    @Override
    public void onClick(View view) {
        if (view == tvLogin) {
            doUIValidation();
        }
        if (view == tvSignup) {
            gotoSignUpScreen();
        }
    }

    private void doUIValidation() {

        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        if (TextUtils.isEmpty(email)) {
            etEmail.requestFocus();
            etEmail.setError("Email Required");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            etPassword.requestFocus();
            etPassword.setError("Password Required");
            return;
        }
        doLogin(email, password);
    }

    private void doLogin(String email, String password) {
        RequestInterface requestInterface = APIClient.getRetrofitInstance().create(RequestInterface.class);
        Call<DoUserLogin> call = requestInterface.doLogin(email, password);
        call.enqueue(new Callback<DoUserLogin>() {
            @Override
            public void onResponse(Call<DoUserLogin> call, Response<DoUserLogin> response) {
                Log.e(TAG, "onResponse: " + response.code() + " " + response.message());
                if (response.code() == 200) {
                    gotoMainScreen();
                } else if (response.code() == 400) {
                    Toast.makeText(LogInActivity.this, "Inavalid Email/Mobile Or Password!", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "onResponse: Inavalid Email/Mobile Or Password!");
                } else {
                    Log.e(TAG, "onResponse: Something Went Wrong");
                }
            }

            @Override
            public void onFailure(Call<DoUserLogin> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
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