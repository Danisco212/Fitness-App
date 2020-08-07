package com.example.fitnessapp.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fitnessapp.Adapters.PopularTrainersAdapter;
import com.example.fitnessapp.Adapters.RecommendedTrainerAdapter;
import com.example.fitnessapp.Models.Trainer;
import com.example.fitnessapp.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private ViewPager recommended;
    private List<Trainer> trainers;
    private RecommendedTrainerAdapter adapter;

    private RecyclerView popular;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        popular = view.findViewById(R.id.popular);

        recommended = view.findViewById(R.id.rec_pager);
        trainers = new ArrayList<>();

        trainers.add(new Trainer());
        trainers.add(new Trainer());
        trainers.add(new Trainer());
        trainers.add(new Trainer());
        trainers.add(new Trainer());
        trainers.add(new Trainer());

        popularTrainers(trainers);

        adapter = new RecommendedTrainerAdapter(trainers, this.getContext());

        recommended.setAdapter(adapter);

        recommended.setClipChildren(false);
        recommended.setClipToPadding(false);
        recommended.setOffscreenPageLimit(2);
        recommended.setPageMargin(70);
        recommended.setPadding(36,0,36,0);
    }

    // loading the popular trainers
    private void popularTrainers(List<Trainer> trainers){
        PopularTrainersAdapter adapter = new PopularTrainersAdapter(trainers);
        popular.setAdapter(adapter);
        popular.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
    }

}
