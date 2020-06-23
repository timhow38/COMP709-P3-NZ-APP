package com.example.mobileappc3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WaiataPlayer extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private Handler handler;
    private Runnable runnable;
    private TextView songTitle, curTime; //songDesc
    private int songChoice;
    private boolean flag = true;
    private Button prevSong, pauseplay, nextSong, karaoke, non_vocal;

    private String wSong, wBrief, wMaoriLyric, wEnglishLyric;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiata_player);

        songTitle = findViewById(R.id.TVsongTitle);
        curTime = findViewById(R.id.TVsongTitle2);
        prevSong = findViewById(R.id.backbutton);
        pauseplay = findViewById(R.id.pauseplay);
        nextSong = findViewById(R.id.skipbutton);
        karaoke = findViewById(R.id.karaoke);
        non_vocal = findViewById(R.id.non_vocal);

        handler = new Handler();
        seekBar = findViewById(R.id.seekBar);

        final Intent intent = getIntent();
        Waiata waiata = intent.getParcelableExtra("waiata_item");

        wSong = waiata.getWaiataName();

        wBrief = waiata.getWaiataDesc();
        TextView brief_content = findViewById(R.id.brief_content);
        brief_content.setText(wBrief);
        wMaoriLyric = waiata.getWaiataMaoriLyrics();
        TextView maori_lyrics = findViewById(R.id.maori_lyrics);
        maori_lyrics.setText(wMaoriLyric);
        wEnglishLyric = waiata.getWaiataEngLyrics();
        TextView english_lyrics = findViewById(R.id.english_lyrics);
        english_lyrics.setText(wEnglishLyric);



        int wImageName = waiata.getWaiataImage();
        int wVid1 = waiata.getWaiataVideoName1();
        int wVid2 = waiata.getWaiataVideoName2();
        int wVid3 = waiata.getWaiataVideoName3();

        pickSong(wSong);
        mediaPlayer.pause();

        // when previous skip button is pressed
//        prevSong.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mediaPlayer != null) {
//                    mediaPlayer.stop();
//                    mediaPlayer.release();
//                }
//
//                if (songChoice > 1) {
//                    songChoice--;
//                    pickSong(wSong);
//                    pauseplay.setBackgroundResource(R.drawable.ic_pause);
//                    mediaPlayer.start();
//                    flag = false;
//                }
//                boundaryCheck();
//            }
//        });

        // when play pause button is pressed
        pauseplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    pickSong(wSong);
                    pauseplay.setBackgroundResource(R.drawable.ic_pause);
                    mediaPlayer.start();
                    flag = false;
                } else if (mediaPlayer.isPlaying()) {
                    pauseplay.setBackgroundResource(R.drawable.ic_play_arrow);
                    mediaPlayer.pause();
                } else {
                    pauseplay.setBackgroundResource(R.drawable.ic_pause);
                    mediaPlayer.start();
                }
                boundaryCheck();
            }
        });

        // when next skip button is pressed
//        nextSong.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mediaPlayer != null) {
//                    mediaPlayer.stop();
//                    mediaPlayer.release();
//                }
//
//                if (songChoice < 7) {
//                    songChoice++;
//                    pickSong(wSong);
//                    pauseplay.setBackgroundResource(R.drawable.ic_pause);
//                    mediaPlayer.start();
//                    flag = false;
//                }
//                boundaryCheck();
//            }
//        });

        karaoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WaiataPlayer.this, WaiataPlayerOV.class);
                intent.putExtra("OtherVersion", 1);
                intent.putExtra("title", songTitle.getText());
                startActivity(intent);
            }
        });

        non_vocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WaiataPlayer.this, WaiataPlayerOV.class);
                intent.putExtra("OtherVersion", 2);
                intent.putExtra("title", songTitle.getText());
                startActivity(intent);
            }
        });

        boundaryCheck();

    }

    // pick song
    private void pickSong(String wSong) {
        switch (wSong) {
            case "E Kore Koe E Ngaro":
                songTitle.setText("E Kore Koe E Ngaro");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ekorekoe_1);
                break;
            case "He Maimai Aroha nā Tāwhiao":
                songTitle.setText("He Maimai Aroha nā Tāwhiao");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.hemaimaiaroha_1);
                break;
            case "Waikato Te Awa":
                songTitle.setText("Waikato Te Awa");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.waikatoteawa_1);
                break;
            case "Tutira ma inga iwi":
                songTitle.setText("Tutira ma inga iwi");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.tutiramainga_1);
                break;
            case "Pupuke Te Hihiri":
                songTitle.setText("Pupuke Te Hihiri");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.pupuketehihiri_1);
                break;
            case "I Te Whare Whakapiri":
                songTitle.setText("I Te Whare Whakapiri");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.itewhare_1);
                break;
            case "Pua Te Kōwhai":
                songTitle.setText("Pua Te Kōwhai");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.puatekowhai_1);
                break;
            default:
                break;
        }

        // mediaplayer on ready
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                seekBar.setMax(mediaPlayer.getDuration());
                playCycle();
            }
        });

        // when user adjust the seekbar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                    seekBar.setProgress(progress);
                    String cTime = createTimeLabel(progress);
                    curTime.setText(cTime);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    // display song duration timer
    public void playCycle(){
        seekBar.setProgress(mediaPlayer.getCurrentPosition());
        String cTime = createTimeLabel(mediaPlayer.getCurrentPosition());
        curTime.setText(cTime);

        if (mediaPlayer.isPlaying()){
            runnable = new Runnable() {
                @Override
                public void run() {
                    playCycle();
                }
            };
            handler.postDelayed(runnable, 1000);
        }
    }

    // check song boundary
    public void boundaryCheck() {
        playCycle();
        if (songChoice == 1) {
            prevSong.setBackgroundResource(R.drawable.ic_skip_previous_grey);
            prevSong.setEnabled(false);
        } else {
            prevSong.setBackgroundResource(R.drawable.ic_skip_previous);
            prevSong.setEnabled(true);
        }

        if (songChoice == 7) {
            nextSong.setBackgroundResource(R.drawable.ic_skip_next_grey);
            nextSong.setEnabled(false);
        } else {
            nextSong.setBackgroundResource(R.drawable.ic_skip_next);
            nextSong.setEnabled(true);
        }
    }

    // time converter from milisec to min : sec
    public String createTimeLabel(int duration) {
        String timeLabel = "";
        int min = duration / 1000 / 60;
        int sec = duration / 1000 % 60;

        timeLabel += min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }

    @Override // resuming the app
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
    }

    @Override // pausing the app
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override // closing the app
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        handler.removeCallbacks(runnable);
    }
}
