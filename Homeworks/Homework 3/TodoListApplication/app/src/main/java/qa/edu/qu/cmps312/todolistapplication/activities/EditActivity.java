package qa.edu.qu.cmps312.todolistapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import qa.edu.qu.cmps312.todolistapplication.R;
import qa.edu.qu.cmps312.todolistapplication.fragments.DialogFragment;
import qa.edu.qu.cmps312.todolistapplication.model.Todo;

public class EditActivity extends AppCompatActivity implements DialogFragment.DialogFragmentInteraction {

    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        frameLayout = findViewById(R.id.fragment_container);

        DialogFragment dialogFragment = DialogFragment
                .newInstance((Todo) getIntent().getExtras().getParcelable("Todo"));

        getSupportFragmentManager()
                .beginTransaction()
                .add(frameLayout.getId(), dialogFragment)
                .commit();
    }

    @Override
    public void updateTodo(Todo todo) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("Todo", todo);
        intent.putExtra("position", getIntent().getExtras().getInt("position"));
        startActivity(intent);
        finish();
    }

    @Override
    public void addTodo(Todo todo) {

    }

    @Override
    public void dismissFragment() {
        finish();
    }
}
