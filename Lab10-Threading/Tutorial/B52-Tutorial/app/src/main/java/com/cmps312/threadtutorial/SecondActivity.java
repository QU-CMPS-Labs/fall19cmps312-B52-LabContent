package com.cmps312.threadtutorial;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.ref.WeakReference;

public class SecondActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.textView);

    }

    public void startThread(View view) {
        MyDownloaderAsync myDownloaderAsync = new MyDownloaderAsync(this);
        myDownloaderAsync.execute(1000);
    }


    static class MyDownloaderAsync extends AsyncTask<Integer, Integer, String> {
        WeakReference<SecondActivity> activityWeakReference;

        public MyDownloaderAsync(SecondActivity activity) {
            activityWeakReference = new WeakReference<>(activity);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            SecondActivity activity = activityWeakReference.get();
            if (activity != null)
                activity.textView.setText("Started the downloading");
        }

        @Override
        protected String doInBackground(Integer... integers) {


            for (int i = 0; i <= 10; i++) {
                SecondActivity activity = activityWeakReference.get();
                if(activity == null){
                    return "terminated due to activity";
                }

                publishProgress(i, 10);

                try {
                    Thread.sleep(integers[0]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return "Finished the downloading";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            SecondActivity activity = activityWeakReference.get();
            if (activity != null)
                activity.progressBar.setProgress(values[0] * values[1]);

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            SecondActivity activity = activityWeakReference.get();
            if (activity != null)
                activity.textView.setText(s);
        }
    }
}













