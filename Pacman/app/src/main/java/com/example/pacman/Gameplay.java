/**
 * This class represents the gameplay activity of the Pac-Man game.
 * It manages the game logic, user interactions, and transitions between different activities.
 *
 * @author Emir J. Calvillo
 */
package com.example.pacman;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pacman.controller.GameplayController;
import com.example.pacman.controller.ScoreController;
import com.example.pacman.model.Ghost;
import com.example.pacman.model.PacmanPosition;
import com.example.pacman.view.GameView;

import java.util.concurrent.atomic.AtomicInteger;

public class Gameplay extends AppCompatActivity {

    /** Controller for managing gameplay logic. */
    private GameplayController gameplayController;

    /** AtomicInteger to manage direction flags for movement:
     * 0 = stop, 1 = up, 2 = down, 3 = left, 4 = right.
     */
    private AtomicInteger directionFlag = new AtomicInteger(0);

    /** Handler for scheduling periodic movement tasks. */
    private Handler handler = new Handler();

    /**
     * Called when the activity is first created.
     * Initializes the game view, positions, and controls.
     *
     * @param savedInstanceState A Bundle containing the activity's previously saved state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

        // Initialize positions and objects
        PacmanPosition pacmanPosition = new PacmanPosition(1, 1);
        Ghost ghostOne = new Ghost(17, 27);
        Ghost ghostTwo = new Ghost(17, 14);
        Ghost ghostThree = new Ghost(1, 27);

        // Initialize UI components
        TextView lifeCounter = findViewById(R.id.lives);
        TextView scoreCounter = findViewById(R.id.score);
        GameView gameView = findViewById(R.id.gameView);

        // Set initial positions and counters
        gameView.setPacmanPosition(pacmanPosition);
        gameView.setGhostPosition(ghostOne, ghostTwo, ghostThree);
        gameView.setLifeCounter(lifeCounter);
        gameView.setScoreCounter(scoreCounter);

        // Initialize directional buttons
        Button dpadUp = findViewById(R.id.dpad_up);
        Button dpadDown = findViewById(R.id.dpad_down);
        Button dpadLeft = findViewById(R.id.dpad_left);
        Button dpadRight = findViewById(R.id.dpad_right);

        // Movement logic executed periodically
        Runnable movementTask = new Runnable() {
            @Override
            public void run() {
                // Update Pac-Man's direction based on the flag
                switch (directionFlag.get()) {
                    case 1: // Move up
                        gameView.setDirection(0, -1);
                        break;
                    case 2: // Move down
                        gameView.setDirection(0, 1);
                        break;
                    case 3: // Move left
                        gameView.setDirection(-1, 0);
                        break;
                    case 4: // Move right
                        gameView.setDirection(1, 0);
                        break;
                    default:
                        // No movement
                        break;
                }

                // Handle game over or victory conditions
                if (gameView.lives <= 0) {
                    gameView.lives = 3;

                    ScoreController scoreController = new ScoreController();
                    scoreController.updateHighScores(getApplicationContext(), gameView.score);

                    Intent intent = new Intent(Gameplay.this, DeathScene.class);
                    startActivity(intent);
                    finish();
                }
                if (gameView.score >= 263) {
                    gameView.score = 0;

                    ScoreController scoreController = new ScoreController();
                    scoreController.updateHighScores(getApplicationContext(), gameView.score);

                    Intent intent = new Intent(Gameplay.this, MainActivity.class);
                    Toast.makeText(Gameplay.this, "You win!", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                }

                // Schedule the next execution
                handler.postDelayed(this, 100); // Adjust speed with delay
            }
        };

        // Start the periodic movement
        handler.post(movementTask);

        // Set direction based on button clicks
        dpadUp.setOnClickListener(v -> {
            Log.d("Gameplay", "dpad_up clicked");
            directionFlag.set(1);
        });

        dpadDown.setOnClickListener(v -> {
            Log.d("Gameplay", "dpad_down clicked");
            directionFlag.set(2);
        });

        dpadLeft.setOnClickListener(v -> {
            Log.d("Gameplay", "dpad_left clicked");
            directionFlag.set(3);
        });

        dpadRight.setOnClickListener(v -> {
            Log.d("Gameplay", "dpad_right clicked");
            directionFlag.set(4);
        });
    }

    /**
     * Called when the activity is destroyed.
     * Stops the handler to avoid memory leaks.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}
