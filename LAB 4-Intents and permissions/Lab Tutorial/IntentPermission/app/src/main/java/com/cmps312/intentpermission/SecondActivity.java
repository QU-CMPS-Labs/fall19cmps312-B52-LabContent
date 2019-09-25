package com.cmps312.intentpermission;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class SecondActivity extends AppCompatActivity {

    private static final int PERMISSION_CODE = 100;
    private int score;
    private TextView scoreTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        score = getIntent().getIntExtra("score", 0);
        scoreTv = findViewById(R.id.score_tv);

        scoreTv.setText("" + score);


    }

    @Override
    protected void onNewIntent(Intent intent) {
        score = intent.getIntExtra("score", 0);
        scoreTv.setText("" + score);
        super.onNewIntent(intent);
    }


    public void incrementScore(View view) {

        int currentScore = Integer.parseInt(scoreTv.getText().toString());
        currentScore++;

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("score", currentScore);
        startActivity(intent);
    }

    public void sendEmail(View view) {


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "You have the Permission", Toast.LENGTH_SHORT).show();

            sendTheEmail();
        } else {
            requestUserPermission();
        }
    }

    private void requestUserPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            displayAlertDialog();

        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_CODE);
        }
    }

    private void displayAlertDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Permission Required")
                .setMessage("Please allow this permission because we can not attach the image unless you do so...")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(SecondActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_CODE);

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(SecondActivity.this, "I can not send for you this email", Toast.LENGTH_SHORT).show();
                    }
                }).show();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_CODE);
            } else {
                Toast.makeText(this, "I can not attach without this permission", Toast.LENGTH_SHORT).show();
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void sendTheEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"abdulahi@gmail.com", "alaa@gmail.com", "maria@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "WORLD CUP VOLUNTEER");
        intent.putExtra(Intent.EXTRA_TEXT, "We need you to participate for the world cup....");
        intent.setData(Uri.parse("mailto:"));
        startActivity(Intent.createChooser(intent, "Choose the emailing client"));
    }
}

















