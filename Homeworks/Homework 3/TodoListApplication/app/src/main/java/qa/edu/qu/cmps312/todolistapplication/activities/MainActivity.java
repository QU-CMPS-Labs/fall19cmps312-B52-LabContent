package qa.edu.qu.cmps312.todolistapplication.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import qa.edu.qu.cmps312.todolistapplication.R;
import qa.edu.qu.cmps312.todolistapplication.adapters.CustomAdapter;
import qa.edu.qu.cmps312.todolistapplication.fragments.DialogFragment;
import qa.edu.qu.cmps312.todolistapplication.fragments.DialogFragment.DialogFragmentInteraction;
import qa.edu.qu.cmps312.todolistapplication.model.Todo;

public class MainActivity extends AppCompatActivity implements DialogFragmentInteraction, CustomAdapter.AdapterInteraction {

    private FloatingActionButton addBtn;
    private static final String TAG = "MainActivity";
    private ArrayList<Todo> todos;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private Boolean mPane = false;
    private int currentEditPosition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {
            mPane = true;
        } else
            mPane = false;

        addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = DialogFragment.newInstance();

                if (mPane) {
                    findViewById(R.id.fragment_container).setVisibility(View.VISIBLE);
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.fragment_container, dialogFragment)
                            .commit();
                } else
                    dialogFragment.show(getSupportFragmentManager(), "MY_DIALOG");
            }
        });


        adapter = new CustomAdapter(this, getAllTodo());

        recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }


    public void dismissFragment() {
        if (mPane) {
            findViewById(R.id.fragment_container).setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.clear_todo_list:
                new AlertDialog.Builder(this)
                        .setIcon(R.drawable.ic_warning_red_24dp)
                        .setTitle(R.string.delete_all_title)
                        .setMessage(R.string.delete_all_body_message)
                        .setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                deleteAllTodo();
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if(intent.getExtras()!=null) {
            currentEditPosition = intent.getExtras().getInt("position");
            updateTodo((Todo) intent.getExtras().getParcelable(getString(R.string.Todo)));

        }
        adapter.notifyDataSetChanged();
    }

    // Todo-1 - add the newly added todo to the database
    @Override
    public void addTodo(Todo todo) {
        todos.add(todo);
        adapter.notifyDataSetChanged();
        dismissFragment();    //this will remove the dialog from screen

    }

    // Todo-2 -update the selected todo in the database
    @Override
    public void updateTodo(Todo todo) {
        todos.set(currentEditPosition, todo);
        adapter.notifyDataSetChanged();
        dismissFragment();    //this will remove the dialog from screen

    }

    // Todo-3 -delete the selected todo from the database
    @Override
    public void deleteTodo(final int position) {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_warning_red_24dp)
                .setTitle(R.string.delete_todo_title)
                .setMessage(getString(R.string.delete_body_message)
                        + todos.get(position).getTitle() + "'")
                .setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        todos.remove(position);
                        Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                        adapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }

    // Todo-4 -delete all the todos from the database
    private void deleteAllTodo() {
        todos.clear();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void editToDoList(int position, Todo todo) {
        currentEditPosition = position;
        if (mPane) {
            findViewById(R.id.fragment_container).setVisibility(View.VISIBLE);
            DialogFragment dialogFragment = DialogFragment
                    .newInstance(todo);

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, dialogFragment)
                    .commit();
        } else {
            Intent intent = new Intent(this, EditActivity.class);
            intent.putExtra("Todo", todo);
            intent.putExtra("position", position);
            startActivity(intent);
        }
    }

    // Todo-5 load all the todos from the database
    public ArrayList<Todo> getAllTodo() {
        todos = new ArrayList<>();
        todos.add(new Todo("Homework", "Not Done", "High", "20/10/2018", "12:00 PM"));
        layoutManager = new LinearLayoutManager(this);
        return todos;
    }

}