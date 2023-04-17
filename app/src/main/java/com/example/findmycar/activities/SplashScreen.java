package com.example.findmycar.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.findmycar.R;

public class SplashScreen extends AppCompatActivity {
    private static final int SPLASH_TIMEOUT = 2500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_splash_screen);

        ImageView splash_minivan = findViewById(R.id.minivan);
        Animation minivan_animation = AnimationUtils.loadAnimation(this,R.anim.splash_anim);
        splash_minivan.startAnimation(minivan_animation);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIMEOUT);
    }
}