package com.cmps312.supermarketapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


//TODO implement the recycler View adapter by extending the correct classes
public class MyRecyclerViewAdapter  {

    private Context context;
    private ArrayList<Product> products;
    private MyRecyclerViewAdapter adapter;

    public MyRecyclerViewAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
        this.adapter = this;
    }
}
