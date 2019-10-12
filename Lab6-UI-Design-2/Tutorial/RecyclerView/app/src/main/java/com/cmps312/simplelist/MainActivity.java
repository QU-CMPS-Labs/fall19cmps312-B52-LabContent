package com.cmps312.simplelist;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Country> countries;
    RecyclerView recyclerView;

    MyRecyclerAdapter  adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //0. let us get the data

        countries = Country.getCountries();

        //1. Find the view
        recyclerView = findViewById(R.id.recycler_view);

        //step 2. Create the adapter and layout manager
        adapter = new MyRecyclerAdapter(this, countries);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        GridLayoutManager linearLayoutManager = new GridLayoutManager(this, 2);

        //step 3. set the adapter and layout manager
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


    }
}







