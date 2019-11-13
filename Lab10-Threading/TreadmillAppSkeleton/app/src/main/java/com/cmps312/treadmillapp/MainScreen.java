package com.cmps312.treadmillapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.ref.WeakReference;

public class MainScreen extends AppCompatActivity {

    private int pics[] = {
            R.drawable.s1,
            R.drawable.s2,
            R.drawable.s3,
            R.drawable.s4,
            R.drawable.s5,
            R.drawable.s6,
    };
    int index = 0;

    private Button runnableBtn;
    private Button asyncBtn;

    private ImageView runnerImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runnerImage = findViewById(R.id.runner_img);
        runnableBtn = findViewById(R.id.runnable_btn);

        asyncBtn = findViewById(R.id.async_btn);
    }


    public void clickMe(View view) {
       
        switch (view.getId()) {
            case R.id.runnable_btn:
                runInRunnable(100);
                break;
            case R.id.async_btn:
//                new RunUsingAsync(this).execute(100);
                break;
        }
    }

    private void runInRunnable(final int speed) {
        runnableBtn.setEnabled(false);
        asyncBtn.setEnabled(false);
    }

    public void stopRunning(View view) {

        runnableBtn.setEnabled(true);
        asyncBtn.setEnabled(true);

    }



}
