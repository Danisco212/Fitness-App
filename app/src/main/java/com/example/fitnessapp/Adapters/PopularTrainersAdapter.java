package com.example.fitnessapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.Models.Trainer;
import com.example.fitnessapp.R;

import java.util.List;

public class PopularTrainersAdapter extends RecyclerView.Adapter<PopularTrainersAdapter.PopularTrainersViewHolder> {

    private List<Trainer> trainers;
    public OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public PopularTrainersAdapter(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    @NonNull
    @Override
    public PopularTrainersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.popular_cards, parent, false);

        PopularTrainersViewHolder viewHolder = new PopularTrainersViewHolder(view, onItemClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PopularTrainersViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return trainers.size();
    }

    public static class PopularTrainersViewHolder extends RecyclerView.ViewHolder{
        public PopularTrainersViewHolder(@NonNull View itemView, final OnItemClickListener onItemClickListener) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        int position = PopularTrainersViewHolder.this.getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            onItemClickListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
