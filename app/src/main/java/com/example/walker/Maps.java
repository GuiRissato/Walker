package com.example.walker;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class Maps extends SupportMapFragment implements OnMapReadyCallback, LocationListener {
// a classe vai gerar um local fixo no mapa
    private GoogleMap mMap;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng localizacao = new LatLng(-22.7232217, -47.651769);
        mMap.addMarker(new MarkerOptions().position(localizacao));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(localizacao));
        mMap.setMinZoomPreference(15);

    }

    @Override
    public void onLocationChanged(@NonNull Location location) {

    }
}
