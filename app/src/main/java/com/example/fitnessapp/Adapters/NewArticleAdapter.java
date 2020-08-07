package com.example.fitnessapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.Models.Article;
import com.example.fitnessapp.Models.Trainer;
import com.example.fitnessapp.R;

import java.util.List;

public class NewArticleAdapter extends RecyclerView.Adapter<NewArticleAdapter.NewArticleViewHolder> {

    private List<Article> articles;

    public NewArticleAdapter(List<Article> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public NewArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.new_article_cards, parent, false);

        NewArticleViewHolder viewHolder = new NewArticleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewArticleViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public static class NewArticleViewHolder extends RecyclerView.ViewHolder{
        public NewArticleViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
