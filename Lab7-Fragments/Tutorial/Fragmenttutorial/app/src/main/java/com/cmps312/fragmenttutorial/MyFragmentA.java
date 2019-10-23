package com.cmps312.fragmenttutorial;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


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
        final EditText inputEdt;
        Button okBtn;

        View rootView = inflater.inflate(R.layout.fragment_a, container, false);

        inputEdt = rootView.findViewById(R.id.input_edt);
        okBtn = rootView.findViewById(R.id.ok_btn);


        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), inputEdt.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

}
