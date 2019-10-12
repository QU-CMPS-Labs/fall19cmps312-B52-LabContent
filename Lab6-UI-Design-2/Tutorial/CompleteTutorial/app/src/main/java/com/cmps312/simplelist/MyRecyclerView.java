package com.cmps312.simplelist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.ViewHolder> {

    private Context context ;
    private ArrayList<Student> students ;

    public MyRecyclerView(Context context, ArrayList<Student> students) {
        this.context = context;
        this.students = students;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView profileIMg;
        TextView nameTv;

        public ViewHolder(@NonNull View convertView) {

            super(convertView);
            profileIMg = convertView.findViewById(R.id.img);
            nameTv = convertView.findViewById(R.id.name_tv);

        }
    }


    @NonNull
    @Override
    public MyRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(context)
                .inflate(R.layout.list_item, parent, false);

        return new ViewHolder(convertView);


    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerView.ViewHolder holder, final int position) {
        holder.profileIMg.setImageResource(students.get(position).getImage());
        holder.nameTv.setText(students.get(position).getName());


        holder.profileIMg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("student", students.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}
