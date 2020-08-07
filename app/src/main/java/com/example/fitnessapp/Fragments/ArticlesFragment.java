package com.example.fitnessapp.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fitnessapp.Activities.ArticleDetailActivity;
import com.example.fitnessapp.Adapters.NewArticleAdapter;
import com.example.fitnessapp.Models.Article;
import com.example.fitnessapp.R;

import java.util.ArrayList;
import java.util.List;

public class ArticlesFragment extends Fragment {

    private RecyclerView articles;

    public ArticlesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_articles, container, false);

        init(view);
        return view;
    }

    private void init(View view){
        articles = view.findViewById(R.id.articlesList);

        List<Article> myArticles = new ArrayList<>();
        myArticles.add(new Article());
        myArticles.add(new Article());
        myArticles.add(new Article());
        myArticles.add(new Article());
        myArticles.add(new Article());
        myArticles.add(new Article());
        myArticles.add(new Article());
        myArticles.add(new Article());

        NewArticleAdapter articleAdapter = new NewArticleAdapter(myArticles, false);
        articles.setAdapter(articleAdapter);
        articles.setLayoutManager(new LinearLayoutManager(this.getContext()));

        articleAdapter.setOnItemClickListener(new NewArticleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                startActivity(new Intent().setClass(ArticlesFragment.this.getContext(), ArticleDetailActivity.class));
            }
        });

        articles.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));
    }

}
