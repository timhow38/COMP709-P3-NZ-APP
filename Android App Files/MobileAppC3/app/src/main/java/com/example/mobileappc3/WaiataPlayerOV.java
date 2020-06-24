package com.example.mobileappc3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WaiataPlayerOV extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;
    private VideoView videoPlayer;
    private SeekBar seekBar;
    private String videoPath;
    private Uri uri;
    private Button prevSong, pauseplay, nextSong, fullScreen;
    private TextView songTitle, curTime;
    private boolean flag = true;
    private int versionChoice;
    private String songName;
    private ImageButton back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiata_player_ov);

        videoPlayer = findViewById(R.id.video_view);
        seekBar = findViewById(R.id.seekBarOV);
        songTitle = findViewById(R.id.OVsongTitle);
        curTime = findViewById(R.id.OVsongTitle2);
        prevSong = findViewById(R.id.backbuttonOV);
        pauseplay = findViewById(R.id.pauseplayOV);
        nextSong = findViewById(R.id.skipbuttonOV);
        fullScreen = findViewById(R.id.fullScreenOV);
        back = findViewById(R.id.back);

        final Intent intent = getIntent();
        versionChoice = intent.getIntExtra("OtherVersion", 0);
        songName = intent.getStringExtra("title");
        pickSong(songName, versionChoice);
        uri = Uri.parse(videoPath);
        videoPlayer.setVideoURI(uri);

        // when previous skip button is pressed
        prevSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((videoPlayer.getCurrentPosition() - 15000) <= 0) {
                    videoPlayer.seekTo(0);
                } else {
                    videoPlayer.seekTo(videoPlayer.getCurrentPosition() - 15000);
                }
                playCycle();
            }
        });

        //back
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // when play pause button is pressed
        pauseplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    pauseplay.setBackgroundResource(R.drawable.ic_pause);
                    videoPlayer.start();
                    flag = false;
                } else if (videoPlayer.isPlaying()) {
                    pauseplay.setBackgroundResource(R.drawable.ic_play_arrow);
                    videoPlayer.pause();
                } else {
                    pauseplay.setBackgroundResource(R.drawable.ic_pause);
                    videoPlayer.start();
                }
                playCycle();
            }
        });

        // when next skip button is pressed
        nextSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((videoPlayer.getCurrentPosition() + 15000) >= videoPlayer.getDuration()) {
                    videoPlayer.seekTo(videoPlayer.getDuration());
                } else {
                    videoPlayer.seekTo(videoPlayer.getCurrentPosition() + 15000);
                }
                playCycle();
            }
        });

        fullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WaiataPlayerOV.this, WaiataPlayerFullScreen.class);
                intent.putExtra("path", videoPath);
                startActivity(intent);
            }
        });

        videoPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                seekBar.setMax(videoPlayer.getDuration());
                playCycle();
                videoPlayer.pause();
            }
        });

        videoPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                pauseplay.setBackgroundResource(R.drawable.ic_play_arrow);
            }
        });

        // when user adjust the seekbar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    videoPlayer.seekTo(progress);
                    seekBar.setProgress(progress);
                    String cTime = createTimeLabel(progress);
                    curTime.setText(cTime);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }

    private void pickSong(String name, int num) {
        switch (name) {
            case "E Kore Koe E Ngaro":
                songTitle.setText(name);
                if (num == 1){
                    videoPath = "android.resource://" + getPackageName() + "/" + R.raw.ekorekoe_video_1;
                }
                if (num == 2){
                    videoPath = "android.resource://" + getPackageName() + "/" + R.raw.ekorekoe_3;
                }
                break;
            case "He Maimai Aroha nā Tāwhiao":
                songTitle.setText(name);
                if (num == 1){
                    videoPath = "android.resource://" + getPackageName() + "/" + R.raw.hemaimaiaroha_video_1;
                }
                if (num == 2){
                    videoPath = "android.resource://" + getPackageName() + "/" + R.raw.hemaimaiaroha_3;
                }
                break;
            case "Waikato Te Awa":
                songTitle.setText(name);
                if (num == 1){
                    videoPath = "android.resource://" + getPackageName() + "/" + R.raw.waikatoteawa_video_1;
                }
                if (num == 2){
                    videoPath = "android.resource://" + getPackageName() + "/" + R.raw.waikatoteawa_3;
                }
                break;
            case "Tutira ma inga iwi":
                songTitle.setText(name);
                if (num == 1){
                    videoPath = "android.resource://" + getPackageName() + "/" + R.raw.tutiramainga_video_1;
                }
                if (num == 2){
                    videoPath = "android.resource://" + getPackageName() + "/" + R.raw.tutiramainga_3;
                }
                break;
            case "Pupuke Te Hihiri":
                songTitle.setText(name);
                if (num == 1){
                    videoPath = "android.resource://" + getPackageName() + "/" + R.raw.pupuketehihiri_video_1;
                }
                if (num == 2){
                    videoPath = "android.resource://" + getPackageName() + "/" + R.raw.pupuketehihiri_3;
                }
                break;
            case "I Te Whare Whakapiri":
                songTitle.setText(name);
                if (num == 1){
                    videoPath = "android.resource://" + getPackageName() + "/" + R.raw.itewharevideo_1;
                }
                if (num == 2){
                    videoPath = "android.resource://" + getPackageName() + "/" + R.raw.itewhare_3;
                }
                break;
            case "Pua Te Kōwhai":
                songTitle.setText(name);
                if (num == 1){
                    videoPath = "android.resource://" + getPackageName() + "/" + R.raw.puatekowhai_video_1;
                }
                if (num == 2){
                    videoPath = "android.resource://" + getPackageName() + "/" + R.raw.puatekowhai_3;
                }
                break;
            default:
                break;
        }
    }

    public String createTimeLabel(int duration) {
        String timeLabel = "";
        int min = duration / 1000 / 60;
        int sec = duration / 1000 % 60;

        timeLabel += min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }

    // display song duration timer
    public void playCycle() {
        seekBar.setProgress(videoPlayer.getCurrentPosition());
        String cTime = createTimeLabel(videoPlayer.getCurrentPosition());
        curTime.setText(cTime);

        if (videoPlayer.isPlaying()) {
            runnable = new Runnable() {
                @Override
                public void run() {
                    playCycle();
                }
            };
            handler = new Handler();
            handler.postDelayed(runnable, 1000);
        }
    }

    @Override // resuming the app
    protected void onResume() {
        super.onResume();
        videoPlayer.start();
    }

    @Override // pausing the app
    protected void onPause() {
        super.onPause();
        videoPlayer.pause();
    }

    @Override // closing the app
    protected void onDestroy() {
        super.onDestroy();
        videoPlayer.stopPlayback();
        finish();
    }
}
