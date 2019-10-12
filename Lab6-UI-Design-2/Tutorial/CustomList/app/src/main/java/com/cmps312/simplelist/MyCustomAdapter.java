package com.cmps312.simplelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

class MyCustomAdapter extends ArrayAdapter<Country> {

    public MyCustomAdapter(@NonNull Context context, @NonNull ArrayList<Country> countries) {
        super(context, 0, countries);
    }

    private static class ViewHolder{
        ImageView flagImage;
        TextView countryTv;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder;

        //first time this view is null so inflate the layout
        if(convertView==null){
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item, parent, false);

            holder = new ViewHolder();
            holder.flagImage = convertView.findViewById(R.id.flag_img);
            holder.countryTv = convertView.findViewById(R.id.country_name_tv);

            //pass the holder as a tag to the converview

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }


        //add the data to the views
        holder.flagImage.setImageResource(getItem(position).getFlag());
        holder.countryTv.setText(getItem(position).getName());

        return convertView;
    }
}













