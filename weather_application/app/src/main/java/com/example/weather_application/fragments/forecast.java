package com.example.weather_application.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weather_application.R;
import com.example.weather_application.days;
import com.example.weather_application.daysAdapter;

import java.util.ArrayList;

public class forecast extends Fragment {
    RecyclerView rv ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forecast, container, false);
        ArrayList<days> Days = new ArrayList<days>();
        Days.add(new days("deneme","1","2","3"));

        rv = view.findViewById(R.id.rvdays);
        daysAdapter daysAdapter = new daysAdapter(view.getContext(), Days);
        rv.setAdapter(daysAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);
        return view;
    }
}