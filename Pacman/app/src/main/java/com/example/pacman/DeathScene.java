/**
 * This class represents the death screen activity.
 * @author Forrest Hope
 */
package com.example.pacman;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DeathScene extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    /**
     * Called when the activity is created. This method sets up the layout,
     * handles system window insets, initializes the "Go to Main" button,
     * and starts playing the death sound. It also sets up an animation to play
     * upon entry, and stops the media player when the animation ends.
     *
     * @param savedInstanceState A Bundle containing the activity's previously saved state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_death_scene);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button goToMain = findViewById(R.id.goToMain);
        goToMain.setOnClickListener(v -> {
            Intent intent = new Intent(DeathScene.this, MainActivity.class);
            startActivity(intent);
        });
        mediaPlayer = MediaPlayer.create(this, R.raw.death);
        mediaPlayer.start();

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.start();

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

    /**
     * Called when the activity is destroyed. This method ensures that the media player
     * is properly stopped and released to free resources when the activity is destroyed.
     */
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