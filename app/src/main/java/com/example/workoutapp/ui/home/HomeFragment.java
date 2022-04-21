package com.example.workoutapp.ui.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.workoutapp.DBHandler;
import com.example.workoutapp.MainActivity;
import com.example.workoutapp.R;
import com.example.workoutapp.workoutActivity;

public class HomeFragment extends Fragment {

    View layoutView;
    String week;
    private DBHandler dbHandler;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate((savedInstanceState));
        layoutView = inflater.inflate(R.layout.fragment_home, container, false);

        dbHandler = new DBHandler(getActivity());

        getWeek();
        if(week=="1"){
            if (!dbHandler.checkWeek(week)){
                dbHandler.insertNewWeek(week); }
        }
        Button nextWeekBtn = (Button) layoutView.findViewById(R.id.nextButton);
        Button prevWeekBtn = (Button) layoutView.findViewById(R.id.prevButton);

        nextWeekBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                changeWeek("1", week);
                if (!dbHandler.checkWeek(week)){
                    dbHandler.insertNewWeek(week);
                }
            }
        });

        prevWeekBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                changeWeek("-1", week);

            }
        });


        Button changeButton = (Button) layoutView.findViewById((R.id.button));
        changeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openActivity2("S/B Primary");
            }
        });
        Button changeButton1 = (Button) layoutView.findViewById((R.id.button2));
        changeButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openActivity2("Deadlift Primary");
            }
        });
        Button changeButton2 = (Button) layoutView.findViewById((R.id.button3));
        changeButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openActivity2("S/B Secondary");
            }
        });
        Button changeButton3 = (Button) layoutView.findViewById((R.id.button4));
        changeButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openActivity2("Deadlift Secondary");
            }
        });

        return layoutView;
    }

    public void openActivity2(String s){
        Intent i = new Intent(getActivity(), workoutActivity.class);
        i.putExtra("Day", s);
        startActivity(i);
    }

    public void changeWeek(String i, String current){

        int newWeek = Integer.parseInt(i) + Integer.parseInt(current);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Week", String.valueOf(newWeek));
        editor.apply();

        getWeek();
    }

    public void getWeek(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        week = preferences.getString("Week", "1");
        TextView title = (TextView) layoutView.findViewById(R.id.textView);
        title.setText("Workout " + week);
    }
}