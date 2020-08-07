package com.example.fitnessapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fitnessapp.Activities.LoginActivity;
import com.example.fitnessapp.R;

public class LandingPage2 extends Fragment {

    private Button getStarted;

    public LandingPage2(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.landing_page2, container, false);

        init(view);
        return view;

    }


    // initializing the views
    private void init(View view){
        getStarted = view.findViewById(R.id.getStarted);
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent().setClass(getContext(), LoginActivity.class));
            }
        });
    }

}
