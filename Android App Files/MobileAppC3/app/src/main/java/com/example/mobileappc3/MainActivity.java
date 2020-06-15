package com.example.mobileappc3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView loading = (ImageView) findViewById(R.id.loadingbubble);
        Animation scale = AnimationUtils.loadAnimation(this, R.anim.scale);
        loading.startAnimation(scale);
        delay(new DelayCallback() {
            @Override
            public void afterDelay() {
                openTap();
            }
        });
    }

    private void openTap() {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
        finish();
    }

    public interface DelayCallback{
        void afterDelay();
    }

    public static void delay(final DelayCallback delayCallback){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                delayCallback.afterDelay();
            }
        }, 7 * 1000); // afterDelay will be executed after (secs*10) milliseconds.
    }
}
