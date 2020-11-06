package com.tetravalstartups.oranzebird.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.tetravalstartups.oranzebird.R;
import com.tetravalstartups.oranzebird.modules.CartActivity;
import com.tetravalstartups.oranzebird.modules.fragment.ContactUsFragment;
import com.tetravalstartups.oranzebird.modules.fragment.CouponFragment;
import com.tetravalstartups.oranzebird.modules.fragment.FavouriteFragment;
import com.tetravalstartups.oranzebird.modules.fragment.HomeFragment;
import com.tetravalstartups.oranzebird.modules.fragment.MyOrdersFragment;
import com.tetravalstartups.oranzebird.modules.fragment.ProfileFragment;
import com.tetravalstartups.oranzebird.modules.fragment.ShareFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView cvBanana;
    private DrawerLayout drawerLayout;
    private NavigationView navigation_view;
    private ImageView ivMenu;
    private ImageView ivCart;
    private ImageView ivProfilePic;

    private ImageView ivHome;
    private ImageView ivCoupons;
    private ImageView ivFavourite;
    private FrameLayout mainContent;
    private TextView tvTitle;
    private Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navgation_activity);
        initView();
    }

    private void initView() {
        cvBanana = findViewById(R.id.cvBanana);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigation_view = findViewById(R.id.navigation_view);
        ivMenu = findViewById(R.id.ivMenu);
        ivCart = findViewById(R.id.ivCart);
        tvTitle = findViewById(R.id.tvTitle);

        ivHome = findViewById(R.id.ivHome);
        ivCoupons = findViewById(R.id.ivCoupons);
        ivFavourite = findViewById(R.id.ivFavourite);

        ivProfilePic = findViewById(R.id.ivProfilePic);
        mainContent = findViewById(R.id.mainContent);

//        cvBanana.setOnClickListener(this);
        ivMenu.setOnClickListener(this);
        ivCart.setOnClickListener(this);
        ivHome.setOnClickListener(this);
        ivCoupons.setOnClickListener(this);
        ivFavourite.setOnClickListener(this);
        getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.mainContent, new
                HomeFragment()).commit();
        navigation_view.setCheckedItem(R.id.home);
        navigation_view.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {

                case R.id.user_profile:

                    getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.mainContent, new
                            ProfileFragment()).commit();
                    ivProfilePic.setVisibility(View.INVISIBLE);
                    ivCart.setVisibility(View.INVISIBLE);
                    tvTitle.setText("Profile");
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.orders:
                    ivProfilePic.setVisibility(View.INVISIBLE);
                    ivCart.setVisibility(View.INVISIBLE);
                    tvTitle.setText("My Orders");
                    getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.mainContent, new
                            MyOrdersFragment()).commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;


                case R.id.contacts_us:
                    ivProfilePic.setVisibility(View.INVISIBLE);
                    ivCart.setVisibility(View.INVISIBLE);
                    tvTitle.setText("Contact Us");
                    getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.mainContent, new
                            ContactUsFragment()).commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.share:
                    tvTitle.setText("Share");
                    ivProfilePic.setVisibility(View.INVISIBLE);
                    ivCart.setVisibility(View.INVISIBLE);
                    getSupportFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.mainContent, new
                            ShareFragment()).commit();
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
                case R.id.logout:
                    ivProfilePic.setVisibility(View.INVISIBLE);
                    ivCart.setVisibility(View.INVISIBLE);
                    drawerLayout.closeDrawer(GravityCompat.START);
                    break;
            }
            return false;
        });
    }

    @Override
    public void onClick(View v) {
        if (v == cvBanana) {

        }
        if (v == ivMenu) {
            openMenu();
        }
        if (v == ivCart) {
            openCartActivity();
        }
        if (v == ivHome) {
            fragment = new HomeFragment();
            tvTitle.setText("Home");
            ivProfilePic.setVisibility(View.VISIBLE);
            ivCart.setVisibility(View.VISIBLE);
            loadFragment(fragment);
        }
        if (v == ivCoupons) {
            fragment = new CouponFragment();
            tvTitle.setText("Coupons");
            ivProfilePic.setVisibility(View.INVISIBLE);
            ivCart.setVisibility(View.INVISIBLE);
            loadFragment(fragment);
        }
        if (v == ivFavourite) {
            fragment = new FavouriteFragment();
            tvTitle.setText("Favourite");
            ivProfilePic.setVisibility(View.INVISIBLE);
            ivCart.setVisibility(View.INVISIBLE);
            loadFragment(fragment);
        }
    }

    private void openCartActivity() {
        Intent intent = new Intent(MainActivity.this, CartActivity.class);
        startActivity(intent);
    }

    private void openMenu() {
        drawerLayout.openDrawer(GravityCompat.START);
    }


    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainContent, fragment)
                    .commit();
            return true;
        }

        return false;
    }

    //commenting for commit
}