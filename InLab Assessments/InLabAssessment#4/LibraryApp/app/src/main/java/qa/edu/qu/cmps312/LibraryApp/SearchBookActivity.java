package qa.edu.qu.cmps312.LibraryApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import qa.edu.qu.cmps312.loginandregistration.R;

public class SearchBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.addNewBook:

                //todo Check if the book exit then show the details
                //todo if the book does not exit then tell the user the book does not exit
                intent = new Intent(SearchBookActivity.this,
                        AddBookActivity.class);
                startActivity(intent);
                break;
            case R.id.searchBtn:
                intent = new Intent(SearchBookActivity.this,
                        MainActivity.class);
                startActivity(intent);
                break;

        }
    }
}

