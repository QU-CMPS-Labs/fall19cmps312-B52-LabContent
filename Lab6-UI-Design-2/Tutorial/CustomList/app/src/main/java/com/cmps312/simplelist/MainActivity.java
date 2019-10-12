package com.cmps312.simplelist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Country> countries;
    ListView listView;
    MyCustomAdapter  adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //0. let us get the data

        countries = Country.getCountries();

        //1. Find the view
        listView = findViewById(R.id.list);

        //2. Create an adapter
//        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);

        adapter = new MyCustomAdapter(this, countries);

        //step 3. set the adapter
        listView.setAdapter(adapter);

        //Step 4. Listen to user clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, CountryDetailActivity.class);
                //send some info
                intent.putExtra("country", countries.get(position));

                startActivity(intent);
            }
        });

    }
}
