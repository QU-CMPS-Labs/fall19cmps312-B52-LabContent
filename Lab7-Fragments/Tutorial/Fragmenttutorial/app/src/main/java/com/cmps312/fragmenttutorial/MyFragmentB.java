package com.cmps312.fragmenttutorial;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragmentB extends Fragment {

    public static final String ARGS_NAME = "name";
    private String name;

    public MyFragmentB() {
        // Required empty public constructor
    }

    public static MyFragmentB newInstance(String name) {

        Bundle args = new Bundle();
        args.putString(ARGS_NAME, name);

        MyFragmentB fragment = new MyFragmentB();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = getArguments().getString(ARGS_NAME);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_b, container, false);

        TextView textView = rootView.findViewById(R.id.textView2);
        textView.setText(textView.getText().toString() + " - " +name);
        return rootView;
    }

    inter

}
