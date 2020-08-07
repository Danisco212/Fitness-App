package com.example.fitnessapp.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fitnessapp.Adapters.NewArticleAdapter;
import com.example.fitnessapp.Adapters.PersonalTrainersAdapter;
import com.example.fitnessapp.Decorations.SpaceItemDecoration;
import com.example.fitnessapp.Decorations.StoriesDecoration;
import com.example.fitnessapp.Models.Article;
import com.example.fitnessapp.Models.Trainer;
import com.example.fitnessapp.R;

import java.util.ArrayList;
import java.util.List;

public class TrainersFragment extends Fragment {

  private RecyclerView onlineTrainers;
  private RecyclerView trainerStories;

  public TrainersFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_trainers, container, false);

    init(view);
    return view;
  }

  private void init(View view){
    onlineTrainers = view.findViewById(R.id.onlineTrainers);
    trainerStories = view.findViewById(R.id.trainerStories);

    List<Trainer> trainers = new ArrayList<>();
    trainers.add(new Trainer());
    trainers.add(new Trainer());
    trainers.add(new Trainer());
    trainers.add(new Trainer());
    trainers.add(new Trainer());
    trainers.add(new Trainer());
    trainers.add(new Trainer());
    trainers.add(new Trainer());
    trainers.add(new Trainer());

    // online trainers recycler view
    PersonalTrainersAdapter adapter = new PersonalTrainersAdapter(trainers, "online");
    onlineTrainers.setAdapter(adapter);
    onlineTrainers.setLayoutManager(new LinearLayoutManager(this.getContext()));
    onlineTrainers.addItemDecoration(new SpaceItemDecoration(30));

    // stories recycler view
    PersonalTrainersAdapter adapter1 = new PersonalTrainersAdapter(trainers, "stories");
    trainerStories.setAdapter(adapter1);
    trainerStories.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, true));
    trainerStories.addItemDecoration(new StoriesDecoration(20));
    SnapHelper helper = new PagerSnapHelper();
    helper.attachToRecyclerView(trainerStories);
  }

}