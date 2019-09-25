package com.cmps312.intentpermission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String ACTION_OPEN = "com.cmps312.intentpermission.openSecond";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openSecondActivity(View view) {
        Intent intent = new Intent(MainActivity.ACTION_OPEN);
        intent.putExtra("score", 5);
        startActivity(intent);
    }
}
