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

public class HighScores extends AppCompatActivity {

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
     * Updates the high scores if the provided score is higher than any existing high score.
     * The new score is inserted in the correct position, and the high scores are saved to SharedPreferences.
     * After updating, the high scores are displayed.
     *
     * @param score The score to be added to the high scores list.
     */

    public void updateHighScores(int score) {
        SharedPreferences prefs = getSharedPreferences("HIGH_SCORES", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        int[] scores = getHighScores();

        int pos = 10;
        for(int i = 0; i < 10; i++) {
            if ( score > scores[i]) {
                pos = i;
                break;
            }
        }

        // Not a highscore
        if(pos == 10)
            return;

        for(int i = 10; i > pos; i--) {
            editor.putInt("SCORES_" + i,  scores[i-1]);
        }

        editor.putInt("SCORES_" + pos, score);
        editor.apply();

        displayHighScores();
    }

    /**
     * Retrieves the top 10 high scores from SharedPreferences.
     * Each high score is stored as an integer, and an array of high scores is returned.
     *
     * @return An array of integers representing the top 10 high scores.
     */

    private int[] getHighScores() {
        SharedPreferences prefs = getSharedPreferences("HIGH_SCORES", MODE_PRIVATE);
        int[] highScores = new int[10];

        for ( int i = 0; i < 10; i++ ) {
            int score = prefs.getInt("SCORES_" + i, 0);
            highScores[i] = score;
        }
        return highScores;
    }

    /**
     * Displays the top 10 high scores in the corresponding TextViews.
     * This method fetches the high scores using `getHighScores()` and updates each TextView
     * with the corresponding rank and score.
     */

    private void displayHighScores() {
        int[] scores = getHighScores();

        for ( int i = 0; i < 10; i++ ) {
            String text = (i+1) + ". " + scores[i];
            textViews[i].setText(text);
        }
    }
}