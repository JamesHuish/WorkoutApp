package com.example.workoutapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.workoutapp.R;
import com.example.workoutapp.workoutActivity;

public class HomeFragment extends Fragment {

    View layoutView;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        super.onCreate((savedInstanceState));
        layoutView = inflater.inflate(R.layout.fragment_home, container, false);
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
}