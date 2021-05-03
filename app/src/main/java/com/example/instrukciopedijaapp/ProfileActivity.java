package com.example.instrukciopedijaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class ProfileActivity extends AppCompatActivity {

    private RelativeLayout relative_views;
    private View predmet_view;
    private EditText predmet_view_text;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        relative_views = findViewById(R.id.relative_views);
        predmet_view = findViewById(R.id.predmet_view);
        predmet_view_text = findViewById(R.id.predmet_view_text);



    }
}