package com.cmps312.simplebroadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    private BroadCastInteractionInterface anInterface;

    @Override
    public void onReceive(Context context, Intent intent) {

        anInterface = (BroadCastInteractionInterface) context;

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            boolean isNotConneected = intent
                    .getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY,
                    false);

            if (isNotConneected) {
                anInterface.showConnectionStatus("No connection");
            } else {
                anInterface.showConnectionStatus("Connection is Available");
            }
        }
    }

    interface BroadCastInteractionInterface{
        void showConnectionStatus(String status);
    }
}













