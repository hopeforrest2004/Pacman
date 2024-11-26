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
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import com.example.pacman.R;
import com.example.pacman.model.Ghost;
import com.example.pacman.model.PacmanPosition;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private PacmanPosition pacmanPosition;
    private Ghost ghost;
    private Bitmap pacmanBitmap;
    private Bitmap ghostBitmap;
    private int viewWidth;
    private int viewHeight;

    /**
     * Constructor for the GameView class.
     * @param context
     */
    public GameView(Context context) {
        super(context);
        initialize(context);
    }

    /**
     * Constructor for the GameView class.
     * @param context The context.
     * @param attrs The attribute set.
     */
    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context);
    }

    /**
     * Initializes the GameView.
     * @param context The context.
     */
    private void initialize(Context context) {
        getHolder().addCallback(this);
        pacmanBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.temppacman);
        pacmanBitmap = Bitmap.createScaledBitmap(pacmanBitmap, 100, 100, false);
        if (pacmanBitmap == null) {
            Log.e("GameView", "Pacman Bitmap failed to load!");
        } else {
            Log.d("GameView", "Pacman Bitmap loaded: Width=" + pacmanBitmap.getWidth() + ", Height=" + pacmanBitmap.getHeight());
        }

        ghostBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ghost);
        ghostBitmap = Bitmap.createScaledBitmap(ghostBitmap, 100, 100, false);
        if (ghostBitmap == null) {
            Log.e("GameView", "Ghost Bitmap failed to load!");
        } else {
            Log.d("GameView", "Ghost Bitmap loaded: Width=" + ghostBitmap.getWidth() + ", Height=" + ghostBitmap.getHeight());
        }

        setZOrderOnTop(true);
        getHolder().setFormat(android.graphics.PixelFormat.TRANSLUCENT);
    }

    /**
     * Sets the Pacman position.
     * @param pacmanPosition The Pacman position.
     */
    public void setPacmanPosition(PacmanPosition pacmanPosition) {
        this.pacmanPosition = pacmanPosition;

        if (viewWidth > 0 && viewHeight > 0) {
            pacmanPosition.setPacmanX(viewWidth / 2);
            pacmanPosition.setPacmanY(viewHeight / 2);
        }
    }

    public void setGhostPosition(Ghost ghost) {
        this.ghost = ghost;

        if (viewWidth > 0 && viewHeight > 0) {
            ghost.setGhostX(viewWidth / 3 );
            ghost.setGhostY(viewHeight - 50);
        }
    }
    /**
     * Called when the surface is created.
     * @param holder The SurfaceHolder whose surface is being created.
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d("GameView", "Surface Created");

        viewWidth = getWidth();
        viewHeight = getHeight();

        if (pacmanPosition != null) {
            pacmanPosition.setPacmanX(viewWidth / 2);
            pacmanPosition.setPacmanY(viewHeight / 2);
        }

        Canvas canvas = holder.lockCanvas();
        draw(canvas);
        holder.unlockCanvasAndPost(canvas);
    }

    /**
     * Called when the surface has changed.
     * @param holder The SurfaceHolder whose surface has changed.
     * @param format The new format of the surface.
     * @param width The new width of the surface.
     * @param height The new height of the surface.
     */
    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
        invalidate();
    }

    /**
     * Called when the surface is destroyed.
     * @param holder The SurfaceHolder whose surface is being destroyed.
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {}

    /**
     * Draws the game view.
     * @param canvas The Canvas on which to draw.
     */
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Clear the canvas with a debug color to remove previous drawings
        canvas.drawColor(Color.BLACK);

        if (pacmanPosition == null) {
            Log.e("GameView", "PacmanPosition is null");
            return;
        }

        if (pacmanBitmap == null) {
            Log.e("GameView", "Pacman Bitmap is null");
            return;
        }

        float x = pacmanPosition.getPacmanX();
        float y = pacmanPosition.getPacmanY();

        Log.d("GameView", "onDraw called: Drawing Pacman at: X=" + x + ", Y=" + y);
        // Adjust position to center the bitmap at the Pacman coordinates
        canvas.drawBitmap(pacmanBitmap, x - pacmanBitmap.getWidth() / 2, y - pacmanBitmap.getHeight() / 2, null);
        Log.d("GameView", "Pacman drawn successfully.");
        x = ghost.getGhostX();
        y = ghost.getGhostY();

        Log.d("GameView", "onDraw called: Drawing Ghost at: X=" + x + ", Y=" + y);
        // Adjust position to center the bitmap at the Ghost coordinates
        canvas.drawBitmap(ghostBitmap, x - ghostBitmap.getWidth() / 3, y - ghostBitmap.getHeight() / 3, null);
        Log.d("GameView", "Ghost drawn successfully.");
    }
}
