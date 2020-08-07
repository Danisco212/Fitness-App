package com.example.fitnessapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.fitnessapp.Adapters.LandingFragmentAdapter;
import com.example.fitnessapp.Fragments.LandingPage1;
import com.example.fitnessapp.Fragments.LandingPage2;
import com.example.fitnessapp.R;

import java.util.ArrayList;
import java.util.List;

public class LandingActivity extends AppCompatActivity {

    private ViewPager landingPager;
    private List<Fragment> fragments;
    private LandingFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        init();
    }

    private void init(){
        landingPager = findViewById(R.id.landingPager);

        fragments = new ArrayList<>();
        fragments.add(new LandingPage1());
        fragments.add(new LandingPage2());

        adapter = new LandingFragmentAdapter(getSupportFragmentManager(), fragments);
        landingPager.setAdapter(adapter);
    }
}
