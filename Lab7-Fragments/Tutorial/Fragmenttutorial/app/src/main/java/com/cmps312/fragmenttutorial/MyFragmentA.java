package com.cmps312.fragmenttutorial;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragmentA extends Fragment {


    public MyFragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        TextView textView;

        View rootView = inflater.inflate(R.layout.fragment_a, container, false);

        textView = rootView.findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(, "I was clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

}
