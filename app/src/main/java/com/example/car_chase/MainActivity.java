package com.example.car_chase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.car_chase.Fragments.Favourite_Fragment;
import com.example.car_chase.Fragments.Home_Fragment;
import com.example.car_chase.Fragments.Profile_Fragment;
import com.example.car_chase.Fragments.Settings_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new Home_Fragment());

        BottomNavigationView navigationView = findViewById(R.id.bottomNavigationView);
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.navHome){
                    loadFragment(new Home_Fragment());
                }
                else if (id == R.id.navHeart){
                    loadFragment(new Favourite_Fragment());
                }
                else if (id == R.id.navProfile){
                    loadFragment(new Profile_Fragment());
                }
                else if (id == R.id.navSetting){
                    loadFragment(new Settings_Fragment());
                }
                return true;
            }
        });



    }

    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.mainFrameLayout,fragment);
        fragmentTransaction.commit();
    }
}