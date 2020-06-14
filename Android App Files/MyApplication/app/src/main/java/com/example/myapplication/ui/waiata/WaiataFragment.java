package com.example.myapplication.ui.waiata;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;

public class WaiataFragment extends Fragment {

    private WaiataViewModel waiataViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        waiataViewModel =
                ViewModelProviders.of(this).get(WaiataViewModel.class);
        View root = inflater.inflate(R.layout.fragment_waiata, container, false);
        final TextView textView = root.findViewById(R.id.nav_songs);
        waiataViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}