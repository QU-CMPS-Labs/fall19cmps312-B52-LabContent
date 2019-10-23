package com.cmps312.fragmenttutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declare

        MyFragmentB fragmentB = MyFragmentB.newInstance("Abdulahi");

        //get the fragment manger to inject it

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.place_holder, fragmentB)
                .commit();

    }
}
