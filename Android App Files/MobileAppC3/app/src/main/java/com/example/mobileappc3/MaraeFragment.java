package com.example.mobileappc3;

import android.content.Intent;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class MaraeFragment extends Fragment {

    CardView carving;

    public MaraeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_marae, container, false);
        carving = (CardView) view.findViewById(R.id.carvings_btn);

        //OnClickListener Methods
        carving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CarvingActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
