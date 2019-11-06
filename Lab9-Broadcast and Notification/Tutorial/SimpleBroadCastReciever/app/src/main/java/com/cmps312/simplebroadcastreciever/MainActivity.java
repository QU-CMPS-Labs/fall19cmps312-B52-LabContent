package com.cmps312.simplebroadcastreciever;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements MyBroadcastReceiver.BroadCastInteractionInterface {

    MyBroadcastReceiver receiver;
    TextView connectionStatusTv;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = new MyBroadcastReceiver();
        connectionStatusTv = findViewById(R.id.connection_status);

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

    @Override
    public void showConnectionStatus(String status) {
        connectionStatusTv.setText(status);
    }
}
