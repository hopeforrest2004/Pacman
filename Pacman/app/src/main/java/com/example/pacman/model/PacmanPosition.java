/**
 * This class represents the position of the Pacman character.
 * @author Emir J. Calvillo
 */

package com.example.pacman.model;

public class PacmanPosition {
    private int pacmanX;
    private int pacmanY;

    /**
     * Constructor for the PacmanPosition class.
     * @param pacmanX The initial X-coordinate of the Pacman character.
     * @param pacmanY The initial Y-coordinate of the Pacman character.
     */
    public PacmanPosition(int pacmanX, int pacmanY) {
        this.pacmanX = pacmanX;
        this.pacmanY = pacmanY;
    }

    /**
     * Getter for the X-coordinate of the Pacman character.
     * @return The X-coordinate of the Pacman character.
     */
    public int getPacmanX() {
        return pacmanX;
    }

    /**
     * Setter for the X-coordinate of the Pacman character.
     * @param pacmanX The new X-coordinate of the Pacman character.
     */
    public void setPacmanX(int pacmanX) {
        this.pacmanX = pacmanX;
    }

    /**
     * Getter for the Y-coordinate of the Pacman character.
     *
     * @return The Y-coordinate of the Pacman character.
     */
    public int getPacmanY() {
        return pacmanY;
    }

    /**
     * Setter for the Y-coordinate of the Pacman character.
     * @param pacmanY The new Y-coordinate of the Pacman character.
     */
    public void setPacmanY(int pacmanY) {
        this.pacmanY = pacmanY;
    }

    /**
     * Moves the Pacman character by the specified amount.
     * @param dx The amount to move in the X-direction.
     * @param dy The amount to move in the Y-direction.
     */
    public void movePacman(int dx, int dy) {
        pacmanX += dx;
        pacmanY += dy;
    }
}
