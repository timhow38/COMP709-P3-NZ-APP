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

        Carving carving = intent.getParcelableExtra("carving_item");

        int carving_image = carving.getCarvImageName();
        String carving_name = carving.getCarvName();
        String carving_desc = carving.getCarvDesc();

        ImageView carving_imageView = findViewById(R.id.IM_marae);
        carving_imageView.setImageResource(carving_image);
        TextView carving_name_textView = findViewById(R.id.TV_title);
        carving_name_textView.setText(carving_name);
        TextView carving_desc_textView = findViewById(R.id.lyric1);
        carving_desc_textView.setText(carving_desc);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
