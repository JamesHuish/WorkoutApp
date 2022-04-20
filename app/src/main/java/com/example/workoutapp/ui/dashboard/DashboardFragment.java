package com.example.workoutapp.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workoutapp.DBHandler;
import com.example.workoutapp.R;
import com.example.workoutapp.weekModel;
import com.example.workoutapp.weekRVAdapter;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    View layoutView;

    private ArrayList<weekModel> courseModalArrayList;
    private DBHandler dbHandler;
    private weekRVAdapter weekRVAdapter;
    private RecyclerView weekRV;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        super.onCreate((savedInstanceState));
        layoutView = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // initializing our all variables.
        courseModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(getActivity());

        // getting our course array
        // list from db handler class.
        courseModalArrayList = dbHandler.readCourses();

        // on below line passing our array lost to our adapter class.
        weekRVAdapter = new weekRVAdapter(courseModalArrayList, getActivity());
        weekRV = layoutView.findViewById(R.id.idRVweeks);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        weekRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        weekRV.setAdapter(weekRVAdapter);

        return layoutView;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}