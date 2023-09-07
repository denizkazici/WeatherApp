package com.example.weather_application;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class daysAdapter extends RecyclerView.Adapter<daysAdapter.myViewHolder>{

    private ArrayList<days> Days;
    LayoutInflater inflater;

    public daysAdapter(Context context, ArrayList<days> Days) {
        inflater = LayoutInflater.from(context);
        this.Days = Days;
    }

    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.day, parent, false);
        myViewHolder holder = new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder( myViewHolder holder, int position) {
        days current_day = Days.get(position);
        holder.setData(current_day, position);
    }


    @Override
    public int getItemCount() {
        return Days.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView daysDate, daysTemp, daysMin, daysMax;
        public myViewHolder( View itemView) {
            super(itemView);
            daysDate = itemView.findViewById(R.id.daysDate);
            daysTemp = itemView.findViewById(R.id.daysTemp);
            daysMin = itemView.findViewById(R.id.daysMin);
            daysMax=itemView.findViewById(R.id.daysMax);
        }

        public void setData(days current_day, int position) {
            this.daysDate.setText(current_day.daysDate);
            this.daysTemp.setText(current_day.daysTemp);
            this.daysMin.setText(current_day.daysMin);
            this.daysMax.setText(current_day.daysMax);

        }

        @Override
        public void onClick(View v) {

        }
    }
}



