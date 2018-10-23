package com.example.android.drumbass;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class EqualizerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equalizer);

        // Find the View that shows the main activity (home)
        ImageView home = (ImageView) findViewById(R.id.home);

        // Set a click listener on that View
        home.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link PlaylistActivity}
                Intent homeIntent = new Intent(EqualizerActivity.this, MainActivity.class);

                // Start the new activity
                startActivity(homeIntent);
            }
        });

        // Find the View that shows the playlist activity
        ImageView playlist = (ImageView) findViewById(R.id.playlist);

        // Set a click listener on that View
        playlist.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the playlist is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link PlaylistActivity}
                Intent playlistIntent = new Intent(EqualizerActivity.this, PlaylistActivity.class);

                // Start the new activity
                startActivity(playlistIntent);
            }
        });

    }
}
