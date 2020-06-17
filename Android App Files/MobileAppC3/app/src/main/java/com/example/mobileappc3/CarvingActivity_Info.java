package com.example.mobileappc3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.ByteArrayOutputStream;

public class CarvingActivity_Info extends AppCompatActivity {
    TextView carvName_msg, carvDesc_msg;
    ImageView carvImageName_msg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carving_info);

        carvName_msg = findViewById(R.id.TV_title);
        carvDesc_msg = findViewById(R.id.lyric1);
        carvImageName_msg = findViewById(R.id.IM_marae);

        //Creates Intent
        Intent intent = getIntent();

        //Intent Details
        String carvName = intent.getStringExtra("carv_name");
        String carvDesc = intent.getStringExtra("carv_desc");
        String carvImage = intent.getStringExtra("carv_image");
        int imageID = getResources().getIdentifier("com.example.mobileappc3:drawable/"+ carvImage, null, null);


        carvName_msg.setText(carvName);
        carvDesc_msg.setText(carvDesc);
        carvImageName_msg.setImageResource(imageID);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
