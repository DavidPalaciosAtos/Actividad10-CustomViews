package com.example.actividad10_customviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.actividad10_customviews.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding enlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enlace = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(enlace.getRoot());
    }
}