package com.cmps312.dbtutorial.repos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper implements StudentContract {
    public static final String DB_NAME = "student.db";
    public static final int VERSION = 1;

    public static final String SQL_CREATE_STUDENT_TABLE =
            "CREATE TABLE " + StudentTable.TABLE_NAME
                    + "(" + StudentTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + StudentTable.COLUMN_NAME_SID + " INTEGER, "
                    + StudentTable.COLUMN_NAME_STUDENT_NAME + " TEXT );";

    public static final String SQL_DROP_STUDENT_TABLE =
            "DROP TABLE IF EXISTS " + StudentTable.TABLE_NAME;


    public MyDBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion > oldVersion){
            db.execSQL(SQL_DROP_STUDENT_TABLE);
            onCreate(db);
        }

    }
}
