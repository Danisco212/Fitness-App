package com.example.fitnessapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.Models.Trainer;
import com.example.fitnessapp.R;

import java.util.List;

public class PersonalTrainersAdapter extends RecyclerView.Adapter<PersonalTrainersAdapter.PersonalTrainersViewHolder> {

    private List<Trainer> trainers;
    private boolean isStory;

    public PersonalTrainersAdapter(List<Trainer> trainers, boolean isStory) {
        this.trainers = trainers;
        this.isStory = isStory;
    }

    @NonNull
    @Override
    public PersonalTrainersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        if (!isStory){
             view= inflater.inflate(R.layout.online_trainer_cards, parent, false);
        }else{
            view= inflater.inflate(R.layout.trainer_stories, parent, false);
        }

        PersonalTrainersViewHolder viewHolder = new PersonalTrainersViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonalTrainersViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return trainers.size();
    }

    public static class PersonalTrainersViewHolder extends RecyclerView.ViewHolder{
        public PersonalTrainersViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
