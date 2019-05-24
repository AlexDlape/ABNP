package com.example.android.drumbass;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.IconMarginSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**Meets Specifications
 Hello great developer  , it's really great work !
 Hurray....  congrats
 I swear you will be a good developer
 You've done a nice job . I must say, I'm impressed    with your effort.
 You have made an very good User Interface and the code quality was great.🎉 🎊
 Awesome work on the project, everything looks great! I have added some tips and resources to your code review, if you have time you can take a look! Hope you will find them helpful! 🙂
 Your hard work has paid off! Keep up the good work as you continue your Nanodegree journey! Safe journey and bon voyage!
 Stay !
 Answer your Question
 QUESTION 2: Another "next step" would be to be able to click on the song you want from the playlist and then update the "Home activity" with the selected song's info. Which would   be the correct way to do it?
 1-https://googleweblight.com/i?u=https%3A%2F%2Fdeveloper.android.com%2Ftraining%2Fbasics%2Ffragments%2Fcommunicating&hl=ar-EG
 2-https://googleweblight.com/i?u=https%3A%2F%2Fstackoverflow.com%2Fquestions%2F23380097%2Fpassing-interface-to-fragment&hl=ar-EG*/

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the View that shows the playlist activity
        ImageView playlist = (ImageView) findViewById(R.id.playlist);

        // Set a click listener on that View
        playlist.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                /**Awesome
                 Awesome
                 Great! You have used OnClickListener() methods and they work correctly.
                 If you are interested to learn how to make this implementation in different ways, you can visit this interesting post.*/

                // Create a new intent to open the {@link PlaylistActivity}
                Intent playlistIntent = new Intent(MainActivity.this, PlaylistActivity.class);

                /**Awesome
                 Great job in using explicit Intent to call other activities.
                 An explicit intent is one that you use to launch a specific app component, such as a particular activity or service in your app. To create an explicit intent, define the component name for the Intent object—all other intent properties are optional.*/

                // Start the new activity
                startActivity(playlistIntent);

                /**Suggestion
                 When you open another activity, you create a new one, this activity goes to a stack of activities and if you continue creating more the stack continue growing. It is a very good practice to add finish(); after startActivity(your intent) to avoid it. With the exception of the MainActivity.*/

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
                Intent equalizerIntent = new Intent(MainActivity.this, EqualizerActivity.class);

                // Start the new activity
                startActivity(equalizerIntent);
            }
        });
    }
}

/**Suggestion
 Instead of using multiple anonymous instances of the clickListener, you can directly implement this in your activity and then using switch statements, you can reduce the number of lines of codes as you can learn from this example: https://stackoverflow.com/a/4987721/5770629*/