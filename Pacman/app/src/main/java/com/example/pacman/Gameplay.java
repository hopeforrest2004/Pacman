/**
 * This class represents the gameplay activity.
 * @author Emir J. Calvillo
 */
package com.example.pacman;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pacman.controller.GameplayController;
import com.example.pacman.model.PacmanPosition;
import com.example.pacman.view.GameView;

public class Gameplay extends AppCompatActivity {
    private GameplayController gameplayController;

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

        GameView gameView = findViewById(R.id.gameView);
        PacmanPosition pacmanPosition = new PacmanPosition(100, 100); // initial position
        gameplayController = new GameplayController(pacmanPosition, gameView);

        Button dpadUp = findViewById(R.id.dpad_up);
        Button dpadDown = findViewById(R.id.dpad_down);
        Button dpadLeft = findViewById(R.id.dpad_left);
        Button dpadRight = findViewById(R.id.dpad_right);

        dpadUp.setOnClickListener(v -> {
            Log.d("Gameplay", "dpad_up clicked");
            gameplayController.movePacman(0, -15);
        });
        dpadDown.setOnClickListener(v -> {
            Log.d("Gameplay", "dpad_down clicked");
            gameplayController.movePacman(0, 15);
        });
        dpadLeft.setOnClickListener(v -> {
            Log.d("Gameplay", "dpad_left clicked");
            gameplayController.movePacman(-15, 0);
        });
        dpadRight.setOnClickListener(v -> {
            Log.d("Gameplay", "dpad_right clicked");
            gameplayController.movePacman(15, 0);
        });
    }
}
