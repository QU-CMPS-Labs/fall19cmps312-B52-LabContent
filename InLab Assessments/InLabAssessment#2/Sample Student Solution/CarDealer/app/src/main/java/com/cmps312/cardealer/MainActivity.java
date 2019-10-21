package com.cmps312.cardealer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.exit:
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

}


/*

Arabic translation
 Best Luxury Car Dealer   United Kingdom Branch
     أفضل تاجر سيارات فاخرة \\ فرع المملكة المتحدة

  Exit
  خروج

 */