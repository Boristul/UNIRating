package com.miet.walkman295.unirating;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    String coordinate1 = null;
    String coordinate2 = null;
    String name=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Intent intent = getIntent();
        coordinate1 = intent.getStringExtra("c1");
        coordinate2 = intent.getStringExtra("c2");
        name=intent.getStringExtra("c3");

        if(mMap!=null){
            mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter(){

                @Override
                public View getInfoWindow(Marker marker) {
                    return null;
                }

                @Override
                public View getInfoContents(Marker marker) {
                   View view=getLayoutInflater().inflate(R.layout.map_info_window,null);

                    TextView tvLocality=(TextView) view.findViewById(R.id.textViewMap);
                    TextView tvLat=(TextView) view.findViewById(R.id.textViewMapLat);
                    TextView tvLng=(TextView) view.findViewById(R.id.textViewMapLng);
                    LatLng latLng= new LatLng(Double.parseDouble(coordinate1), Double.parseDouble(coordinate2));
                    tvLocality.setText(name);
                    tvLat.setText(coordinate1);
                    tvLng.setText(coordinate2);

                    return view;
                }
            });
        }

        // Add a marker in Sydney and move the camera
        LatLng latLng = new LatLng(Double.parseDouble(coordinate1), Double.parseDouble(coordinate2));

        MarkerOptions markerOptions=new MarkerOptions()
                .title(name)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_uni))
                .position(latLng)
                .snippet("Рейтинг вузов");
        CameraUpdate update=CameraUpdateFactory.newLatLngZoom(latLng,15);
        mMap.moveCamera(update);

        mMap.addMarker(markerOptions);

    }
}
