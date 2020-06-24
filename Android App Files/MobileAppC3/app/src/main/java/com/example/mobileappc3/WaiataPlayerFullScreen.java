package com.example.mobileappc3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WaiataPlayerFullScreen extends AppCompatActivity {
    private VideoView fullscreenPlayer;
    private String videoPath;
    private Button fullScreen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiata_player_fullscreen);

        fullScreen = findViewById(R.id.fullScreenOV);

        final Intent intent = getIntent();
        videoPath = intent.getStringExtra("path");

        fullscreenPlayer = findViewById(R.id.video_FullScreen);
        Uri uri = Uri.parse(videoPath);
        fullscreenPlayer.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        fullscreenPlayer.setMediaController(mediaController);
        mediaController.setAnchorView(fullscreenPlayer);

        fullscreenPlayer.start();

        if (savedInstanceState != null){
            fullscreenPlayer.seekTo(savedInstanceState.getInt("position"));
        }

        fullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("position", fullscreenPlayer.getCurrentPosition());
    }
}
