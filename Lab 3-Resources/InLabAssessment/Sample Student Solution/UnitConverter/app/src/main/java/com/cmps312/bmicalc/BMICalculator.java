package com.cmps312.bmicalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BMICalculator extends AppCompatActivity {
    private Button calculateBtn;
    private TextView bmiTv;
    private TextView statusTv;
    private EditText weightEdt;
    private EditText heightEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_calc);
        calculateBtn = findViewById(R.id.button2);
        bmiTv = findViewById(R.id.bmiTv);
        statusTv = findViewById(R.id.statusTv);
        weightEdt = findViewById(R.id.weight_edt);
        heightEdt = findViewById(R.id.height_edt);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double height = Double.parseDouble(heightEdt.getText().toString());
                double weight = Double.parseDouble(weightEdt.getText().toString());
                double bmi=weight/(height*height);
                String status;
                if(bmi<=18.5)
                    status="underweight";
                else if(bmi<=24.9)
                    status="normal weight";
                else if(bmi<=29.9)
                    status="overweight";
                else
                    status="obese";

                bmiTv.setText("Your BMI is "+bmi);
                statusTv.setText("You are "+status);
            }
        });
    }
}
