package com.cmps312.myclosecontacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cmps312.myclosecontacts.adapters.MyAdapter;
import com.cmps312.myclosecontacts.httpRequests.UsersClients;
import com.cmps312.myclosecontacts.models.Result;
import com.cmps312.myclosecontacts.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.cmps312.myclosecontacts.httpRequests.UsersClients.BASE_URL;

public class MainActivity extends AppCompatActivity {

    private MyAdapter adapter ;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ArrayList<User> users;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Toast.makeText(this, "Hi", Toast.LENGTH_SHORT).show();

    }

    public void downloadUsers(View view) {
        //step 1
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //step 2
        UsersClients client = retrofit.create(UsersClients.class);

        //step 3
        Call<Result> call = client.getUsers("5", "json");


        //step 4, is wait for the result
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                Result result = response.body();

                adapter = new MyAdapter(MainActivity.this, result.getUsers());
                recyclerView.setAdapter(adapter);

                Toast.makeText(MainActivity.this, result.getUsers().get(0).getName().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
