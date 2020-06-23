package com.example.mobileappc3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.net.URI;

public class WaiataPlayerFullScreen extends AppCompatActivity {
    private VideoView fullscreenPlayer;
    private String videoPath;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiata_player_fullscreen);

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

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("position", fullscreenPlayer.getCurrentPosition());
        Toast.makeText(this, String.valueOf(fullscreenPlayer.getCurrentPosition()), Toast.LENGTH_SHORT).show();
    }
}
