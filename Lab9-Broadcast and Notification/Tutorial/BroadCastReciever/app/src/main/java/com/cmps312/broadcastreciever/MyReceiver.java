package com.cmps312.broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    InteractionInterface anInterface;
    public static final String MY_ACTION = "com.cmps312.broadcastreciever.shout";

    @Override
    public void onReceive(Context context, Intent intent) {

        anInterface = (InteractionInterface) context;
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {

            boolean noConnection = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            if (noConnection) {
                anInterface.update("No Connection Changed");
            } else {
                anInterface.update("Connected to Internet ");
            }
        }


        if (intent.getAction().equals(MY_ACTION)) {
            intent.getBooleanExtra("MyExtra", false);
        }
    }

    interface InteractionInterface {
        void update(String messaeg);
    }


}








