package com.example.workoutapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workoutapp.weekModel;

import java.util.ArrayList;

public class weekRVAdapter extends RecyclerView.Adapter<weekRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<weekModel> weekModelArrayList;
    private Context context;

    // constructor
    public weekRVAdapter(ArrayList<weekModel> weekModelArrayList, Context context) {
        this.weekModelArrayList = weekModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.week_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        weekModel model = weekModelArrayList.get(position);
        holder.weekNoTV.setText(model.getWeek());
        holder.SquatTV.setText(model.getSquat());
        holder.BenchTV.setText(model.getBench());
        holder.DeadliftTV.setText(model.getDeadlift());
        holder.Deadlift2TV.setText(model.getDeadlift2());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return weekModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView weekNoTV, SquatTV, BenchTV, DeadliftTV, Deadlift2TV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            weekNoTV = itemView.findViewById(R.id.idTVWeekNo);
            SquatTV = itemView.findViewById(R.id.idTVSquat);
            BenchTV = itemView.findViewById(R.id.idTVBench);
            DeadliftTV = itemView.findViewById(R.id.idTVDeadlift);
            Deadlift2TV = itemView.findViewById(R.id.idTVDeadlift2);
        }
    }
}
