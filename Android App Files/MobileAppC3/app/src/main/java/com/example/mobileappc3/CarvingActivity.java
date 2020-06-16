package com.example.mobileappc3;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CarvingActivity extends AppCompatActivity implements CarvingAdapter.onCarvingListener {
    private ArrayList<Carving> mCarving = new ArrayList<>();
    private CarvingAdapter mCarvingAdapter;

    @Override
    public void onCarvingClick(int position) {
        Carving carving = mCarving.get(position);
        Intent intent = new Intent(this, CarvingActivity_Info.class);
        intent.putExtra("carv_name", mCarving.get(position).getCarvName());
        intent.putExtra("carv_eng_name", mCarving.get(position).getCarvEngName());
        intent.putExtra("carv_desc", mCarving.get(position).getCarvDesc());
        intent.putExtra("carv_image", mCarving.get(position).getCarvImageName());
        startActivity(intent);
    }
}