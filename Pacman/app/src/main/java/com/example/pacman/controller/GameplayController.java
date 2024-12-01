/**
 * This class represents the gameplay controller.
 * @author Emir J. Calvillo
 */
package com.example.pacman.controller;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

import com.example.pacman.model.Ghost;
import com.example.pacman.model.PacmanPosition;
import com.example.pacman.view.GameView;

public class GameplayController {
    private final PacmanPosition pacmanPosition;
    private final Ghost ghost;
    private final GameView gameView;

    /**
     * Constructor for the GameplayController class.
     * @param pacmanPosition The Pacman position.
     * @param gameView The GameView.
     */
    public GameplayController(PacmanPosition pacmanPosition, Ghost ghost, GameView gameView) {
        this.pacmanPosition = pacmanPosition;
        this.ghost = ghost;
        this.gameView = gameView;
    }

    /**
     * Moves the Pacman character by the specified amount.
     * @param dx The amount to move in the X-direction.
     * @param dy The amount to move in the Y-direction.
     */
    public void movePacman(int dx, int dy) {
        Log.d("GameplayController", "movePacman called with dx=" + dx + ", dy=" + dy);
        pacmanPosition.movePacman(dx, dy);
        Log.d("GameplayController", "Pacman's new position: x=" + pacmanPosition.getPacmanX() + ", y=" + pacmanPosition.getPacmanY());

    }
}
