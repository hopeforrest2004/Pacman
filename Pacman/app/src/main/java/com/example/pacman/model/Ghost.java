package com.example.pacman.model;

import com.example.pacman.view.GameView;

import java.io.*;
import java.util.*;

public class Ghost {
    public float ghostX, ghostY;           // Ghost's current coordinates
    private final PacmanPosition pacmanPosition; // Pacman's coordinates

    //private char[][] maze;      // Maze grid
    //private static final char WALL = 'X'; // Maze Wall Symbol
    //private static final char EMPTY = 'O'; //Maze Valid Tile Symbol
    
    // Constructor that initializes the Ghost's position and the maze
    // Called 
    public Ghost(PacmanPosition pacmanPosition, GameView gameView) {
        this.pacmanPosition = pacmanPosition;
        this.ghostX = 540; //to be determined
        this.ghostY = 250; //to be determined
        //this.maze = loadMaze(mazeFile);
    }

    // Loads the maze from a file
    /*private char[][] loadMaze(String mazeFile) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(mazeFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        char[][] mazeArray = new char[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            mazeArray[i] = lines.get(i).toCharArray();
        }
        
        return mazeArray;
    }*/

    // Moves the Ghost towards Pacman
    public void move() {
        // Try to move in the ghostX direction first
        if (pacmanPosition.getPacmanX() > ghostX /*&& canMove(ghostX + 1, ghostY)*/) {
            ghostX+=5;
            // Change image left
        } else if (pacmanPosition.getPacmanX() < ghostX /*&& canMove(ghostX - 1, ghostY)*/) {
            ghostX-=5;
            // Change image right
        }
        
        // If moving in the ghostX direction is blocked, Try to move in the ghostY direction
        else if (pacmanPosition.getPacmanY() > ghostY /*&& canMove(ghostX, ghostY + 1)*/) {
            ghostY+=5;
            // Change image up
        } else if (pacmanPosition.getPacmanY() < ghostY /*&& canMove(ghostX, ghostY - 1)*/) {
            ghostY-=5;
          //change image down
        }
        
        // If no movement is possible on the ghostY direction, Try moving in the opposite ghostY direction
        else /*if (canMove(ghostX, ghostY - 1))*/ {
            ghostY-=5;
            //change image down
        } /*else if (canMove(ghostX, ghostY + 1)) {
            ghostY+=5;
         // Change image up
        }*/
    }

    // Checks if the Ghost can move to the given coordinates
    /*private boolean canMove(float newX, float newY) {
        //if (newX < 0 || newX >= maze[0].length || newY < 0 || newY >= maze.length) {
        //    return false;  // Out of bounds
        //}
       // return maze[newY][newX] != WALL;
    }*/



    // Gets Ghost's current coordinates
    public float getGhostX() {
        return this.ghostX;
    }
    public float getGhostY() {
        return this.ghostY;
    }
    public void setGhostX(float newX) {
        this.ghostX = newX;
    }
    public void setGhostY(float newY) {
        this.ghostY = newY;
    }

}