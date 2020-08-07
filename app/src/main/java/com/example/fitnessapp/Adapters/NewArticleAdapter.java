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
    private boolean isTrainersArticle;

    public OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public NewArticleAdapter(List<Article> articles, boolean isTrainersArticle) {
        this.articles = articles;
        this.isTrainersArticle = isTrainersArticle;
    }

    @NonNull
    @Override
    public NewArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        if (!isTrainersArticle){
             view = inflater.inflate(R.layout.new_article_cards, parent, false);
        }else{
             view = inflater.inflate(R.layout.trainer_article_cards, parent, false);
        }

        NewArticleViewHolder viewHolder = new NewArticleViewHolder(view, onItemClickListener);
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
        public NewArticleViewHolder(@NonNull View itemView, final OnItemClickListener onItemClickListener) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        int position = NewArticleViewHolder.this.getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            onItemClickListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
