package com.example.pacman;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Handler;

public class Intro extends AppCompatActivity {

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

        ImageView pacmanOpen = findViewById(R.id.pacmanOpen);
        ImageView pacmanClosed = findViewById(R.id.pacmanClosed);

        int screenWidth = getResources().getDisplayMetrics().widthPixels;

        ObjectAnimator pacmanMove = ObjectAnimator.ofFloat(pacmanOpen, "translationX", 0f, screenWidth);
        pacmanMove.setDuration(2000);

        ObjectAnimator ghostMove = ObjectAnimator.ofFloat(pacmanClosed, "translationX", 0f, screenWidth);
        ghostMove.setDuration(2000);

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
        }, 2000);

    }
}