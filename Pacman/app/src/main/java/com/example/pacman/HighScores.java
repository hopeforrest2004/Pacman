package com.example.pacman;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HighScores extends AppCompatActivity {

    private final TextView[] textViews = new TextView[10];

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

    public void updateHighScores(int score) {
        SharedPreferences prefs = getSharedPreferences("HIGH_SCORES", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        int[] highScores = new int[10];

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

    private int[] getHighScores() {
        SharedPreferences prefs = getSharedPreferences("HIGH_SCORES", MODE_PRIVATE);
        int[] highScores = new int[10];

        for ( int i = 0; i < 10; i++ ) {
            int score = prefs.getInt("SCORES_" + i, 0);
            highScores[i] = score;
        }
        return highScores;
    }

    private void displayHighScores() {
        int[] scores = getHighScores();

        for ( int i = 0; i < 10; i++ ) {
            String text = (i+1) + ". " + scores[i];
            textViews[i].setText(text);
        }
    }
}