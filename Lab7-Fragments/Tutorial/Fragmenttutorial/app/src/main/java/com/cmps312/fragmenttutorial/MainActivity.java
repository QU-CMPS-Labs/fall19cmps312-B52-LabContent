package com.cmps312.fragmenttutorial;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements MyFragmentB.onMyFragmentBInteraction {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declare

        MyFragmentB fragmentB = MyFragmentB.newInstance("Abdulahi");

        //get the fragment manger to inject it

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.place_holder, fragmentB)
                .commit();

    }

    @Override
    public void sayHello(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
