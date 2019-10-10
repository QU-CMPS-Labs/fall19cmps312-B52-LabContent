package com.cmps312.simplelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listView;
    private ArrayList<Student> students;

    private MyRecyclerView adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the data
        students = Student.getStudents();

        //1. Find the list
        listView = findViewById(R.id.list);

        //2. Create the adapter
        adapter = new MyRecyclerView(this, students);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);

        //3. add the adapter to the listview
        listView.setLayoutManager(manager);
        listView.setAdapter(adapter);

        //4. Listen to events /Item clicks of the list

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
//                intent.putExtra("student", students.get(position));
//                startActivity(intent);
//            }
//        });
    }
}





















