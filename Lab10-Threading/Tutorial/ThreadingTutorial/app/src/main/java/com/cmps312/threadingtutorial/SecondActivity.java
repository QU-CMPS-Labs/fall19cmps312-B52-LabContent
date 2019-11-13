package com.cmps312.threadingtutorial;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.ref.WeakReference;

public class SecondActivity extends AppCompatActivity {

    TextView displayTv;
    private volatile boolean isStoped = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void startAsyncThread(View view) {
        isStoped = false;
        DownloadStuffAsync downloadStuffAsync = new DownloadStuffAsync(this);
        downloadStuffAsync.execute(1000);
    }

    public void stopAsyncThread(View view) {
        isStoped = true;
    }

    static class DownloadStuffAsync extends AsyncTask<Integer, Integer, String> {
        private WeakReference<SecondActivity> activityWeakReference;

        public DownloadStuffAsync(SecondActivity context){
            activityWeakReference = new WeakReference<>(context);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            SecondActivity secondActivity = activityWeakReference.get();
            if(secondActivity==null || secondActivity.isFinishing())
                return;
            secondActivity.displayTv = secondActivity.findViewById(R.id.display_tv);
        }

        @Override
        protected String doInBackground(Integer... speeds) {
            SecondActivity secondActivity = activityWeakReference.get();
            for (int i = 0; i < 10; i++) {

                if(secondActivity==null || secondActivity.isFinishing())
                    return null;

                if (secondActivity.isStoped )
                    return "Stopped";

                try {
                    Thread.sleep(speeds[0]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                publishProgress(i);
            }
            return "Done the operation";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            SecondActivity secondActivity = activityWeakReference.get();

            if(secondActivity==null || secondActivity.isFinishing())
                return;

            secondActivity.displayTv.setText(String.valueOf(values[0]));
        }

        @Override
        protected void onPostExecute(String resultFromDoInBackground) {
            SecondActivity secondActivity = activityWeakReference.get();
            if(secondActivity==null || secondActivity.isFinishing())
                return;

            secondActivity.displayTv.setText(resultFromDoInBackground);
        }
    }
}







