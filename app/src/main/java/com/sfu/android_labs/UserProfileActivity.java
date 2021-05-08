package com.sfu.android_labs;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.SupportMapFragment;

public class UserProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);
        User info = new User();
        UserProfileAdapter movieAdapter = new UserProfileAdapter(info);
        ImageView posterImageView = this.findViewById(R.id.imageView);
        posterImageView.setImageResource(R.drawable.ic_launcher_background);
        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mapView, mapFragment)
                .commit();

    }
}
