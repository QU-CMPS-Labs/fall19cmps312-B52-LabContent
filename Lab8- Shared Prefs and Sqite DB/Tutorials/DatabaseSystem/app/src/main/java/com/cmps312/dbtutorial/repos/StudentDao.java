package com.cmps312.dbtutorial.repos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.cmps312.dbtutorial.models.Student;

import java.util.ArrayList;

public class StudentDao implements StudentContract {

    private StudentDBHelper dbHelper;
    private SQLiteDatabase db;

    public StudentDao(Context context) {
        this.dbHelper = new StudentDBHelper(context);
    }

    //adding to the database

    public long addStudent(Student student) {

        //Step 1. to open the database for writing
        db = dbHelper.getWritableDatabase();

        //Step 2. content values

        ContentValues values = new ContentValues();
        values.put(StudentTable.COLUMN_NAME_STUDENT_NAME, student.getName());
        return db.insert(StudentTable.TABLE_NAME, null, values);

    }

    public Student getStudent(String name) {
        //step 1. to open the database for reading

        db = dbHelper.getReadableDatabase();

        String columns[] = {StudentTable.COLUMN_NAME_STUDENT_NAME};
        String selection = StudentTable._ID + " = ?";
        String selectionArgs[] = {String.valueOf(6)};
        Cursor cursor = db.query(StudentTable.TABLE_NAME, columns, selection, selectionArgs, null, null, null, null);


//        Cursor cursor = db.rawQuery("SELECT " + StudentTable.COLUMN_NAME_STUDENT_NAME
//                + " FROM " +StudentTable.TABLE_NAME
//                + " WHERE " + StudentTable.COLUMN_NAME_STUDENT_NAME + " LIKE " + name , null);
        if (cursor.moveToFirst())
            return changeCtoS(cursor);
        return null;
    }

    public Student changeCtoS(Cursor cursor) {
        Log.d("TAGUIR", "changeCtoS: " + cursor.getInt(cursor.getColumnIndex(StudentTable._ID)));

        return new Student(cursor.getString(cursor.getColumnIndex(StudentTable.COLUMN_NAME_STUDENT_NAME)));
    }

    public ArrayList<Student> getAllStudent() {

        String rawQuery = "SELECT * FROM " + StudentTable.TABLE_NAME;
        db = dbHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery(rawQuery, null);
        ArrayList<Student> students = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                students.add(changeCtoS(cursor));
            } while (cursor.moveToNext());
        }

        return students;
    }

}


















































