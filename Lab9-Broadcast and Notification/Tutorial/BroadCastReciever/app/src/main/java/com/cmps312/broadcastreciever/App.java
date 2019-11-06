package com.cmps312.broadcastreciever;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import java.util.ArrayList;

public class App extends Application {
    public static final String MAIN_CHANNEL = "MainChannel";
    public static final String SECONDARY_CHANNEL = "SecondaryChannel";

    private NotificationManager notificationManager;

    @Override
    public void onCreate() {
        super.onCreate();
        //create our channels

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel mainChannel = new NotificationChannel(MAIN_CHANNEL, "main channel",
                    NotificationManager.IMPORTANCE_HIGH);

            mainChannel.setDescription("This is the main channel");


            NotificationChannel secondChannel =
                    new NotificationChannel(SECONDARY_CHANNEL, "second channel",
                            NotificationManager.IMPORTANCE_LOW);

            secondChannel.setDescription("This is the secondary channel");

            ArrayList<NotificationChannel> channels = new ArrayList<>();
            channels.add(mainChannel);
            channels.add(secondChannel);

            notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannels(channels);
        }

//        notificationManager.createNotificationChannel(mainChannel);
//        notificationManager.createNotificationChannel(secondChannel);
    }
}















