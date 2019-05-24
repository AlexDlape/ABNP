package com.example.android.tennisscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int pointsTeamA = 0;
    int pointsTeamB = 0;
    int gamesTeamA = 0;
    int gamesTeamB = 0;
    int setsTeamA = 0;
    int setsTeamB = 0;
    int tiebreakpointsTeamA = 0;
    int tiebreakpointsTeamB = 0;
    int acesTeamA = 0;
    int acesTeamB = 0;
    int absTieBreakDifference = Math.abs(tiebreakpointsTeamA - tiebreakpointsTeamB);

    /**Suggestion
    Nice work.
    If you want to make your code more modular, you can create a class (Team) to model your data about the two teams.
    This class can have your score and outs and everything you want
            Suggest this link to learn more about (classes, objects).
    https://www.tutorialspoint.com/java/java_object_classes.htm
     */

    /**Awesome
    Awesome!! you are following java naming conventions.
    Here to learn more about this.
    https://www.javatpoint.com/java-naming-conventions*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addPointForTeamA(View v) {

        if (setsTeamB == 3) {
            pointsTeamA = pointsTeamA;
            Toast.makeText(this, "Roger Federer has already won!", Toast.LENGTH_SHORT).show();
        }else if  (tiebreakpointsTeamA > 5 &&tiebreakpointsTeamB > 5 &&((Math.abs(tiebreakpointsTeamA - tiebreakpointsTeamB)) == 0) &&setsTeamA < 3) {
                tiebreakpointsTeamA++;
        }else if (tiebreakpointsTeamA > 5 &&tiebreakpointsTeamB > 5 &&tiebreakpointsTeamA > tiebreakpointsTeamB &&((Math.abs(tiebreakpointsTeamA - tiebreakpointsTeamB)) == 1)) {
            tiebreakpointsTeamA = 0;
            tiebreakpointsTeamB = 0;
            gamesTeamA = 0;
            gamesTeamB = 0;
            setsTeamA++;
            Toast.makeText(this, "Set for Rafael Nadal!", Toast.LENGTH_SHORT).show();
        }else if (tiebreakpointsTeamA > 5 &&tiebreakpointsTeamB > 5 &&tiebreakpointsTeamA < tiebreakpointsTeamB &&((Math.abs(tiebreakpointsTeamA - tiebreakpointsTeamB)) == 1)) {
            tiebreakpointsTeamA++;
        }else if (gamesTeamA == 6 &&gamesTeamB == 6 &&tiebreakpointsTeamA < 6 &&tiebreakpointsTeamB < 6 &&setsTeamA < 3) {
                tiebreakpointsTeamA++;
        }else if (gamesTeamA == 6 &&gamesTeamB == 6 &&tiebreakpointsTeamA == 6 &&tiebreakpointsTeamB < 6 &&setsTeamA < 3) {
            tiebreakpointsTeamA = 0;
            tiebreakpointsTeamB = 0;
            gamesTeamA = 0;
            gamesTeamB = 0;
            setsTeamA++;
            Toast.makeText(this, "Set for Rafael Nadal!", Toast.LENGTH_SHORT).show();
        }else if (gamesTeamA == 6 &&gamesTeamB == 6 &&tiebreakpointsTeamB == 6 &&tiebreakpointsTeamA < 6 &&setsTeamA < 3) {
            tiebreakpointsTeamA++;
        }else if (pointsTeamA < 30 &&setsTeamA < 3) {
            pointsTeamA = pointsTeamA + 15;
        }else if (pointsTeamA == 30) {
            pointsTeamA = pointsTeamA + 10;
        }else if (pointsTeamA == 40 &&pointsTeamB == 40) {
            pointsTeamA = 45;
        }else if (pointsTeamA == 40 &&pointsTeamB < 40 &&gamesTeamA < 5) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamA++;
            Toast.makeText(this, "Game for Rafael Nadal!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamA == 45 &&pointsTeamB == 40 &&gamesTeamA == 5 &&gamesTeamB == 5 &&setsTeamA < 3 &&setsTeamB < 3) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamA++;
            Toast.makeText(this, "Game for Rafael Nadal!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamA == 45 &&pointsTeamB == 40 &&gamesTeamB == 6 &&gamesTeamA == 5 &&setsTeamA < 3 &&setsTeamB < 3) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamA++;
            Toast.makeText(this, "Game for Roger Federer!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamA == 45 &&pointsTeamB == 40 &&gamesTeamA == 5 &&setsTeamA < 3 &&setsTeamB < 3) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamA = 0;
            gamesTeamB = 0;
            setsTeamA++;
            Toast.makeText(this, "Set for Rafael Nadal!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamA == 40 &&pointsTeamB < 40 &&gamesTeamA == 5 &&gamesTeamB < 5) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamA = 0;
            gamesTeamB = 0;
            setsTeamA++;
            Toast.makeText(this, "Set for Rafael Nadal!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamA == 40 &&pointsTeamB < 40 &&gamesTeamA == 5 &&gamesTeamB == 5) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamA++;
            Toast.makeText(this, "Game for Rafael Nadal!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamA == 40 &&pointsTeamB < 40 &&gamesTeamA == 6 &&gamesTeamB == 5 &&setsTeamA < 3) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamA = 0;
            gamesTeamB = 0;
            setsTeamA++;
            Toast.makeText(this, "Set for Rafael Nadal!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamA == 40 &&pointsTeamB < 40 &&gamesTeamA == 5 &&gamesTeamB == 6) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamA++;
            Toast.makeText(this, "Game for Rafael Nadal!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamA == 40 &&pointsTeamB < 40 &&gamesTeamA == 6 &&setsTeamA < 3) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamA = 0;
            gamesTeamB = 0;
            setsTeamA++;
            Toast.makeText(this, "Set for Rafael Nadal!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamA == 40 &&pointsTeamB < 40 &&gamesTeamA == 6 &&setsTeamA < 3) {
            pointsTeamA = 0;
            gamesTeamA = 0;
        }else if (pointsTeamA == 45 &&gamesTeamA < 5) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamA++;
            Toast.makeText(this, "Game for Rafael Nadal!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamA == 45 &&gamesTeamA == 5 &&gamesTeamB == 5) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamA++;
            Toast.makeText(this, "Game for Rafael Nadal!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamA == 45 &&gamesTeamA == 5 &&gamesTeamB == 6) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamA++;
            Toast.makeText(this, "Game for Rafael Nadal!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamA == 45 &&gamesTeamA == 6 &&gamesTeamB == 5 &&setsTeamA < 3) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamA = 0;
            gamesTeamB = 0;
            setsTeamA++;
            Toast.makeText(this, "Set for Rafael Nadal!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamA == 40 &&pointsTeamB == 45) {
            pointsTeamA = 40;
            pointsTeamB = 40;
        }

        if (setsTeamA == 3) {
            // Show an error message as a toast
            Toast.makeText(this, "Rafael Nadal has already won!", Toast.LENGTH_SHORT).show();
        }

        displayForTeamA(pointsTeamA, gamesTeamA, setsTeamA, tiebreakpointsTeamA, acesTeamA);
        displayForTeamB(pointsTeamB, gamesTeamB, setsTeamB, tiebreakpointsTeamB, acesTeamB);
    }

    public void addPointForTeamB(View v) {
        if (setsTeamA == 3) {
            pointsTeamB = pointsTeamB;
            Toast.makeText(this, "Rafael Nadal has already won!", Toast.LENGTH_SHORT).show();
        }else if  (tiebreakpointsTeamB > 5 &&tiebreakpointsTeamA > 5 &&((Math.abs(tiebreakpointsTeamB - tiebreakpointsTeamA)) == 0) &&setsTeamB < 3) {
            tiebreakpointsTeamB++;
        }else if (tiebreakpointsTeamB > 5 &&tiebreakpointsTeamA > 5 &&tiebreakpointsTeamB > tiebreakpointsTeamA &&((Math.abs(tiebreakpointsTeamB - tiebreakpointsTeamA)) == 1)) {
            tiebreakpointsTeamA = 0;
            tiebreakpointsTeamB = 0;
            gamesTeamA = 0;
            gamesTeamB = 0;
            setsTeamB++;
            Toast.makeText(this, "Set for Roger Federer!", Toast.LENGTH_SHORT).show();
        }else if (tiebreakpointsTeamB > 5 &&tiebreakpointsTeamA > 5 &&tiebreakpointsTeamB < tiebreakpointsTeamA &&((Math.abs(tiebreakpointsTeamB - tiebreakpointsTeamA)) == 1)) {
            tiebreakpointsTeamB++;
        }else if (gamesTeamB == 6 &&gamesTeamA == 6 &&tiebreakpointsTeamB < 6 &&tiebreakpointsTeamA < 6 &&setsTeamB < 3) {
            tiebreakpointsTeamB++;
        }else if (gamesTeamB == 6 &&gamesTeamA == 6 &&tiebreakpointsTeamB == 6 &&tiebreakpointsTeamA < 6 &&setsTeamB < 3) {
            tiebreakpointsTeamA = 0;
            tiebreakpointsTeamB = 0;
            gamesTeamA = 0;
            gamesTeamB = 0;
            setsTeamB++;
            Toast.makeText(this, "Set for Roger Federer!", Toast.LENGTH_SHORT).show();
        }else if (gamesTeamA == 6 &&gamesTeamB == 6 &&tiebreakpointsTeamA == 6 &&tiebreakpointsTeamB < 6 &&setsTeamB < 3) {
            tiebreakpointsTeamB++;
        }else if (pointsTeamB < 30 &&setsTeamB < 3) {
            pointsTeamB = pointsTeamB + 15;
        }else if (pointsTeamB == 30) {
            pointsTeamB = pointsTeamB + 10;
        }else if (pointsTeamB == 40 &&pointsTeamA == 40) {
            pointsTeamB = 45;
        }else if (pointsTeamB == 40 &&pointsTeamA < 40 &&gamesTeamB < 5) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamB++;
            Toast.makeText(this, "Game for Roger Federer!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamB == 45 &&pointsTeamA == 40 &&gamesTeamA == 5 &&gamesTeamB == 5 &&setsTeamA < 3 &&setsTeamB < 3) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamB++;
            Toast.makeText(this, "Game for Roger Federer!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamB == 45 &&pointsTeamA == 40 &&gamesTeamA == 6 &&gamesTeamB == 5 &&setsTeamA < 3 &&setsTeamB < 3) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamB++;
            Toast.makeText(this, "Game for Roger Federer!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamB == 45 &&pointsTeamA == 40 &&gamesTeamB == 5 &&setsTeamA < 3 &&setsTeamB < 3) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamA = 0;
            gamesTeamB = 0;
            setsTeamB++;
            Toast.makeText(this, "Set for Roger Federer!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamB == 40 &&pointsTeamA < 40 &&gamesTeamB == 5 &&gamesTeamA < 5) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamA = 0;
            gamesTeamB = 0;
            setsTeamB++;
            Toast.makeText(this, "Set for Roger Federer!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamB == 40 &&pointsTeamA < 40 &&gamesTeamB == 5 &&gamesTeamA == 5) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamB++;
            Toast.makeText(this, "Game for Roger Federer!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamB == 40 &&pointsTeamA < 40 &&gamesTeamB == 6 &&gamesTeamA == 5 &&setsTeamB < 3) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamA = 0;
            gamesTeamB = 0;
            setsTeamB++;
            Toast.makeText(this, "Set for Roger Federer!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamB == 40 &&pointsTeamA < 40 &&gamesTeamB == 5 &&gamesTeamA == 6) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamB++;
            Toast.makeText(this, "Game for Roger Federer!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamB == 40 &&pointsTeamA < 40 &&gamesTeamB == 6 &&setsTeamB < 3) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamA = 0;
            gamesTeamB = 0;
            setsTeamB++;
            Toast.makeText(this, "Set for Roger Federer!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamB == 40 &&pointsTeamA < 40 &&gamesTeamB == 6 &&setsTeamB < 3) {
            pointsTeamB = 0;
            gamesTeamB = 0;
        }else if (pointsTeamB == 45 &&gamesTeamB < 5) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamB++;
            Toast.makeText(this, "Game for Roger Federer!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamB == 45 &&gamesTeamB == 5 &&gamesTeamA == 5) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamB++;
            Toast.makeText(this, "Game for Roger Federer!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamB == 45 &&gamesTeamB == 5 &&gamesTeamA == 6) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamB++;
            Toast.makeText(this, "Game for Roger Federer!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamB == 45 &&gamesTeamB == 6 &&gamesTeamA == 5 &&setsTeamB < 3) {
            pointsTeamA = 0;
            pointsTeamB = 0;
            gamesTeamA = 0;
            gamesTeamB = 0;
            setsTeamB++;
            Toast.makeText(this, "Set for Roger Federer!", Toast.LENGTH_SHORT).show();
        }else if (pointsTeamB == 40 &&pointsTeamA == 45) {
            pointsTeamA = 40;
            pointsTeamB = 40;
        }

        if (setsTeamB == 3) {
            // Show an error message as a toast
            Toast.makeText(this, "Roger Federer has already won!", Toast.LENGTH_SHORT).show();
        }

        displayForTeamA(pointsTeamA, gamesTeamA, setsTeamA, tiebreakpointsTeamA, acesTeamA);
        displayForTeamB(pointsTeamB, gamesTeamB, setsTeamB, tiebreakpointsTeamB, acesTeamB);
    }

    public void addAceForTeamA(View v) {
        if (setsTeamB == 3) {
            acesTeamA = acesTeamA;
            Toast.makeText(this, "Roger Federer has already won!", Toast.LENGTH_SHORT).show();
        }else if (setsTeamA == 3) {
            acesTeamA = acesTeamA;
            Toast.makeText(this, "Rafael Nadal has already won!", Toast.LENGTH_SHORT).show();
        }else {
            acesTeamA++;
        }displayForTeamA(pointsTeamA, gamesTeamA, setsTeamA, tiebreakpointsTeamA, acesTeamA);
    }
    public void quitAceForTeamA(View v) {
        if (acesTeamA == 0) {
            acesTeamA = 0;
        }else if (setsTeamB == 3) {
            acesTeamA = acesTeamA;
            Toast.makeText(this, "Roger Federer has already won!", Toast.LENGTH_SHORT).show();
        }else if (setsTeamA == 3) {
            acesTeamA = acesTeamA;
            Toast.makeText(this, "Rafael Nadal has already won!", Toast.LENGTH_SHORT).show();
        }else {
            acesTeamA--;
        }displayForTeamA(pointsTeamA, gamesTeamA, setsTeamA, tiebreakpointsTeamA, acesTeamA);
    }

    public void addAceForTeamB(View v) {
        if (setsTeamA == 3) {
            acesTeamB = acesTeamB;
            Toast.makeText(this, "Rafael Nadal has already won!", Toast.LENGTH_SHORT).show();
        }else if (setsTeamB == 3) {
            acesTeamB = acesTeamB;
            Toast.makeText(this, "Roger Federer has already won!", Toast.LENGTH_SHORT).show();
        }else {
            acesTeamB++;
        }displayForTeamB(pointsTeamB, gamesTeamB, setsTeamB, tiebreakpointsTeamB, acesTeamB);
    }
    public void quitAceForTeamB(View v) {
        if (acesTeamB == 0) {
            acesTeamB = 0;
        }else if (setsTeamA == 3) {
            acesTeamB = acesTeamB;
            Toast.makeText(this, "Rafael Nadal has already won!", Toast.LENGTH_SHORT).show();
        }else if (setsTeamB == 3) {
            acesTeamB = acesTeamB;
            Toast.makeText(this, "Roger Federer has already won!", Toast.LENGTH_SHORT).show();
        }else {
            acesTeamB--;
        }displayForTeamB(pointsTeamB, gamesTeamB, setsTeamB, tiebreakpointsTeamB, acesTeamB);
    }

    /**

     * Displays the given points for Team A.

     */

    public void displayForTeamA(int points, int games, int sets, int tiebreak, int aces) {

        TextView pointsView = (TextView) findViewById(R.id.team_a_points);
        TextView gamesView = (TextView) findViewById(R.id.team_a_games);
        TextView setsView = (TextView) findViewById(R.id.team_a_sets);
        TextView tiebreakView = (TextView) findViewById(R.id.team_a_tiebreak);
        TextView acesView = (TextView) findViewById(R.id.team_a_aces);

        pointsView.setText(String.valueOf(points));
        gamesView.setText(String.valueOf(games));
        setsView.setText(String.valueOf(sets));
        tiebreakView.setText(String.valueOf(tiebreak));
        acesView.setText(String.valueOf(aces));}

    /**Suggestion
    Great work.
    Suggest writing these lines in the (onCreate()) method.
    This will enhance your code and get your view once your activity is created.*/


    /**

     * Displays the given points for Team B.

     */

    public void displayForTeamB(int points, int games, int sets, int tiebreak, int aces) {

        TextView pointsView = (TextView) findViewById(R.id.team_b_points);
        TextView gamesView = (TextView) findViewById(R.id.team_b_games);
        TextView setsView = (TextView) findViewById(R.id.team_b_sets);
        TextView tiebreakView = (TextView) findViewById(R.id.team_b_tiebreak);
        TextView acesView = (TextView) findViewById(R.id.team_b_aces);

        pointsView.setText(String.valueOf(points));
        gamesView.setText(String.valueOf(games));
        setsView.setText(String.valueOf(sets));
        tiebreakView.setText(String.valueOf(tiebreak));
        acesView.setText(String.valueOf(aces));}

    public void resetScores(View v) {
        pointsTeamA = 0;
        pointsTeamB = 0;
        gamesTeamA = 0;
        gamesTeamB = 0;
        setsTeamA = 0;
        setsTeamB = 0;
        tiebreakpointsTeamA = 0;
        tiebreakpointsTeamB = 0;
        acesTeamA = 0;
        acesTeamB = 0;
        displayForTeamA(pointsTeamA, gamesTeamA, setsTeamA, tiebreakpointsTeamA, acesTeamA);
        displayForTeamB(pointsTeamB, gamesTeamB, setsTeamB, tiebreakpointsTeamB, acesTeamB);
    }

}
