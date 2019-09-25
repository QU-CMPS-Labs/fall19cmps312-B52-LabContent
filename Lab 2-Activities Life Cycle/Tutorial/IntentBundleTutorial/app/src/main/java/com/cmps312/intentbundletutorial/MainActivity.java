package com.cmps312.intentbundletutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity-WhatHappened";
    private Button open2Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");
        open2Btn = findViewById(R.id.open2Btn);
        open2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                bundle.putString("score" , 123);

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }


}
