package com.example.itunes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    Animation topAnim , bottomAnim;
    ImageView image;
    TextView name;

    private static int SPLASH_SCREEN = Integer.parseInt("5000");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        image = findViewById(R.id.SplashScreenImage);
        name = findViewById(R.id.kishan_itune);

        image.setAnimation(topAnim);
        name.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intant = new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intant);
                finish();
            }
        },SPLASH_SCREEN);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}