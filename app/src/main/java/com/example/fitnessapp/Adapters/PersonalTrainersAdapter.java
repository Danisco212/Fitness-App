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
    private String type;
    public OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public PersonalTrainersAdapter(List<Trainer> trainers, String type) {
        this.trainers = trainers;
        this.type = type;
    }

    @NonNull
    @Override
    public PersonalTrainersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        if (type.equals("online")){
             view= inflater.inflate(R.layout.online_trainer_cards, parent, false);
        }else if (type.equals("stories")){
            view= inflater.inflate(R.layout.trainer_stories, parent, false);
        }else{
            view= inflater.inflate(R.layout.search_trainer_card, parent, false);
        }

        PersonalTrainersViewHolder viewHolder = new PersonalTrainersViewHolder(view, onItemClickListener);
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
        public PersonalTrainersViewHolder(@NonNull View itemView, final OnItemClickListener onItemClickListener) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        int position = PersonalTrainersViewHolder.this.getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            onItemClickListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
