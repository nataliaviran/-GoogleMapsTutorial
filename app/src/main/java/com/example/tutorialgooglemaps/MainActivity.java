package com.example.tutorialgooglemaps;

import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity {
    private GoogleMap mGoogleMap;
    private SupportMapFragment mMapFragment;
    private LatLng mLatLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setMaps();
    }

    private void setMaps() {
        mMapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mGoogleMap = googleMap;
                mLatLng = new LatLng(-6.8899, 107.6100);
                mGoogleMap.addMarker(new MarkerOptions().position(mLatLng).title("ITB").draggable(true));
                mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(mLatLng));
                mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mLatLng, 20));
                mGoogleMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
                    @Override
                    public void onMarkerDragStart(Marker marker) {

                    }

                    @Override
                    public void onMarkerDrag(Marker marker) {

                    }

                    @Override
                    public void onMarkerDragEnd(Marker marker) {
                        double latiude = marker.getPosition().latitude;
                        double longitude = marker.getPosition().longitude;
                        Toast.makeText(MainActivity.this, latiude + " , " + longitude, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
