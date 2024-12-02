package com.example.pacman;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Handler;

public class Intro extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Getting the image views
        ImageView pacmanOpen = findViewById(R.id.pacmanOpen);
        ImageView ghost = findViewById(R.id.redGhost);

        // gets the screen dimensions
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;

        float pacmanStartX = -pacmanOpen.getWidth();
        float ghostStartX = -ghost.getWidth();

        pacmanOpen.setTranslationX(pacmanStartX);
        pacmanOpen.setTranslationY(1000f); // gets the vertical position

        ghost.setTranslationX(ghostStartX);
        ghost.setTranslationY(1000f); // gets the vertical position

        // Defines the target positions
        float pacmanTargetX = screenWidth + pacmanOpen.getWidth();
        float ghostTargetX = screenWidth + ghost.getWidth();

        // Creates the Animations
        ObjectAnimator pacmanMove = ObjectAnimator.ofFloat(pacmanOpen, "translationX", pacmanStartX, pacmanTargetX);
        pacmanMove.setDuration(3000); // Is in milliseconds, so pacman crosses in 3 seconds

        ghost.setVisibility(ImageView.INVISIBLE); // sets ghost invisible
        ObjectAnimator ghostMove = ObjectAnimator.ofFloat(ghost, "translationX", ghostStartX, ghostTargetX);
        ghostMove.setDuration(3000); // ghost crosses in 3 seconds
        ghostMove.setStartDelay(1000); // starts 1 second after pacman (delayed)



        new Handler().postDelayed(() ->{
            ghost.setVisibility(ImageView.VISIBLE);
        }, 1000); // after the one second delay, ghost becomes visible

        // Used to play the music file
        mediaPlayer = MediaPlayer.create(this, R.raw.intro_music);
        //mediaPlayer.setLooping(true);
        mediaPlayer.start();

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(pacmanMove, ghostMove);
        animatorSet.start();


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(Intro.this, Gameplay.class);
                startActivity(intent);
                finish();
            }
        }, 5000); // once the animation is over, it goes to the gameplay class

        animatorSet.addListener(new AnimatorListenerAdapter(){
            @Override
            public void onAnimationEnd(Animator animation){
                if(mediaPlayer != null){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
            }
        });

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}