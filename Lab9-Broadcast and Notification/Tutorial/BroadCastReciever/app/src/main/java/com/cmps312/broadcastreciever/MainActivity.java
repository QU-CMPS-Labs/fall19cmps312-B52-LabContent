package com.cmps312.broadcastreciever;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity  {

    int mainCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    public void sendMyBroadCast(View view) {


    }

}













