/**
 * This class represents the gameplay activity.
 * @author Emir J. Calvillo
 */
package com.example.pacman;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pacman.controller.GameplayController;
import com.example.pacman.model.Ghost;
import com.example.pacman.model.PacmanPosition;
import com.example.pacman.view.GameView;

import java.util.concurrent.atomic.AtomicInteger;

public class Gameplay extends AppCompatActivity {
    private GameplayController gameplayController;
    private AtomicInteger directionFlag = new AtomicInteger(0); // 0: stop, 1: up, 2: down, 3: left, 4: right
    private Handler handler = new Handler(); // For periodic movement

    /*Called when the activity is first created.*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
        PacmanPosition pacmanPosition = new PacmanPosition(1, 1);
        Ghost ghostOne = new Ghost(17, 27);
        Ghost ghostTwo = new Ghost(17, 14);
        Ghost ghostThree = new Ghost(1, 27);
        TextView lifeCounter = findViewById(R.id.lives);
        TextView scoreCounter = findViewById(R.id.score);
        GameView gameView = findViewById(R.id.gameView);
        gameView.setPacmanPosition(pacmanPosition);
        gameView.setGhostPosition(ghostOne, ghostTwo, ghostThree);
        gameView.setLifeCounter(lifeCounter);
        gameView.setScoreCounter(scoreCounter);
        // initial position
        //GameplayController gameplayController = new GameplayController(pacmanPosition, ghost, gameView);

        Button dpadUp = findViewById(R.id.dpad_up);
        Button dpadDown = findViewById(R.id.dpad_down);
        Button dpadLeft = findViewById(R.id.dpad_left);
        Button dpadRight = findViewById(R.id.dpad_right);

// Movement logic executed periodically
        Runnable movementTask = new Runnable() {
            @Override
            public void run() {
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
                // Schedule next execution
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Stop the handler when the activity is destroyed to avoid memory leaks
        handler.removeCallbacksAndMessages(null);
    }
}
