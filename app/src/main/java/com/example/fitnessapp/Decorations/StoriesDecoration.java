package com.example.fitnessapp.Decorations;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class StoriesDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public StoriesDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;

    }
}