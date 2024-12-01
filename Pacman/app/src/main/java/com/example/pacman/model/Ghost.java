package com.example.pacman.model;

import com.example.pacman.view.GameView;

import java.io.*;
import java.util.*;

public class Ghost {
    public int ghostX, ghostY, startX, startY;           // Ghost's current coordinates


    public Ghost(int startX, int startY) {
        this.ghostX = startX;
        this.ghostY = startY;
        this.startX = startX;
        this.startY = startY;
    }

    // Gets Ghost's current coordinates
    public int getGhostX() {
        return this.ghostX;
    }
    public int getGhostY() {
        return this.ghostY;
    }
    public void setGhostX(int dX) {
        this.ghostX += dX;
    }
    public void setGhostY(int dY) {
        this.ghostY += dY;
    }
    public void resetGhost() {
        this.ghostX = startX;
        this.ghostY = startY;
    }


}