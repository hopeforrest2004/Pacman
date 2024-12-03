package com.example.pacman.controller;

import android.content.Context;
import android.content.SharedPreferences;

public class ScoreController {

    public ScoreController() {}

    /**
     * Updates the high scores if the provided score is higher than any existing high score.
     * The new score is inserted in the correct position, and the high scores are saved to SharedPreferences.
     * After updating, the high scores are displayed.
     *
     * @param score The score to be added to the high scores list.
     */

    public void updateHighScores(Context context, int score) {
        SharedPreferences prefs = context.getSharedPreferences("HIGH_SCORES", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        int[] scores = getHighScores(context);

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
    }

    /**
     * Retrieves the top 10 high scores from SharedPreferences.
     * Each high score is stored as an integer, and an array of high scores is returned.
     *
     * @return An array of integers representing the top 10 high scores.
     */

    public int[] getHighScores(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("HIGH_SCORES", Context.MODE_PRIVATE);
        int[] highScores = new int[10];

        for ( int i = 0; i < 10; i++ ) {
            int score = prefs.getInt("SCORES_" + i, 0);
            highScores[i] = score;
        }
        return highScores;
    }
}
