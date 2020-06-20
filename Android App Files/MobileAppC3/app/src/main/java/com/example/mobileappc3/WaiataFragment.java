package com.example.mobileappc3;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class WaiataFragment extends Fragment implements View.OnClickListener {

    ImageButton about;

    public WaiataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_waiata, container, false);
        about = (ImageButton) view.findViewById(R.id.about);
        about.setOnClickListener(this);

        CardView card1 = (CardView) view.findViewById(R.id.card1);
        CardView card2 = (CardView) view.findViewById(R.id.card2);
        CardView card3 = (CardView) view.findViewById(R.id.card3);
        CardView card4 = (CardView) view.findViewById(R.id.card4);
        CardView card5 = (CardView) view.findViewById(R.id.card5);
        CardView card6 = (CardView) view.findViewById(R.id.card6);
        CardView card7 = (CardView) view.findViewById(R.id.card7);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
        card7.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.about:
                intent = new Intent(getActivity(), About.class);
                startActivity(intent);
                break;
            case R.id.card1:
                intent = new Intent(getActivity(), WaiataPlayer.class);
                intent.putExtra("card", 1);
                startActivity(intent);
                break;
            case R.id.card2:
                intent = new Intent(getActivity(), WaiataPlayer.class);
                intent.putExtra("card", 2);
                startActivity(intent);
                break;
            case R.id.card3:
                intent = new Intent(getActivity(), WaiataPlayer.class);
                intent.putExtra("card", 3);
                startActivity(intent);
                break;
            case R.id.card4:
                intent = new Intent(getActivity(), WaiataPlayer.class);
                intent.putExtra("card", 4);
                startActivity(intent);
                break;
            case R.id.card5:
                intent = new Intent(getActivity(), WaiataPlayer.class);
                intent.putExtra("card", 5);
                startActivity(intent);
                break;
            case R.id.card6:
                intent = new Intent(getActivity(), WaiataPlayer.class);
                intent.putExtra("card", 6);
                startActivity(intent);
                break;
            case R.id.card7:
                intent = new Intent(getActivity(), WaiataPlayer.class);
                intent.putExtra("card", 7);
                startActivity(intent);
                break;
        }
    }
}
