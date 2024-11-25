/**
 * This class represents the gameplay controller.
 * @author Emir J. Calvillo
 */
package com.example.pacman.controller;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

import com.example.pacman.model.PacmanPosition;
import com.example.pacman.view.GameView;

public class GameplayController {
    private final PacmanPosition pacmanPosition;
    private final GameView gameView;

    /**
     * Constructor for the GameplayController class.
     * @param pacmanPosition The Pacman position.
     * @param gameView The GameView.
     */
    public GameplayController(PacmanPosition pacmanPosition, GameView gameView) {
        this.pacmanPosition = pacmanPosition;
        this.gameView = gameView;
        this.gameView.setPacmanPosition(pacmanPosition);  // Set the shared position
    }

    /**
     * Moves the Pacman character by the specified amount.
     * @param dx The amount to move in the X-direction.
     * @param dy The amount to move in the Y-direction.
     */
    public void movePacman(float dx, float dy) {
        Log.d("GameplayController", "movePacman called with dx=" + dx + ", dy=" + dy);
        pacmanPosition.movePacman(dx, dy);
        Log.d("GameplayController", "Pacman's new position: x=" + pacmanPosition.getPacmanX() + ", y=" + pacmanPosition.getPacmanY());

        // Force canvas redraw
        SurfaceHolder holder = gameView.getHolder();
        Canvas canvas = holder.lockCanvas();
        gameView.draw(canvas);
        holder.unlockCanvasAndPost(canvas);
    }
}
