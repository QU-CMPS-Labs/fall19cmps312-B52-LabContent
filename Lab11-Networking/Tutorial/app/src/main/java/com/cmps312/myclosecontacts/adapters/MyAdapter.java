package com.cmps312.myclosecontacts.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cmps312.myclosecontacts.R;
import com.cmps312.myclosecontacts.models.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {

    private Context context;
    private ArrayList<User> users;

    public MyAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.raw_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.email.setText(users.get(position).getEmail());
        holder.name.setText(users.get(position).getName().toString());

        Picasso.get()
                .load(users.get(position).getPicture().getLarge())
                .into(holder.userImage);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class MyViewHolder  extends RecyclerView.ViewHolder{
        ImageView userImage;
        TextView name;
        TextView email;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            userImage = itemView.findViewById(R.id.user_image);
            name = itemView.findViewById(R.id.name_tv);
            email = itemView.findViewById(R.id.email_tv);
        }
    }
}
