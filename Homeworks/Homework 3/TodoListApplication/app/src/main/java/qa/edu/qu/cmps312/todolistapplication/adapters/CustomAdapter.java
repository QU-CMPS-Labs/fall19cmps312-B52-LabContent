package qa.edu.qu.cmps312.todolistapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.Build;
import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import qa.edu.qu.cmps312.todolistapplication.R;
import qa.edu.qu.cmps312.todolistapplication.model.Todo;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<Todo> todos;
    private Context context;
    private AdapterInteraction interaction;

    public CustomAdapter(Context context, ArrayList<Todo> todos) {
        this.todos = todos;
        this.context = context;
        try {
            if (!(context instanceof AdapterInteraction)) throw new AssertionError();
            interaction = (AdapterInteraction) context;
        } catch (AssertionError e) {

        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTv;

        private TextView priorityTv;
        private TextView timeTv;
        private TextView dateTv;
        private CheckBox completedCb;
        private ImageView editImg;
        private ImageView syncImg;
        private ImageView deleteImg;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            titleTv = itemView.findViewById(R.id.title_tv);
            completedCb = itemView.findViewById(R.id.completed_cb);
            priorityTv = itemView.findViewById(R.id.priority_tv);
            timeTv = itemView.findViewById(R.id.time_tv);
            dateTv = itemView.findViewById(R.id.date_tv);
            dateTv = itemView.findViewById(R.id.date_tv);
            editImg = itemView.findViewById(R.id.edit_img);
            syncImg = itemView.findViewById(R.id.sync_img);
            deleteImg = itemView.findViewById(R.id.delete_img);

        }
    }

    public interface AdapterInteraction {
        void deleteTodo(int position);
        void editToDoList(int position, Todo todo);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.row_design, viewGroup, false);


        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        viewHolder.titleTv.setText(todos.get(i).getTitle());
        viewHolder.completedCb.setChecked(todos.get(i).getStatus().equals("Done"));
        if (viewHolder.completedCb.isChecked()) {
            viewHolder.itemView.setBackgroundColor(Color.GRAY);
            viewHolder.deleteImg.setVisibility(View.VISIBLE);
            viewHolder.editImg.setVisibility(View.GONE);
        }
        viewHolder.priorityTv.setText(todos.get(i).getPriority());
        viewHolder.timeTv.setText(todos.get(i).getTime());
        viewHolder.dateTv.setText(todos.get(i).getDate());

        viewHolder.editImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interaction.editToDoList(i, todos.get(i));
            }
        });

        viewHolder.syncImg.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                String[] dateSplit = todos.get(i).getDate().split("/");
                String[] timeSplit = todos.get(i).getTime().split(":");

                Calendar beginTime = Calendar.getInstance();

                beginTime.set(Integer.parseInt(dateSplit[2]),
                        Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[0]),
                        Integer.parseInt(timeSplit[0]), Integer.parseInt(dateSplit[1]));
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI)
                        .putExtra(CalendarContract.Events.TITLE, todos.get(i).getTitle());

                context.startActivity(intent);
            }
        });
        viewHolder.deleteImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interaction.deleteTodo(i);
            }
        });


        viewHolder.completedCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (isChecked) {
                    viewHolder.itemView.setBackgroundColor(Color.GRAY);
                    viewHolder.deleteImg.setVisibility(View.VISIBLE);
                    viewHolder.editImg.setVisibility(View.GONE);

                } else {
                    viewHolder.itemView.setBackgroundColor(Color.WHITE);
                    viewHolder.deleteImg.setVisibility(View.GONE);
                    viewHolder.editImg.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return todos.size();
    }
}
