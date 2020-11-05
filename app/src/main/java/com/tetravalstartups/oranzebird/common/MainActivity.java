package com.tetravalstartups.oranzebird.common;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tetravalstartups.oranzebird.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_cart);
    }
}