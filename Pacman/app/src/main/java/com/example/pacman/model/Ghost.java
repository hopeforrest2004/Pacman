/**
 * Represents a ghost character in the Pacman game. The ghost has coordinates for its current position
 * and a starting position. The class provides methods for getting, setting, and resetting its position.
 *
 * @author Emir J. Calvillo
 * @author Merrit Spencer
 */

package com.example.pacman.model;

import com.example.pacman.view.GameView;

import java.io.*;
import java.util.*;

public class Ghost {
    public int ghostX, ghostY, startX, startY;           // Ghost's current coordinates

    /**
     * Constructor to initialize a new Ghost with a starting position.
     *
     * @param startX The x-coordinate for the starting position of the ghost.
     * @param startY The y-coordinate for the starting position of the ghost.
     */
    public Ghost(int startX, int startY) {
        this.ghostX = startX;
        this.ghostY = startY;
        this.startX = startX;
        this.startY = startY;
    }

    /**
     * Retrieves the current x-coordinate of the ghost.
     *
     * @return The x-coordinate of the ghost.
     */
    public int getGhostX() {
        return this.ghostX;
    }

    /**
     * Retrieves the current y-coordinate of the ghost.
     *
     * @return The y-coordinate of the ghost.
     */
    public int getGhostY() {
        return this.ghostY;
    }

    /**
     * Updates the x-coordinate of the ghost by adding a specified delta.
     *
     * @param dX The change in the x-coordinate of the ghost.
     */
    public void setGhostX(int dX) {
        this.ghostX += dX;
    }

    /**
     * Updates the y-coordinate of the ghost by adding a specified delta.
     *
     * @param dY The change in the y-coordinate of the ghost.
     */
    public void setGhostY(int dY) {
        this.ghostY += dY;
    }

    /**
     * Resets the ghost's position to its starting coordinates.
     */
    public void resetGhost() {
        this.ghostX = startX;
        this.ghostY = startY;
    }


}