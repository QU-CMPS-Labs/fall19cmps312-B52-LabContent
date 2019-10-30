package com.cmps312.students;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEdt;
    private EditText passwordEdt;

    public static final String USERNAME_KEY = "username";
    public static final String PASWORD_KEY = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEdt = findViewById(R.id.username);
        passwordEdt = findViewById(R.id.password);

    }

    public void registerUser(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(USERNAME_KEY, usernameEdt.getText().toString().toLowerCase());
        editor.putString(PASWORD_KEY, passwordEdt.getText().toString());

        editor.commit();


    }

    //Read from shared preferences
    public void loginUser(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE);

        String savedUserName = sharedPreferences.getString(USERNAME_KEY, "");
        String savedPassword = sharedPreferences.getString(PASWORD_KEY, "");

        if (
                savedPassword.equals(passwordEdt.getText().toString())
                && savedUserName.equals(usernameEdt.getText().toString().toLowerCase()


        )) {


            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to login", Toast.LENGTH_SHORT).show();
        }


    }
}
