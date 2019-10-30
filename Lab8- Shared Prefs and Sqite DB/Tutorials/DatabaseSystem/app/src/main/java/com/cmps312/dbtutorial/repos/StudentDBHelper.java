package com.cmps312.dbtutorial.repos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class StudentDBHelper extends SQLiteOpenHelper implements StudentContract {

    //STEP 1
    private static final String DB_NAME = "students.db";
    private static final int VERSION = 1;


    //STEP 2 . create the sql statements that allow us to create the tables

    //CREATE TABLE STUDENT ("_ID INTEGER PRMARY KEY , NAME TEXT");
    private static final String SQL_CREATE_TABLE_STUDENT =
            "CREATE TABLE " + StudentTable.TABLE_NAME
                    + "( "
                    + StudentTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + StudentTable.COLUMN_NAME_STUDENT_NAME + " TEXT "
                    + ");";

    private static final String SQL_DROP_TABLE_STUDENT =
            "DROP TABLE IF EXISTS " + StudentTable.TABLE_NAME;

    public StudentDBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //create
        db.execSQL(SQL_CREATE_TABLE_STUDENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop and recreate
        db.execSQL(SQL_DROP_TABLE_STUDENT);
        onCreate(db);
    }
}



















