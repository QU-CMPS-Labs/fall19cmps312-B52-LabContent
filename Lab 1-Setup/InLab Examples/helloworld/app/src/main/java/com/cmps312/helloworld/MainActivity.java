package com.cmps312.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private Button add;
    private EditText fiistNumberEdt;
    private EditText secondNumberEdt;
    private TextView resultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.addBtn);
        fiistNumberEdt = findViewById(R.id.fristNumberEdt);
        secondNumberEdt = findViewById(R.id.secondNumberEdt);
        resultTv = findViewById(R.id.resultTv);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int firstNum = Integer.parseInt(fiistNumberEdt.getText().toString());
                int secondNum = Integer.parseInt(secondNumberEdt.getText().toString());

                int sum = firstNum + secondNum;
                resultTv.setText(sum + "");

            }
        });

    }

}


