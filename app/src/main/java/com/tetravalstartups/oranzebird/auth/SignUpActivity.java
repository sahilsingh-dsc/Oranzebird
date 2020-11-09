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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "SignUpActivity";
    private EditText etFullName;
    private EditText etEmail;
    private EditText etContactNumber;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private TextView tvSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initViews();
    }

    private void initViews() {
        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        etContactNumber = findViewById(R.id.etContactNumber);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        tvSubmit = findViewById(R.id.tvSubmit);

        tvSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == tvSubmit) {
            checkUIValidation();
        }
    }

    private void checkUIValidation() {
        String f_name = etFullName.getText().toString();
        String email = etEmail.getText().toString();
        String number = etContactNumber.getText().toString();
        String password = etPassword.getText().toString();
        String confirm_password = etConfirmPassword.getText().toString();

        if (TextUtils.isEmpty(f_name) && TextUtils.isEmpty(email) && TextUtils.isEmpty(number) && TextUtils.isEmpty(password) && TextUtils.isEmpty(confirm_password)) {
            Toast.makeText(this, "Fill All Fields", Toast.LENGTH_SHORT).show();
        } else {
            submitForOTP(f_name, email, number, password);
        }
    }

    private void submitForOTP(String f_name, String email, String number, String password) {
        RequestInterface requestInterface = APIClient.getRetrofitInstance().create(RequestInterface.class);
        Call<UserSignIn> call = requestInterface.doUserSignIn(number, f_name, email, password);
        call.enqueue(new Callback<UserSignIn>() {
            @Override
            public void onResponse(Call<UserSignIn> call, Response<UserSignIn> response) {
                Log.e(TAG, "onResponse: " + response.code() + " " + response.message() + " " + response.body().getMobile());
                if (response.code() == 200) {
                    goToOtpActivity();
                }
            }

            @Override
            public void onFailure(Call<UserSignIn> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    private void goToOtpActivity() {
        Intent intent = new Intent(SignUpActivity.this, OtpActivity.class);
        intent.putExtra("number", etContactNumber.getText().toString());
        startActivity(intent);
    }
}