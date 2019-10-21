package com.cmps312.bmicalc;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CurrencyConverter extends AppCompatActivity {

    private EditText qrEdt;
    private EditText usdEdt;
    private Button convertBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_converter);
        qrEdt = findViewById(R.id.qr_edt);
        usdEdt = findViewById(R.id.usd_edt);
        convertBtn = findViewById(R.id.convert_btn);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double qrNum = Double.parseDouble(qrEdt.getText().toString());
                double usdNum = qrNum/3.65;
                usdEdt.setText(usdNum+"");
            }
        });
    }
}
