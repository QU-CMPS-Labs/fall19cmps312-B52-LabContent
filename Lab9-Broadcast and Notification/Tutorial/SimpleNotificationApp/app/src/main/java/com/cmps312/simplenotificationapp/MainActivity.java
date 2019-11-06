package com.cmps312.simplenotificationapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {


    EditText bodyTextEdt;
    EditText titleTextEdt;
    int mainChannelCounter =0;
    int secondaryChannelCounter =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bodyTextEdt = findViewById(R.id.body_edt);
        titleTextEdt = findViewById(R.id.title_edt);
    }

    public void postSecondaryChannel(View view) {


    }

    public void postMainChannel(View view) {

    }
}















