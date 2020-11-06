package com.tetravalstartups.oranzebird.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tetravalstartups.oranzebird.R;
import com.tetravalstartups.oranzebird.modules.CartActivity;

public class FruitDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_detail);
        initViews();
    }

    private void initViews() {
        tvAddToCart = findViewById(R.id.tvAddToCart);

        tvAddToCart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == tvAddToCart) {
            goToCartActivity();
        }
    }

    private void goToCartActivity() {
        Intent intent = new Intent(FruitDetailActivity.this, CartActivity.class);
        startActivity(intent);
    }
}