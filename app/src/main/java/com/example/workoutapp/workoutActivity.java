package com.example.workoutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.workoutapp.ui.day1.day1FragmentAccessory;
import com.example.workoutapp.ui.day1.day1FragmentBench;
import com.example.workoutapp.ui.day1.day1FragmentSquat;
import com.example.workoutapp.ui.day2.day2FragmentAccessory;
import com.example.workoutapp.ui.day2.day2FragmentDeadlift;
import com.example.workoutapp.ui.day3.day3FragmentAccessory;
import com.example.workoutapp.ui.day3.day3FragmentBench;
import com.example.workoutapp.ui.day3.day3FragmentSquat;
import com.example.workoutapp.ui.day4.day4FragmentAccessory;
import com.example.workoutapp.ui.day4.day4FragmentDeadlift;

public class workoutActivity extends AppCompatActivity{

    private DBHandler dbHandler;
    private EditText squatEdt, benchEdt, deadliftEdt, deadlift2Edt;
    private Button completeBtn;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        Intent i = getIntent();
        String day = i.getStringExtra("Day");
        ((TextView) findViewById(R.id.textView3)).setText(day);

        Button eButton1 = findViewById(R.id.button5);
        Button eButton2 = findViewById(R.id.button6);
        Button eButton3 = findViewById(R.id.button7);

        squatEdt = findViewById(R.id.editTextNumber);
        benchEdt = findViewById(R.id.editTextNumber2);
        completeBtn = findViewById(R.id.completeButton);

        dbHandler = new DBHandler(workoutActivity.this);

        completeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String squat = squatEdt.getText().toString();
                //String bench = benchEdt.getText().toString();

                /*if (squat.isEmpty()) {
                    Toast.makeText(workoutActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }*/
                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                //dbHandler.addValue("135", "squat", "1");
                dbHandler.insertNewWeek("4");

                // after adding the data we are displaying a toast message.
                Toast.makeText(workoutActivity.this, "Weights have been added.", Toast.LENGTH_SHORT).show();
                //squatEdt.setText("");
                //benchEdt.setText("");
            }
        });


        if(day.equals("S/B Primary")) {
            eButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    replaceFragment(new day1FragmentSquat());
                }
            });
            eButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    replaceFragment(new day1FragmentBench());
                }
            });
            eButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    replaceFragment(new day1FragmentAccessory());
                }
            });
        } else if (day.equals("Deadlift Primary")){
            ((TextView) findViewById(R.id.button5)).setText("Deadlift");

            eButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    replaceFragment(new day2FragmentDeadlift());
                }
            });
            eButton2.setVisibility(View.GONE);
            eButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    replaceFragment(new day2FragmentAccessory());
                }
            });
        } else if (day.equals("S/B Secondary")){
            eButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    replaceFragment(new day3FragmentSquat());
                }
            });
            eButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    replaceFragment(new day3FragmentBench());
                }
            });
            eButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    replaceFragment(new day3FragmentAccessory());
                }
            });
        } else{
            ((TextView) findViewById(R.id.button5)).setText("Deadlift");

            eButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    replaceFragment(new day4FragmentDeadlift());
                }
            });
            eButton2.setVisibility(View.GONE);
            eButton3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    replaceFragment(new day4FragmentAccessory());
                }
            });
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.constraint, fragment);
        ft.commit();
    }
}