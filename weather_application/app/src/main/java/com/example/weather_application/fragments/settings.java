package com.example.weather_application.fragments;



import static androidx.constraintlayout.motion.widget.Debug.getLocation;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.weather_application.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class settings extends Fragment {

    Button changeLocation;
    TextView currLocation;
    LocationManager locationManager;
    String latitude, longitude;
    FusedLocationProviderClient fusedLocationProviderClient;
    private final static int REQUEST_CODE = 100;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(view.getContext());
        changeLocation = view.findViewById(R.id.calculateGps);
        currLocation = view.findViewById(R.id.currLocation);
        changeLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCurrLocation(view);
            }
        });

        return view;
    }

    private void getCurrLocation(View view) {
        if(ContextCompat.checkSelfPermission(view.getContext(),Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if(location != null){
                        Geocoder geocoder = new Geocoder(view.getContext(), Locale.getDefault());
                        try {
                            List<Address> currAddress = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                            latitude= String.valueOf(currAddress.get(0).getLatitude());
                            longitude=String.valueOf(currAddress.get(0).getLongitude());
                            currLocation.setText("Latitude: "+latitude+" Longtiude: "+longitude);
                            //city = currAddress.get(0).getLocality()

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
            });
        }else{
            currLocation.setText("Permission Required");
        }
    }
}