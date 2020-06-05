package com.example.waiatas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.lang.Object;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Items> Items = new ArrayList<>();
        Items.add(new Items(R.drawable.listening, "Title 1"));
        Items.add(new Items(R.drawable.listening, "Title 2"));
        Items.add(new Items(R.drawable.listening, "Title 3"));
        Items.add(new Items(R.drawable.listening, "Title 4"));
    }
}
