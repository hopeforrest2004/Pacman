package com.example.pacman;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageButton startBtn = findViewById(R.id.startBtn);
        ImageButton highscoreBtn = findViewById(R.id.highscoreBtn);

        startBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Intro.class);
            startActivity(intent);
        });

        highscoreBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HighScores.class);
            startActivity(intent);
        });

    }
}