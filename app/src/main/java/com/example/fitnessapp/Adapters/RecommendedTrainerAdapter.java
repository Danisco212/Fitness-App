package com.example.fitnessapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.fitnessapp.Models.Trainer;
import com.example.fitnessapp.R;

import java.util.List;

public class RecommendedTrainerAdapter extends PagerAdapter {

    private List<Trainer> trainers;
    private LayoutInflater inflater;
    private Context context;

    public RecommendedTrainerAdapter(List<Trainer> trainers, Context context) {
        this.trainers = trainers;
        this.context = context;
    }

    @Override
    public int getCount() {
        return trainers.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recommended_cards, container, false);

        container.addView(view);
        return view;
    }

    @Override
    public float getPageWidth(int position) {
        return 0.65f;
    }


}
