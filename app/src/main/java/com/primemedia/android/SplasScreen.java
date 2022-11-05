package com.primemedia.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplasScreen extends AppCompatActivity {

    ImageView useLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splas_screen);
        useLogo=findViewById(R.id.useLogo);
        Animation animation;
        animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.bounce_animation);
        useLogo.setAnimation(animation);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);

    }
}