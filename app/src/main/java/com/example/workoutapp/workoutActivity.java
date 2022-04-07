package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.workoutapp.ui.day1FragmentBench;
import com.example.workoutapp.ui.day1FragmentSquat;

public class workoutActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        Intent i = getIntent();
        String day = i.getStringExtra("Day");
        ((TextView) findViewById(R.id.textView3)).setText(day);

        Button squatButton = findViewById(R.id.button5);
        Button benchButton = findViewById(R.id.button6);

        squatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                replaceFragment(new day1FragmentSquat());
            }
        });

        benchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                replaceFragment(new day1FragmentBench());
            }
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.constraint, fragment);
        ft.commit();
    }
}