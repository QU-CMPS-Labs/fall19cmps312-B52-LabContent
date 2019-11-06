package com.cmps312.broadcastreciever;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.cmps312.broadcastreciever.App.MAIN_CHANNEL;

public class MainActivity extends AppCompatActivity implements MyReceiver.InteractionInterface {

    int mainCount=0;
    MyReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = new MyReceiver();

    }

    @Override
    protected void onStart() {
        super.onStart();

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        this.registerReceiver(receiver, filter);
    }


    @Override
    protected void onStop() {
        super.onStop();
        this.unregisterReceiver(receiver);
    }

    public void sendMyBroadCast(View view) {
        Intent intent = new Intent("com.cmps312.broadcastreciever.shout");
        intent.putExtra("MyEXTRA" , false);
        sendBroadcast(intent);

    }

    @Override
    public void update(String message) {
        TextView tv = findViewById(R.id.textview);
        tv.setText(message);


        createNotification(message);
    }

    private void createNotification(String message) {

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 101, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationManagerCompat notificationManagerCompat =
                NotificationManagerCompat.from(this);


        //create a notification
        Notification notification = new NotificationCompat
                .Builder(this, MAIN_CHANNEL)
                .setSmallIcon(R.drawable.ic_backup_black_24dp)
                .setContentTitle("Connection Notification")
                .setContentIntent(pendingIntent)
                .setContentText(message)
                .setAutoCancel(true)
                .build();


        notificationManagerCompat.notify(mainCount++, notification);


    }
}













