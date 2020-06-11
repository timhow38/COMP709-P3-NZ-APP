package com.example.mobileappc3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            ImageView loading = (ImageView) findViewById(R.id.loadingbubble);
            Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale);
            loading.startAnimation(scale);
    }

}
