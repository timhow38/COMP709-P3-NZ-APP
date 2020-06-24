package com.example.mobileappc3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

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
    private TextView brief_content, maori_lyrics, english_lyrics;
    private String wSong, wBrief, wMaoriLyric, wEnglishLyric;
    private ImageView back;

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
        back = findViewById(R.id.back);

        handler = new Handler();
        seekBar = findViewById(R.id.seekBar);

        final Intent intent = getIntent();
        Waiata waiata = intent.getParcelableExtra("waiata_item");

        wSong = waiata.getWaiataName();

        wBrief = waiata.getWaiataDesc();
        brief_content = findViewById(R.id.brief_content);
        brief_content.setText(wBrief);
        wMaoriLyric = waiata.getWaiataMaoriLyrics();
        maori_lyrics = findViewById(R.id.maori_lyrics);
        maori_lyrics.setText(wMaoriLyric);
        wEnglishLyric = waiata.getWaiataEngLyrics();
        english_lyrics = findViewById(R.id.english_lyrics);
        english_lyrics.setText(wEnglishLyric);

        int wImageName = waiata.getWaiataImage();
        int wVid1 = waiata.getWaiataVideoName1();
        int wVid2 = waiata.getWaiataVideoName2();
        int wVid3 = waiata.getWaiataVideoName3();

        pickSong(wSong);
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
                    pickSong(pickNose(songChoice));
                    pauseplay.setBackgroundResource(R.drawable.ic_pause);
                    mediaPlayer.start();
                    flag = false;
                }
                boundaryCheck();
            }
        });

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
        nextSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }

                if (songChoice < 7) {
                    songChoice++;
                    pickSong(pickNose(songChoice));
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

    }

    private String pickNose(int num) {
        switch (num){
            case 1:
                return "E Kore Koe E Ngaro";
            case 2:
                return "He Maimai Aroha nā Tāwhiao";
            case 3:
                return "Waikato Te Awa";
            case 4:
                return "Tutira ma inga iwi";
            case 5:
                return "Pupuke Te Hihiri";
            case 6:
                return "I Te Whare Whakapiri";
            case 7:
                return "Pua Te Kōwhai";
            default:
                return "abc";
        }
    }

    // pick song
    private void pickSong(String wSong) {
        switch (wSong) {
            case "E Kore Koe E Ngaro":
                songTitle.setText("E Kore Koe E Ngaro");
                brief_content.setText("This waiata was composed by members of local kapahaka Te Iti Kahurangi, as a tribute to the ongoing support the group has received from Wintec over the years.\r\n \r\nIt references names and stories associated with our ic_nav_icon_marae, including the wharenui ‘Te Kākano a te Kaahu’, the interior carving ‘Tāwhaki’, the large memorial pillar dedicated to the late Māori Queen “Te Atairangikaahu’, and the three buildings which represent ‘Ngā Kete Wānanga’, the three baskets of knowledge.\r\n \r\nWhen performing this waiata, the last line ‘E ko Te Kuratini o Waikato’ may also be sung at the beginning as an intro and repeated at the end.");
                maori_lyrics.setText("E ko Te Kuratini o Waikato e\r\n \r\nE kore koe e ngaro he kākano i ruia\r\nKākano a te Kaahu e tū nei e\r\nTe kōpū Mānia, te ngāwhā whakatupu\r\nKa tupu he tangata, rere ki te ao\r\n \r\nHorahia Matariki, kūmea ngā waka\r\nHerea ki te pou o te aroha e\r\nTe Atairangikaahu, tāiri kei runga\r\nKo Kīngi Tūheitia ki te whenua e\r\n \r\nPiki ake Tāwhaki, tāhūhū matapū\r\nNgā kete wānanga e toru e\r\nWhītikitia rā, ka turuturu iho\r\nE ko Te Kuratini o Waikato e");
                english_lyrics.setText("The Waikato Institute of Technology\r\n \r\nYou are not lost, seed of heaven\r\nKākano a te kāhu stand tall\r\nTe kōpū Mānia, cultivate new growth\r\nFoster this person of the world\r\n \r\nMatariki on display, draw in all canoes\r\nBind them to the posts of support and care\r\nTe Atairangikaahu, fly above\r\nKingi Tūheitia, hold steadfast below\r\n \r\nTāwhaki ascend, prepare the house\r\nFor the three baskets of knowledge\r\nBind them, fasten them\r\nTo Waikato Institute of Technology");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ekorekoe_1);
                songChoice = 1;
                break;
            case "He Maimai Aroha nā Tāwhiao":
                songTitle.setText("He Maimai Aroha nā Tāwhiao");
                brief_content.setText("After the devastation of the Waikato raupatu of land confiscations of 1863, King Tāwhiao sought refuge in Maniapoto or the King Country. After nearly two decades, in the early 1880s he made an emotional return to Waikato.\r\n \r\nThe lament expresses his deeply felt sorrow for the land and its meaning to him. It includes in the lyrics the name of our ic_nav_icon_marae, To kōpū Mānia o Kirikiriroa.");
                maori_lyrics.setText("Ka Mātakitaki iho au ki tr riu o Waikato\r\nAnō nei hei kapo kau ake māku\r\nKi te kapu o taku ringa,\r\nKa whakamiri noa I tōna aratau,\r\nE tia nei he tupu pua hou.\r\n \r\nKia hiwa au I te tihi o Pirongia,\r\nInā hei toronga whakaruruhau mōna\r\nKi tōku tauawhirotanga.\r\n \r\nAnā! Te ngoto o tōna ngāwhā\r\nI ōna uma kīhai I ārikarika\r\nA Maungatautari, a Maungakawa,\r\nōku puke maunga, ngā taonga tuku iho\r\nHoki ake nei au ki tōku awa koiora\r\nMe ōna pikonga He kura tangihihia o te mātāmuri.\r\n \r\nE whakawhiti atu ai I te kōpū mania\r\nO Kirikiriroa\r\nMe ōna māra kai, te ngāwhā whakatupu\r\nAke o te whenua mōmona,\r\nHei kawe ki Ngāruawāhia,\r\nTe huinga o te tangata.\r\nArā, te par haumoko, hei okiokinga mō\r\nTaku upoko\r\nHei tirohanga atu mā raro I ngā hūhā\r\nO Taupiri.\r\n \r\nKei reira rā, kei te oroko hanganga o te\r\nTangata\r\nWāhia te tungaroa o te whare,\r\nte whakaputanga mō te kīngi.");
                english_lyrics.setText("I look down on the valley of Waikato,\r\nAs though to hold it in the hollow of my hand\r\nAnd caress its beauty\r\nLike some tender verdant thing.\r\n \r\nI reach out from the top of Pirongia\r\nAs though to cover and protect its\r\nsubstance with my own.\r\n \r\nSee how it bursts through the full bosoms\r\nof Maungatautari and Maungakawa,\r\nhills of my inheritance\r\nthe river of life, each curve more beautiful\r\nthan the last.\r\n \r\nCrossing the smooth belly of Kirikiriroa,\r\nits gardens bursting with fullness of the rich\r\nearth towards the meeting place at\r\nNgāruawāhia.\r\n \r\nThere on the fertile mound I would rest\r\nmy head\r\nand look through the thighs of\r\nTaupiri\r\nThere at the place of all creation\r\nlet the king come forth.");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.hemaimaiaroha_1);
                songChoice = 2;
                break;
            case "Waikato Te Awa":
                songTitle.setText("Waikato Te Awa");
                brief_content.setText("Mr Harrison, the author of this poem, writes that ‘when looking on the different hydro works on the Waikato River, I spent quite a few hours of leisure, marvelling at the greatness of the dams and the lakes formed on this waterway. So, in my spare time I made up this poetry about the Waikato River’.\r\n \r\nThis was published in the historical Te Ao Hou magazine in June 1962, issue 29. Over the years, there have been slight adjustments to the poem to suit the context of todays communities. Wintec only sings the first three verses.");
                maori_lyrics.setText("Waikato te awa\r\nKatohia, katohia\r\nhe wai māu\r\nKatohia he wai māu\r\nKa eke ki Te Pūaha\r\no Waikato te awa\r\nhe piko, he taniwha\r\nhe piko, he taniwha\r\n \r\nKia tūpato rā kei tahuri koe\r\nI ngā au kaha o Waikato\r\nWhakamau tō titiro ki tawhiti rā\r\nKo Taupiri te maunga\r\nPōtatau te tangata\r\nTe mauri o te motu e\r\n \r\nE hoe tō waka ki Ngāruawāhia\r\nTūrangawaewae mō te ao katoa\r\nTe tongi whakamutunga a Matutaera\r\nAuē hoki auē");
                english_lyrics.setText("Waikato te awa\r\ndip in the water\r\nas it surges at the mouth\r\nWaikato is the river\r\nat every bend there lives\r\na chief.\r\n \r\nBe careful lest you capsize\r\nfor the currents are strong\r\nin the Waikato\r\nFix your gaze on the distance\r\nwhere Taupiri is the mountain\r\nand Pōtatau the man.\r\n \r\nPaddle your canoe to Ngāruawahia\r\nto Tūrangawaewae\r\nthe heart of the kingdom\r\nWhere Matutaera finished his lament\r\nAlas, let me grieve also.");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.waikatoteawa_1);
                songChoice = 3;
                break;
            case "Tutira ma inga iwi":
                songTitle.setText("Tutira ma inga iwi");
                brief_content.setText("Wi Huata wrote this song and taught it to his children whilst on a family gathering to Lake Tutira, north of Napier.\r\n \r\nHe was explaining how the iwi came together here to support each other.\r\n \r\nLater he used this song to promote Moral Rearmament, uniting different cultures.");
                maori_lyrics.setText("Tūtira mai ngā iwi\r\ntātou tātou e\r\nTūtira mai ngā iwi\r\ntātou tātou e\r\nWhaia te maramatanga\r\nMe te aroha, e ngā iwi\r\nKia ko tāpatahi,\r\nkia kotāhi rā.\r\nTātou tātou e.\r\n \r\nTūtira mai ngā iwi\r\ntātou tātou e\r\nTūtira mai ngā iwi\r\ntātou tātou e\r\nWhaia te maramatanga\r\nMe te aroha, e ngā iwi\r\nKia ko tāpatahi,\r\nkia kotāhi rā.\r\nTātou tātou e.\r\n \r\nTātou tātou e.\r\nHi aue hei");
                english_lyrics.setText("Line up together, people\r\nAll of us, all of us.\r\nStand in rows, people\r\nAll of us, all of us.\r\nseek after knowledge\r\nand love of others everybody\r\nBe really virtuous and stay united.\r\nAll of us, all of us.\r\n \r\nLine up together, people\r\nAll of us, all of us.\r\nstand in rows, people\r\nAll of us, all of us.\r\nSeek after knowledge\r\nAnd love of others everybody\r\nBe really virtuous and stay united.\r\nAll of us, all of us.\r\n \r\nAll of us, all of us.\r\nHi aue hei");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.tutiramainga_1);
                songChoice = 4;
                break;
            case "Pupuke Te Hihiri":
                songTitle.setText("Pupuke Te Hihiri");
                brief_content.setText("Nā Nganehu Turner ngā kupu, nā Tania Oxenham te rangi 2004 Nganehu Turner (Ngāti Maniapoto) held the position of pouako (tutor) of Te Reo Māori and kuia at Wintec for many years.\r\n \r\nThis was one of the songs she dedicated to the Māori students of Wintec, all who helped to see their aspirations fulfilled.");
                maori_lyrics.setText("Piki ake e tama e Hine\r\nI te ahurei o te Kuratini o Waikato\r\nHe mātāpono whakaū kounga\r\nKa whakaata i te angitū\r\npiki ake e tama e hine\r\nI te ahurei o te Kuratini o Waikato\r\nHe mātāpono whakaū kounga\r\nKa whakaata i te angitū.\r\n \r\nPupuke te hihiri\r\nPupuke te mahara\r\nPupuke te wānanga a te Kore\r\nPupuke te hihiri\r\nPupuke te mahara\r\nPupuke te wānanga a te Kore\r\n \r\nNō ngā kete i pikihia e Tāwhaki\r\nHe wairua, he mauri, he mana, he reo\r\nHe māramatanga, he mātauranga\r\nHe iho o te ahurea\r\n \r\nPupuke te hihiri \r\nPupuke te mahara \r\nPupuke te wānanga a te Kore\r\nPupuke te hihiri\r\nPupuke te mahara\r\nPupuke te wānanga a te Kore\r\nA te kore");
                english_lyrics.setText("Ascend son, daughter\r\nto the pinnacle of Wintec\r\nHold fast to quality principles\r\nthat reflect your successes\r\nAscend son, daughter\r\nto the pinnacle of Wintec\r\nHold fast to quality principles\r\nthat reflect your successes.\r\n \r\nFrom conception the increase\r\nFrom increase the thought\r\nFrom thought the knowledge out of chaos\r\nFrom conception the increase\r\nFrom increase the thought from thought\r\nthe knowledge out of chaos.\r\n \r\nFrom the baskets of knowledge Tāwhaki retrieved\r\ncomes spirit, life-force, power, language,\r\nunderstanding and knowledge\r\nThe isthmus of culture.\r\nFrom conception the increase\r\nFrom increase the thought\r\nFrom thought the knowledge out of chaos\r\nFrom conception the increase\r\nFrom increase the thought from thought\r\nthe knowledge out of chaos.");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.pupuketehihiri_1);
                songChoice = 5;
                break;
            case "I Te Whare Whakapiri":
                songTitle.setText("I Te Whare Whakapiri");
                brief_content.setText("This waiata was written be past Wintec students who came to Wintec to learn Te Reo Māori.\r\nThe song exposes the effects colonization has had on their lives and encourage Wintec to be a pillar by which they and others following can restore what was lost.\r\nIn this instance, it is the language which is the doorway to their cultural inheritance and wellbeing.");
                maori_lyrics.setText("He Māori, tū tangata\r\n \r\nI te whare whakapiri a Tāne\r\nRoto te Kuratini o Waikato\r\nKa puta ngā mamaetanga\r\nRere iho ko ngā roimata\r\nAuē, te arohanui\r\n \r\nHomai, homai taku Māoritanga\r\nWhāngaihia mai tōku reo tuku iho\r\nHe kaiwhakaoho i tōku wairua\r\n \r\nKua ngaro te korekore\r\nPuāwai ana ko ahau\r\nHe Māori tū tangata");
                english_lyrics.setText("I am Māori\r\nIn this cultural house\r\nthis is within Waikato Institute of Technology\r\nwe feel the sorrow\r\nThe tears, the flow\r\nand the love.\r\nGive back our cultural inheritance\r\nNurture the development of my language\r\nthat awakens my spirit.\r\nThe nothingness has disappeared\r\nI begin to bloom\r\nI am Māori\r\nI am Māori");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.itewhare_1);
                songChoice = 6;
                break;
            case "Pua Te Kōwhai":
                songTitle.setText("Pua Te Kōwhai");
                brief_content.setText("This waiata is suitable for any occasion and is still used both in and out of Wintec. The song jumps around as it follows the flight path of the Tui.\r\n \r\nHistorically, the hill that Wintec sits on was part of the lands designated ‘mara’ or gardening land, thus, the name Te Kōpū Mānia O Kirikiriroa – The Smooth Belly (fertile lands) of Kirikiriroa (known presently as Hamilton).\r\n \r\nWaikato-Taniui, Ngāti Hauā and Ngāti Wairere are the mana whenua (known affiliated tribes) of this land.");
                maori_lyrics.setText("Pua te kōwhai\r\nNgawhā te kōrari\r\nHe tohu kōanga \r\nTau mai e Tui ki tō kāpunipuni\r\nHonihoni, kohikohi\r\nHei oranga, hei rongoā\r\nPania te kiri ki te kōwhai kura\r\nE Tui haurangi i te tākoha o te Atua\r\nRere atu, hoki mai\r\nParea te ua kōwhai\r\nKa whiti mai te rā e");
                english_lyrics.setText("The kowhai blooms\r\nBursts open in readiness for plucking\r\na sign of spring\r\nThe Tui begin to assemble\r\nTo nibble to gather\r\nFor life and well-being\r\nThe stain of the kowhai touches\r\nWhile Tui get drunk on the nectar of god\r\nFlittering away, returning\r\nA display of yellow\r\nAs the sun shines.");
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.puatekowhai_1);
                songChoice = 7;
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
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    // display song duration timer
    public void playCycle() {
        seekBar.setProgress(mediaPlayer.getCurrentPosition());
        String cTime = createTimeLabel(mediaPlayer.getCurrentPosition());
        curTime.setText(cTime);

        if (mediaPlayer.isPlaying()) {
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
