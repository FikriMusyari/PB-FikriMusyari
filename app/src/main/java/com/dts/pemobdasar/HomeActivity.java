package com.dts.pemobdasar;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.dts.pemobdasar.fragments.Profile;
import com.dts.pemobdasar.fragments.Setting;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.dts.pemobdasar.fragments.Home;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setSelectedItemId(R.id.nav_home);
        bottomNav.setOnItemSelectedListener(navListener);

        Fragment selectedFragment = new Home();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                selectedFragment).commit();

    }

    private NavigationBarView.OnItemSelectedListener navListener =
            item -> {
                int itemId = item.getItemId(); /* obtain the selected item ID from your source */
                Fragment selectedFragment = null;

                if (itemId == R.id.nav_profile) {
                    selectedFragment = new Profile();
                } else if (itemId == R.id.nav_home) {
                    selectedFragment = new Home();
                } else if (itemId == R.id.nav_settings) {
                    // Handle the profile case
                    selectedFragment = new Setting();

                } else {
                    selectedFragment = new Home();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            };

}