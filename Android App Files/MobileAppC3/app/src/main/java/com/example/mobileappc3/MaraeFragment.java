package com.example.mobileappc3;

import android.content.Intent;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MaraeFragment extends Fragment {

    CardView carving;
    CardView protocols;
    CardView marae_info;


    public MaraeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_marae, container, false);
        carving = (CardView) view.findViewById(R.id.carvings_btn);
        protocols = (CardView) view.findViewById(R.id.protocols_btn);
        marae_info = (CardView) view.findViewById(R.id.marae_info_btn);


        //OnClickListener Methods
        carving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CarvingActivity.class);
                startActivity(intent);
            }
        });

        protocols.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Protocols2.class);
                startActivity(intent);
            }
        });

        marae_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MaraeInfo2.class);
                startActivity(intent);
            }
        });


        return view;
    }
}
