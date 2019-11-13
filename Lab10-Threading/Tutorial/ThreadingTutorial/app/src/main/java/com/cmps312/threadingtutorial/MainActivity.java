package com.cmps312.threadingtutorial;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private volatile boolean stopThread = false;

    TextView displayTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayTv = findViewById(R.id.display_tv);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
     //           displayTv.setText("I can access anything here");
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        }, 10);
    }


    public void startThread(View view) {

        stopThread = false;

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    if(stopThread)
                        return;
                    try {
                        Log.d("TAG", "startThread: " + i);
                        final int current = i;

//                        displayTv.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                displayTv.setText(current + "");
//                            }
//                        });

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                displayTv.setText(current + "");
                            }
                        });

                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

    public void stopThread(View view) {
        stopThread=true;
    }
}
