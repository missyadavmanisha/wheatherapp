package com.codingblocks.weather;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.GithubHolder> {

    private ArrayList<Solution> solutions;
    private Context ctx;


    public GithubAdapter(ArrayList<Solution> solutions, Context ctx) {
        this.solutions = solutions;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public GithubHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ctx=viewGroup.getContext();

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.sol, viewGroup, false);

        return new GithubHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GithubHolder githubHolder, int i) {
        Solution currentItem = solutions.get(i);
        githubHolder.temp_min.setText(String.valueOf(currentItem.getTemp_min()));
        githubHolder.temp_max.setText(String.valueOf(currentItem.getTemp_max()));
        githubHolder.humidity.setText(String.valueOf(currentItem.getHumidity()));
        githubHolder.temp.setText(String.valueOf(currentItem.getTemp()));

        githubHolder.dt_txt.setText(currentItem.getDt_txt());




    }

    @Override
    public int getItemCount() {

        return solutions.size();
    }

    class GithubHolder extends RecyclerView.ViewHolder {
     TextView temp,temp_min,temp_max,humidity,dt_txt;


        public GithubHolder(@NonNull final View itemView) {
            super(itemView);

           temp_min=itemView.findViewById(R.id.temp_min);
            temp_max=itemView.findViewById(R.id.temp_max);
            humidity=itemView.findViewById(R.id.humidity);
            temp=itemView.findViewById(R.id.temp);
            dt_txt=itemView.findViewById(R.id.date);
        }
    }

}


