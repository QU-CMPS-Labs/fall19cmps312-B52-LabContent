package com.cmps312.simplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    Student student;
    ImageView profileImg;
    TextView nameTv;
    TextView bioTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        student = getIntent().getParcelableExtra("student");

        profileImg = findViewById(R.id.profile_pic);
        nameTv = findViewById(R.id.name_tv);
        bioTv = findViewById(R.id.bio_tv);

        profileImg.setImageResource(student.getImage());
        nameTv.setText(student.getName());
        bioTv.setText(student.getBio());

    }
}
