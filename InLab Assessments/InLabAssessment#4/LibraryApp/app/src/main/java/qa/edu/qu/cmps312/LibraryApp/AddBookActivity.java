package qa.edu.qu.cmps312.LibraryApp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import qa.edu.qu.cmps312.loginandregistration.R;

public class AddBookActivity extends AppCompatActivity {
    private TextView goBack;
    private Button addBookBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //todo add the user information to the database
        setContentView(R.layout.activity_registeration);
        goBack = findViewById(R.id.goBackLnk);
        addBookBtn = findViewById(R.id.addBookBtn);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addBookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Add A book and clear field", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
