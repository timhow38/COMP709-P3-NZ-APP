package com.example.mobileappc3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainMenu extends AppCompatActivity {

    Fragment waiataFragment = new WaiataFragment();
    Fragment maraeFragment = new MaraeFragment();

    BottomNavigationView btmNavBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //BottomNavigationBar listener
        btmNavBar = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        btmNavBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_songs:
                        btmNavWaiata();
                        break;
                    case R.id.nav_marae:
                        btmNavMarae();
                        break;
                }
                return true;
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.main_menu_fragmentBox, waiataFragment).commit();

    }

    public void btmNavWaiata() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_menu_fragmentBox, waiataFragment).commit();
    }

    public void btmNavMarae() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_menu_fragmentBox, maraeFragment).commit();
    }
}