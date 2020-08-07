package com.example.fitnessapp.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fitnessapp.Adapters.PersonalTrainersAdapter;
import com.example.fitnessapp.Decorations.SpaceItemDecoration;
import com.example.fitnessapp.Decorations.StoriesDecoration;
import com.example.fitnessapp.Models.Trainer;
import com.example.fitnessapp.R;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    private RecyclerView searchTrainers;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        init(view);
        return view;
    }

    private void init(View view){
        searchTrainers = view.findViewById(R.id.searchTrainers);

        List<Trainer> trainers = new ArrayList<>();
        trainers.add(new Trainer());
        trainers.add(new Trainer());
        trainers.add(new Trainer());
        trainers.add(new Trainer());
        trainers.add(new Trainer());
        trainers.add(new Trainer());
        trainers.add(new Trainer());
        trainers.add(new Trainer());

        PersonalTrainersAdapter adapter = new PersonalTrainersAdapter(trainers, "");
        searchTrainers.setAdapter(adapter);
        searchTrainers.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, true));
        searchTrainers.addItemDecoration(new StoriesDecoration(30));
    }

}
