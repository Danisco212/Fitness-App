package com.example.fitnessapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fitnessapp.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void openRegister(View view){
        startActivity(new Intent().setClass(this, RegisterActivity.class));
    }

    public void openApp(View view){
        startActivity(new Intent().setClass(this, MainAppActivity.class));
    }
}
