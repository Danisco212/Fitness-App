package com.example.fitnessapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.fitnessapp.Adapters.NewArticleAdapter;
import com.example.fitnessapp.Models.Article;
import com.example.fitnessapp.R;

import java.util.ArrayList;
import java.util.List;

public class TrainerProfileActivity extends AppCompatActivity {

    private RecyclerView trainerArticles;
    private List<Article> articles;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer_profile);
        init();
    }

    private void init(){
        trainerArticles = findViewById(R.id.trainerArticles);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Trainers Profile");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        settingUpArticles();
    }

    private void settingUpArticles(){
        articles = new ArrayList<>();
        articles.add(new Article());
        articles.add(new Article());
        articles.add(new Article());
        articles.add(new Article());
        articles.add(new Article());
        articles.add(new Article());

        NewArticleAdapter articleAdapter = new NewArticleAdapter(articles, true);
        trainerArticles.setAdapter(articleAdapter);
        trainerArticles.setLayoutManager(new LinearLayoutManager(this));
        trainerArticles.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
