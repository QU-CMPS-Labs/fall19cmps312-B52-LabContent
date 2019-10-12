package com.cmps312.simplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] countries = {"Qatar", "Germany", "Russia"};
    ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1. Find the view
        listView = findViewById(R.id.list);

        //2. Create an adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);

        //step 3. set the adapter
        listView.setAdapter(adapter);

        //Step 4. Listen to user clicks
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent = new Intent(MainActivity.this, CountryDetailActivity.class);
               //send some info
               intent.putExtra("country", countries[position]);

               startActivity(intent);
           }
       });

    }
}
