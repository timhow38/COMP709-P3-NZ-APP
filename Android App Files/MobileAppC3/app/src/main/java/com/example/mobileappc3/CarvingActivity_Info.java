package com.example.mobileappc3;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CarvingActivity_Info extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carving_info);

        //Creates Intent
        Intent intent = getIntent();

        //Gets parcelable using "carving_item" from CarvingActivity.class
        Carving carving = intent.getParcelableExtra("carving_item");

        //Sets information from parcelable
        int carving_image = carving.getCarvImageName();
        String carving_name = carving.getCarvName();
        String carving_desc = carving.getCarvDesc();

        //Sets id from XML layout
        ImageView carving_imageView = findViewById(R.id.IM_marae);
        TextView carving_name_textView = findViewById(R.id.TV_title);
        TextView carving_desc_textView = findViewById(R.id.lyric1);

        //Sets images and text from database into XML id
        carving_imageView.setImageResource(carving_image);
        carving_name_textView.setText(carving_name);
        carving_desc_textView.setText(carving_desc);
    }
}
