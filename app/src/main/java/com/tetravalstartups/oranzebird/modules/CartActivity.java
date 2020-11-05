package com.tetravalstartups.oranzebird.modules;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.tetravalstartups.oranzebird.R;

public class CartActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        initView();

    }

    private void initView() {
        ivGoBack = findViewById(R.id.ivGoBack);
        ivGoBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == ivGoBack) {
            onBackPressed();
        }
    }
}