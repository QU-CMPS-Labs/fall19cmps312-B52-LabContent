package qa.edu.qu.cmps312.resourcesdemo;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // String chapters[] = getStringArray(R.array.chapters_array);


        String chapters[] = getResources().getStringArray(R.array.chapters_array);

        //Concatenating  the array to display it on a single TextView
        String chaptersConcat = "\n";
        for (String chapter : chapters
                ) {
            chaptersConcat += chapter + "\n";
        }

        TextView chaptersTv = (TextView) findViewById(R.id.chapters);
        chaptersTv.setText(chaptersConcat);


        //Programmatically changing background Image using tiles

        /*
        Bitmap bmp = BitmapFactory.decodeResource(getResources(),
                R.drawable.texture);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bmp);
        bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT,
                 Shader.TileMode.REPEAT);
        LinearLayout main_layout = (LinearLayout) findViewById(R.id.main_layout);

        main_layout.setBackground(bitmapDrawable);
        */

    }

//    private String [] getStringArray(int resId){
//
//        String arrayRes[] = getResources().getStringArray(R.array.chapters_array);
//        if(arrayRes !=null) {
//            return arrayRes;
//        }
//
//        else {
//            throw new Resources.NotFoundException("The array you requested could not be location" + resId) ;
//
//        }
//
//    }
}
