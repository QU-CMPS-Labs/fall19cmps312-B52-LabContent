package com.cmps312.simplelist;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CountryDetailActivity extends AppCompatActivity {

    TextView countryTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

        Country country = getIntent().getParcelableExtra("country");

        countryTv = findViewById(R.id.country_tv);
        countryTv.setText(country.getName());
    }
}
