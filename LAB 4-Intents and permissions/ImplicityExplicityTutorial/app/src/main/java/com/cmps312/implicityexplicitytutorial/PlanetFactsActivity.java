package com.cmps312.implicityexplicitytutorial;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PlanetFactsActivity extends AppCompatActivity {


    ImageView planetImage;
    private ArrayList<Planet> planets;
    private int currentPlanet = 0;
    private TextView factsTv;
    private int[] planetImages = {
            R.drawable.mercury,
            R.drawable.venus,
            R.drawable.earth,
            R.drawable.mars,
            R.drawable.jupiter,
            R.drawable.saturn,
            R.drawable.uranus,
            R.drawable.neptune
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_facts);
        planets = Planet.populatePlanetData();

        factsTv = findViewById(R.id.factsTv);
        planetImage = findViewById(R.id.planetImage);

        currentPlanet = getIntent().getExtras().getInt("currentPlanet");

        loadPlanet();


    }

    void loadPlanet() {

    }


    public void onNextBtnClicked(View view) {

    }

    public void sendEmail(View view) {

    }
}
