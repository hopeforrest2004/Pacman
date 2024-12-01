/**
 * This class represents the game view.
 * @author Emir J. Calvillo
 */
package com.example.pacman.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.example.pacman.R;
import com.example.pacman.model.Ghost;
import com.example.pacman.model.PacmanPosition;

public class GameView extends View {
    final int levelData[][] = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0},
            {0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0},
            {0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    private float pacmanOffsetX = 0, pacmanOffsetY = 0;
    private float ghostOffsetX = 0, ghostOffsetY = 0;
    public int score;
    private int lives = 3;
    private int directionX = 0, directionY = 0;

    private Paint wallPaint, pelletPaint, powerPelletPaint, pacmanPaint, ghostPaint;
    private Handler gameHandler = new Handler();
    private Runnable gameRunnable;
    private Bitmap pacmanBitmap, ghostBitmapOne, ghostBitmapTwo, ghostBitmapThree;
    private PacmanPosition pacmanPosition;
    private Ghost ghostOne,ghostTwo,ghostThree;
    private int viewWidth;
    private int viewHeight;
    private TextView lifeCounter, scoreCounter;


    public GameView(Context context, AttributeSet attrs) {

        super(context, attrs);
        initializePaints();
        loadBitmaps();
        startGameLoop();
    }
    public void setPacmanPosition(PacmanPosition pacmanPos) {
        this.pacmanPosition = pacmanPos;
    }
    public void setGhostPosition(Ghost ghostOnePos, Ghost ghostTwoPos, Ghost ghostThreePos) {
        this.ghostOne = ghostOnePos;
        this.ghostTwo = ghostTwoPos;
        this.ghostThree = ghostThreePos;

    }

    public void setLifeCounter(TextView lifeCounter) {
        this.lifeCounter = lifeCounter;
        lifeCounter.setText(String.valueOf(lives));
    }

    public void setScoreCounter(TextView scoreCounter) {
        this.scoreCounter = scoreCounter;
        scoreCounter.setText(String.valueOf(score));
    }
    private void initializePaints() {
        wallPaint = new Paint();
        wallPaint.setColor(Color.BLUE);

        pelletPaint = new Paint();
        pelletPaint.setColor(Color.YELLOW);

        powerPelletPaint = new Paint();
        powerPelletPaint.setColor(Color.RED);
    }

    private void loadBitmaps() {
        pacmanBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.temppacman);
        ghostBitmapOne = BitmapFactory.decodeResource(getResources(), R.drawable.ghost);
        ghostBitmapTwo = BitmapFactory.decodeResource(getResources(), R.drawable.ghost);
        ghostBitmapThree = BitmapFactory.decodeResource(getResources(), R.drawable.ghost);
    }
    private void startGameLoop() {
        gameRunnable = new Runnable() {
            @Override
            public void run() {
                updateGame();
                invalidate(); // Redraw the view
                gameHandler.postDelayed(this, 300); // ~60 FPS
            }
        };
        gameHandler.post(gameRunnable);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int tileSize = Math.min(getWidth() / levelData[0].length, getHeight() / levelData.length);
        Paint paint = new Paint();

        canvas.drawColor(Color.BLACK);

        // Draw the grid
        for (int row = 0; row < levelData.length; row++) {
            for (int col = 0; col < levelData[row].length; col++) {
                switch (levelData[row][col]) {
                    case 0: // Wall
                        paint.setColor(Color.BLUE);
                        canvas.drawRect(col * tileSize, row * tileSize,
                                (col + 1) * tileSize, (row + 1) * tileSize, paint);
                        break;
                    case 1: // Pellet
                        paint.setColor(Color.YELLOW);
                        canvas.drawCircle((col + 0.5f) * tileSize, (row + 0.5f) * tileSize,
                                tileSize / 6, paint);
                        break;
                    case 3: // Power Pellet
                        paint.setColor(Color.RED);
                        canvas.drawCircle((col + 0.5f) * tileSize, (row + 0.5f) * tileSize,
                                tileSize / 4, paint);
                        break;
                }
            }
        }

        // Draw Pac-Man
        if (pacmanBitmap != null) {
            canvas.drawBitmap(
                    pacmanBitmap,
                    null,
                    new Rect(
                            (int) ((pacmanPosition.getPacmanX() + pacmanOffsetX) * tileSize),
                            (int) ((pacmanPosition.getPacmanY() + pacmanOffsetY) * tileSize),
                            (int) ((pacmanPosition.getPacmanX() + pacmanOffsetX + 1) * tileSize),
                            (int) ((pacmanPosition.getPacmanY() + 1) * tileSize)
                    ),
                    paint
            );
        }

        // Draw Ghost
        if (ghostBitmapOne != null) {
            canvas.drawBitmap(
                    ghostBitmapOne,
                    null,
                    new Rect(
                            (int) ((ghostOne.getGhostX() + ghostOffsetX) * tileSize),
                            (int) ((ghostOne.getGhostY() + ghostOffsetY) * tileSize),
                            (int) ((ghostOne.getGhostX() + ghostOffsetX + 1) * tileSize),
                            (int) ((ghostOne.getGhostY() + ghostOffsetY + 1) * tileSize)
                    ),
                    paint
            );
        }
        if (ghostBitmapTwo != null) {
            canvas.drawBitmap(
                    ghostBitmapTwo,
                    null,
                    new Rect(
                            (int) ((ghostTwo.getGhostX() + ghostOffsetX) * tileSize),
                            (int) ((ghostTwo.getGhostY() + ghostOffsetY) * tileSize),
                            (int) ((ghostTwo.getGhostX() + ghostOffsetX + 1) * tileSize),
                            (int) ((ghostTwo.getGhostY() + ghostOffsetY + 1) * tileSize)
                    ),
                    paint
            );
        }
        if (ghostBitmapThree != null) {
            canvas.drawBitmap(
                    ghostBitmapThree,
                    null,
                    new Rect(
                            (int) ((ghostThree.getGhostX() + ghostOffsetX) * tileSize),
                            (int) ((ghostThree.getGhostY() + ghostOffsetY) * tileSize),
                            (int) ((ghostThree.getGhostX() + ghostOffsetX + 1) * tileSize),
                            (int) ((ghostThree.getGhostY() + ghostOffsetY + 1) * tileSize)
                    ),
                    paint
            );
        }
    }
    private boolean pacmanMoved = false;
    private float lastPacmanX = 1;
    private float lastPacmanY = 1;

    private void updateGame() {
        // Check if Pac-Man has moved
        boolean hasPacmanMoved = (pacmanPosition.getPacmanX() != lastPacmanX || pacmanPosition.getPacmanY() != lastPacmanY);
        if (hasPacmanMoved) {
            pacmanMoved = true; // Mark that Pac-Man has moved
        }

        // Move Pac-Man if the next position is valid
        if (canMove(pacmanPosition.getPacmanX() + directionX, pacmanPosition.getPacmanY() + directionY)) {
            lastPacmanX = pacmanPosition.getPacmanX();
            lastPacmanY = pacmanPosition.getPacmanX();
            pacmanPosition.movePacman(directionX, directionY);

            // Collect pellets
            if (levelData[pacmanPosition.getPacmanY()][pacmanPosition.getPacmanX()] == 1) {
                levelData[pacmanPosition.getPacmanY()][pacmanPosition.getPacmanX()] = 2; // Clear pellet
                score += 1;
                this.scoreCounter.setText(String.valueOf(score));
            }
        }
        if (hasPacmanMoved) {
            ghostMove(ghostOne);
            ghostMove(ghostTwo);
            ghostMove(ghostThree);
        }
        if(checkCollision(ghostOne) || checkCollision(ghostTwo) || checkCollision(ghostThree)) {
            lives -=1;
            lifeCounter.setText(String.valueOf(lives));
            pacmanPosition.setPacmanX(1);
            pacmanPosition.setPacmanY(1);
            ghostOne.resetGhost();
            ghostTwo.resetGhost();
            ghostThree.resetGhost();
            lastPacmanX = 1;
            lastPacmanY = 1;
        }

    }

    private boolean canMove(int x, int y) {
        return x >= 0 && y >= 0 && x < levelData[0].length && y < levelData.length && levelData[y][x] != 0; // Not a wall
    }

    private boolean checkCollision(Ghost ghost) {
        return (pacmanPosition.getPacmanX() == ghost.getGhostX() && pacmanPosition.getPacmanY() == ghost.getGhostY());
    }

    // Moves the Ghost towards Pacman

    public void ghostMove(Ghost ghost) {
        // Try to move in the ghostX direction first
        if (pacmanPosition.getPacmanX() < ghost.getGhostX() && canMove(ghost.getGhostX() - 1, ghost.getGhostY())) {
            ghost.setGhostX(-1);
            // Change image left
        } else if (pacmanPosition.getPacmanX() > ghost.getGhostX() && canMove(ghost.getGhostX() + 1, ghost.getGhostY()))
                ghost.setGhostX(1);

        // If moving in the ghostX direction is blocked, Try to move in the ghostY direction
        else if (pacmanPosition.getPacmanY() > ghost.getGhostY() && canMove(ghost.getGhostX(), ghost.getGhostY() + 1)) {
                ghost.setGhostY(1);
            // Change image up
        } else if (pacmanPosition.getPacmanY() < ghost.getGhostY() && canMove(ghost.getGhostX(), ghost.getGhostY() - 1)) {
                ghost.setGhostY(-1);
            //change image down
        }
        else if ((pacmanPosition.getPacmanX() == ghost.getGhostX() && (!canMove(ghost.getGhostX(), ghost.getGhostY() + 1) || !canMove(ghost.getGhostX() , ghost.getGhostY()-1)))){
            if (directionX == 1) {
                ghost.setGhostX(1);
            } else if (directionX == -1) {
                ghost.setGhostX(-1);
            }
        }
        else if ((pacmanPosition.getPacmanY() == ghost.getGhostY() && (!canMove(ghost.getGhostX()+1, ghost.getGhostY()) || !canMove(ghost.getGhostX()-1, ghost.getGhostY())))){
            if (directionY == 1) {
                ghost.setGhostY(1);
            } else if (directionY == -1) {
                ghost.setGhostY(-1);
            }
        }

    }


    public void setDirection(int dx, int dy) {
        directionX = dx;
        directionY = dy;
    }
}
