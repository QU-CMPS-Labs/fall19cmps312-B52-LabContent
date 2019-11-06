package com.cmps312.broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){

            boolean noConnection = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            if(noConnection){
                Toast.makeText(context, "No Connection Changed", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(context, "Connection", Toast.LENGTH_SHORT).show();
            }
        }


        if(intent.getAction().equals("com.cmps312.broadcastreciever.shout")){
            intent.getBooleanExtra("MyExtra" , false);
        }
    }
}
