package com.cmps312.bmicalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private Button button;
    private RadioGroup optionList;
    int choice = 0;
    private RadioButton currencyRadio;
    private RadioButton bmiRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        currencyRadio = findViewById(R.id.currency_rbtn);
        bmiRadio = findViewById(R.id.bmi_rbtn);
        optionList = findViewById(R.id.radioGroup);

        loadIcon();

        optionList.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.currency_rbtn:
                        choice = 1;
                        break;
                    case R.id.bmi_rbtn:
                        choice = 2;
                        break;
                    default:
                        choice = 0;
                        break;

                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice == 1) {
                    Intent currencyIntent = new Intent(MainActivity.this, CurrencyConverter.class);
                    startActivity(currencyIntent);
                } else if (choice == 2) {
                    Intent bmiIntent = new Intent(MainActivity.this, BMICalculator.class);
                    startActivity(bmiIntent);
                } else {
                    Toast.makeText(MainActivity.this, "Please choose one", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void loadIcon() {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_HOME |
                ActionBar.DISPLAY_SHOW_TITLE |
                ActionBar.DISPLAY_USE_LOGO);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }

}
