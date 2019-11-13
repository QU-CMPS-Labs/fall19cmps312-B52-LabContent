package com.cmps312.threadtutorial;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);

        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                tv.setText("I was called" + msg.arg1);
            }
        };
    }


    public void startThread(View view) {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {

                    final int current = i;

                    //3rd way
                    Message message = new Message();
                    message.arg1 = current;

                    handler.sendMessage(message);


                    //First way
//                    tv.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            tv.setText(String.valueOf(current));
//                        }
//                    });

                    //2nd way
//
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            tv.setText(String.valueOf(current));
//
//                        }
//                    });


                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
    }
}
