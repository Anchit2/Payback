package com.example.payback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class splashscreen extends AppCompatActivity {
    ImageView splashimage;
    TextView splashtext;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        animation= AnimationUtils.loadAnimation(this,R.anim.animation_splash);
        splashimage= findViewById(R.id.splashicon);
        splashtext= findViewById(R.id.splashtext);

        splashimage.setAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(splashscreen.this,Login.class));
                finish();
            }
        },4000);

    }
}