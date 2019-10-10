package com.cmps312.simplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Student> students;

    private ArrayAdapter<Student> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the data
        students = Student.getStudents();

        //1. Find the list
        listView = findViewById(R.id.list);

        //2. Create the adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, students);

        //3. add the adapter to the listview
        listView.setAdapter(adapter);

        //4. Listen to events /Item clicks of the list

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("student", students.get(position));
                startActivity(intent);
            }
        });
    }
}





















