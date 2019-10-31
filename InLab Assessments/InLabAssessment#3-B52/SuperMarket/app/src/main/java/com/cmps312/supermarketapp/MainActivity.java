package com.cmps312.supermarketapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Todo use the following fields. This are all the fields you need for the project

    private MyRecyclerViewAdapter adapter;
    private ArrayList<Product> products;
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;

    private EditText productNameEdt;
    private EditText sizeEdt;
    private EditText priceEdt;

    private Button addBtn;
    private Button cancelBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Todo this is a dummy data for testing purpose,
        // remove it once you implement the dialog

        products = new ArrayList<>();
        products.add(new Product("Mango Juice" , "Small" , 2));
        products.add(new Product("Banana Juice" , "Large" , 10));

        //TODO : Do not change this code here, just implement addNewContact Method
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewContact();
            }
        });

        //TODO add the recyclerView adapter and manager

        //Todo to add the divider line uncomment this code

        //recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
    }

    //TODO Show the dialog that allows adding new contact
    private void addNewContact() {

        Toast.makeText(this,
                "Congrats, You imported everyting correctly. " +
                        "Now Delete me after you create your custom dialog.",
                Toast.LENGTH_LONG).show();

        //Todo be careful not to mix between
        // product_name_edt [EditText ] with product_name_tv [TextView]
        // when finding the IDs of the edit text view or vice versa


    }

}
