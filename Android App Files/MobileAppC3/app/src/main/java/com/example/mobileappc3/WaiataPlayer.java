package com.example.mobileappc3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
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
        songChoice = intent.getIntExtra("card", 0);
        pickSong(songChoice);
        mediaPlayer.pause();

        // when previous skip button is pressed
        prevSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }

                if (songChoice > 1) {
                    songChoice--;
                    pickSong(songChoice);
                    pauseplay.setBackgroundResource(R.drawable.ic_pause);
                    mediaPlayer.start();
                    flag = false;
                }
                boundaryCheck();
            }
        });

        // when play pause button is pressed
        pauseplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    pickSong(songChoice);
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
        nextSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }

                if (songChoice < 7) {
                    songChoice++;
                    pickSong(songChoice);
                    pauseplay.setBackgroundResource(R.drawable.ic_pause);
                    mediaPlayer.start();
                    flag = false;
                }
                boundaryCheck();
            }
        });

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

//        new Thread(runnable){
//            @Override
//            public void run() {
//                Message msg = new Message();
//                msg.what = mediaPlayer.getCurrentPosition();
//                String cTime = createTimeLabel(msg.what);
//                curTime.setText(cTime);
//            }
//        }.start();
    }

    // pick song
    private void pickSong(int num) {
        switch (num) {
            case 1:
                songTitle.setText("E Kore Koe E Ngaro");
//                songDesc.setText("song 1");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ekorekoe_1);
                break;
            case 2:
                songTitle.setText("He Maimai Aroha nā Tāwhiao");
//                songDesc.setText("song 2");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.hemaimaiaroha_1);
                break;
            case 3:
                songTitle.setText("Waikato Te Awa");
//                songDesc.setText("song 3");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.waikatoteawa_1);
                break;
            case 4:
                songTitle.setText("Tutira ma inga iwi");
//                songDesc.setText("song 4");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.tutiramainga_1);
                break;
            case 5:
                songTitle.setText("Pupuke Te Hihiri");
//                songDesc.setText("song 5");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.pupuketehihiri_1);
                break;
            case 6:
                songTitle.setText("I Te Whare Whakapiri");
//                songDesc.setText("song 6");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.itewhare_1);
                break;
            case 7:
                songTitle.setText("Pua Te Kōwhai");
//                songDesc.setText("song 7");
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

        // mediaplayer completed a song
//        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                if (mediaPlayer != null) {
//                    mediaPlayer.stop();
//                    mediaPlayer.release();
//                }
//
//                if (songChoice < 7) {
//                    songChoice++;
//                    pickSong(songChoice);
//                    pauseplay.setBackgroundResource(R.drawable.ic_pause);
//                    mediaPlayer.start();
//                    flag = false;
//                }
//                boundaryCheck();
//            }
//        });

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
