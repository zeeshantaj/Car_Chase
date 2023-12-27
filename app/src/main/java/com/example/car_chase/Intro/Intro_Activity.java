package com.example.car_chase.Intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.car_chase.MainActivity;
import com.example.car_chase.R;
import com.example.car_chase.ViewPagerAdapter.ViewPagerAdapter;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class Intro_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        ViewPager2 viewPager2 = findViewById(R.id.ownViewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(adapter);

        DotsIndicator dotsIndicator = findViewById(R.id.dots_indicator);
        dotsIndicator.attachTo(viewPager2);


        Button startBtn = findViewById(R.id.button);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                // Set button text based on the currently selected fragment
                if (position == 2) { // Assuming the third fragment is at index 2 (0-based index)
                    startBtn.setText("Get Started");
                } else {
                    startBtn.setText("Next");
                }
            }
        });

        startBtn.setOnClickListener(v -> {

            int currentItem = viewPager2.getCurrentItem();
            if (currentItem == 2) {
                startActivity(new Intent(this, MainActivity.class));
            } else {
                // Navigate to the next fragment
                viewPager2.setCurrentItem(currentItem + 1, true);
            }

        });

    }
}