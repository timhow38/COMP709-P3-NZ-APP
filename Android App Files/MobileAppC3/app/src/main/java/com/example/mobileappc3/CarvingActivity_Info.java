package com.example.mobileappc3;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CarvingActivity_Info extends AppCompatActivity {
    TextView carvName_msg, carvEngName_msg, carvDesc_msg, carvImageName_msg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carvingActivity);

        carvName_msg = findViewById(R.id.carvingName);
        carvEngName_msg = findViewById(R.id.carvingEngName);
        carvDesc_msg = findViewById(R.id.carvingDesc);
        carvImageName_msg = findViewById(R.id.carvingImage);

        //Creates Intent
        Intent intent = getIntent();

        //Intent Details
        String carvName = intent.getStringExtra("carv_name");
        String carvEngName = intent.getStringExtra("carv_eng_name");
        String carvDesc = intent.getStringExtra("carv_desc");
        String carvImageName = intent.getStringExtra("carv_image");

        carvName_msg.setText(carvName);
        carvEngName_msg.setText(carvEngName);
        carvDesc_msg.setText(carvDesc);
        carvImageName_msg.setText(carvImageName);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
