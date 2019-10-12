package com.cmps312.simplelist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


class MyArrayAdapter extends ArrayAdapter<Student> {

    public MyArrayAdapter(Context context, ArrayList<Student> students) {
        super(context, 0, students);
    }

    public static class ViewHolder {
        ImageView profileIMg;
        TextView nameTv;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        ViewHolder holder;
        //if the converview is null I will inflate it
        if (convertView == null) {

            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item, parent, false);

            holder = new ViewHolder();

            holder.profileIMg = convertView.findViewById(R.id.img);
            holder.nameTv = convertView.findViewById(R.id.name_tv);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        //set the data

        holder.profileIMg.setImageResource(getItem(position).getImage());
        holder.nameTv.setText(getItem(position).getName());


        holder.profileIMg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("student", getItem(position));
                getContext().startActivity(intent);
            }
        });
        return convertView;
    }
}



























