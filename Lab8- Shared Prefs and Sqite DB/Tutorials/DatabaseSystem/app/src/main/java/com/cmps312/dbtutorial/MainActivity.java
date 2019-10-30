package com.cmps312.dbtutorial;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cmps312.dbtutorial.models.Student;


public class MainActivity extends AppCompatActivity {


    private TextView resultTv;
    private EditText nameEdt;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        resultTv = findViewById(R.id.result_tv);
        nameEdt = findViewById(R.id.nameEdt);
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.add_btn:

                break;

                //sdfad
            case R.id.update_btn:

                break;

            case R.id.delete_btn:
                break;

            case R.id.getall_btn:
                Toast.makeText(this, "get all", Toast.LENGTH_SHORT).show();
                break;

            case R.id.search_btn:

                Toast.makeText(this,  "search", Toast.LENGTH_SHORT).show();
                break;

            default:
                Toast.makeText(this, "NO", Toast.LENGTH_SHORT).show();
        }
    }
}













