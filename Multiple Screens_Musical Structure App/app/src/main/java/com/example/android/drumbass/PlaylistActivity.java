package com.example.android.drumbass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myplaylist_activity);

        // Find the View that shows the main activity
        ImageView home = (ImageView) findViewById(R.id.home);

        // Set a click listener on that View
        home.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link PlaylistActivity}
                Intent homeIntent = new Intent(PlaylistActivity.this, MainActivity.class);

                // Start the new activity
                startActivity(homeIntent);
            }
        });

        // Find the View that shows the equalizer activity
        ImageView equalizer = (ImageView) findViewById(R.id.equalizer);

        // Set a click listener on that View
        equalizer.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the equalizer activity is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link PlaylistActivity}
                Intent equalizerIntent = new Intent(PlaylistActivity.this, EqualizerActivity.class);

                // Start the new activity
                startActivity(equalizerIntent);
            }
        });

        // Create a list of words
        ArrayList<Song> songs = new ArrayList<Song>();

        /**Suggestion
         When declaring variables try to use the interface instead of the implementation, for example, ArrayList is one of the implementations of the List interface, considering this and the good practices for development in Java, this variable declaration should be as follows:
         List<Album> albums = new ArrayList<>();
         OBS: If you do this change, remember to do the same changes in all inputs or outputs of methods that are using this array list.*/

        songs.add(new Song("Clandestino", "Clandestino", "Shakira, Maluma", R.drawable.album));
        /**Awesome
         Excellent use of an ArrayList to store objects of your custom class in a list.*/
        songs.add(new Song("Mi Cama", "Mi Cama", "Becky G, Natti Natasha", R.drawable.album));
        songs.add(new Song("Mi Cama", "Mi Caman", "Carol G, J Balvin", R.drawable.album));
        songs.add(new Song("X Remix", "X Remix", "Nicky Jam, J Balvin", R.drawable.album));
        songs.add(new Song("No Es Justo", "ṭakaakki", "J Balvin, Zion y Lennox", R.drawable.album));
        songs.add(new Song("Vaina Loca", "Vaina Loca", "Ozuna, Manuel Turrizo", R.drawable.album));
        songs.add(new Song("Por Perro", "Por Perro", "Sebastian Yatra", R.drawable.album));
        songs.add(new Song("Live It Up", "Live It Up", "Nicky Jam, Will Smith", R.drawable.album));

        /**Suggestion
         You can use string resources for these hard coded data as well where this link can be of some help.*/

        // Create an {@link SongAdapter}, whose data source is a list of {@link Song}s. The
        // adapter knows how to create list items for each item in the list.
        SongAdapter adapter = new SongAdapter(this, songs, R.color.colorAccent);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // myplaylist_activity.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link SongAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Song} in the list.
        listView.setAdapter(adapter);

    }
}

/**Awesome
 Nice work including your custom ArrayAdapters! =) They are working perfectly and are showing the data into your lists! */