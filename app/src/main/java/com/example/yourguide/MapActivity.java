package com.example.yourguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Objects;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        //Initializing the custom toolbar
        Toolbar customToolbar = findViewById(R.id.rounded_custom_toolbar);
        //Set the custom toolbar as the support action bar.
        setSupportActionBar(customToolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("");

        // Set a custom click listener for the back button
        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(view -> {
            // Handle the back button click (e.g., navigate back)
            onBackPressed();
        });

        //Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        assert supportMapFragment != null;
        supportMapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     *
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(@NonNull GoogleMap map) {
        Bundle extras = getIntent().getExtras();
        //Checks if extras is empty.
        if(extras != null) {

            String latitude = extras.getString("latitude");
            String longitude = extras.getString("longitude");

            googleMap = map;

            //Camera position for desired location and zoom level.
            LatLng location = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));

            //Add marker in Lahore and move the camera.
            googleMap.addMarker(new MarkerOptions()
                    .position(location).title("Marker in Lahore"));

            float zoomLevel = 13.0f;

            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(location)
                    .zoom(zoomLevel)
                    .build();

            //Duration in milliseconds for the zoom animation.
            int animationDuration = 5000; //5000 milliseconds = 5 seconds.

            //Load everything in map.
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(location));
            // Use a Handler to wait for 3 seconds before starting the animation.
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Start animation to the marker after 3 seconds.
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), animationDuration, null);
                }
            }, 3000); // Wait for 3000 milliseconds (3 seconds).
        }
    }
}