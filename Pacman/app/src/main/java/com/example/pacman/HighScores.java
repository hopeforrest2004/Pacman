/**
 * This class represents the high scores activity.
 * @author Justin Gaspar
 */

package com.example.pacman;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pacman.controller.ScoreController;
import com.google.android.material.color.utilities.Score;

public class HighScores extends AppCompatActivity {

    private final ScoreController scoreController = new ScoreController();
    private final TextView[] textViews = new TextView[10];

    /**
     * Called when the activity is created. This method sets up the layout, handles system window insets,
     * initializes the text views for displaying high scores, and calls a method to display the high scores.
     *
     * @param savedInstanceState A Bundle containing the activity's previously saved state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_high_scores);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViews[0] = (TextView) findViewById(R.id.text_highscore_0);
        textViews[1] = (TextView) findViewById(R.id.text_highscore_1);
        textViews[2] = (TextView) findViewById(R.id.text_highscore_2);
        textViews[3] = (TextView) findViewById(R.id.text_highscore_3);
        textViews[4] = (TextView) findViewById(R.id.text_highscore_4);
        textViews[5] = (TextView) findViewById(R.id.text_highscore_5);
        textViews[6] = (TextView) findViewById(R.id.text_highscore_6);
        textViews[7] = (TextView) findViewById(R.id.text_highscore_7);
        textViews[8] = (TextView) findViewById(R.id.text_highscore_8);
        textViews[9] = (TextView) findViewById(R.id.text_highscore_9);

        displayHighScores();
    }

    /**
     * Displays the top 10 high scores in the corresponding TextViews.
     * This method fetches the high scores using `getHighScores()` and updates each TextView
     * with the corresponding rank and score.
     */

    private void displayHighScores() {
        int[] scores = scoreController.getHighScores(getApplicationContext());

        for ( int i = 0; i < 10; i++ ) {
            String text = (i+1) + ". " + scores[i];
            textViews[i].setText(text);
        }
    }
}