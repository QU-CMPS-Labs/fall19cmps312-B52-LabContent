package com.cmps312.dbtutorial;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cmps312.dbtutorial.models.Student;
import com.cmps312.dbtutorial.repos.StudentDao;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private StudentDao dao;
    private TextView resultTv;
    private EditText nameEdt;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dao = new StudentDao(this);

        resultTv = findViewById(R.id.result_tv);
        nameEdt = findViewById(R.id.nameEdt);
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.add_btn:
                student = new Student(nameEdt.getText().toString());
                dao.addStudent(student);
                break;

            case R.id.update_btn:

                break;

            case R.id.delete_btn:
                break;

            case R.id.getall_btn:
                ArrayList<Student> students = dao.getAllStudent();
                String content = "";
                if (students.size() > 0)
                    for (Student student : students) {
                        content += student.getName();
                    }
                resultTv.setText(content);
                break;

            case R.id.search_btn:
                student = dao.getStudent(nameEdt.getText().toString());
                if (student != null)
                    resultTv.setText(student.getName());
                resultTv.setText("Could not find the student");

                break;

            default:
                Toast.makeText(this, "NO", Toast.LENGTH_SHORT).show();
        }
    }
}













