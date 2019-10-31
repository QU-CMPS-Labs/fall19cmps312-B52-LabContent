package com.cmps312.dbtutorial.repos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cmps312.dbtutorial.models.Student;

public class StudentDao implements StudentContract {

    //two things to work
    //the sqldatabase
    //sql dbhelper

    private SQLiteDatabase db;
    private MyDBHelper helper;

    public StudentDao(Context context) {
        this.helper = new MyDBHelper(context);
    }

    //adding to the database

    //the row ID of the newly inserted row, or -1 if an error occurred
    public long addStudent(Student student) {
        //1. open the databse

        db = helper.getWritableDatabase();

        //2. to change the student to a content values
        ContentValues values = new ContentValues();

        values.put(StudentTable.COLUMN_NAME_STUDENT_NAME, student.getName());
        values.put(StudentTable.COLUMN_NAME_SID, student.getStudentId());

        return db.insert(StudentTable.TABLE_NAME, "", values);
    }

    public long updateStudent(Student student) {

        //1. open the database
        db = helper.getWritableDatabase();

        //convert it into values
        ContentValues values = new ContentValues();

        values.put(StudentTable.COLUMN_NAME_STUDENT_NAME, student.getName());
        values.put(StudentTable.COLUMN_NAME_SID, student.getStudentId());

        String whereClause = StudentTable.COLUMN_NAME_SID + " = ?";
        String whereArgs[] = {String.valueOf(student.getStudentId())};


        return db.update(StudentTable.TABLE_NAME, values, whereClause, whereArgs);

    }

    public long deleteStudent(Student student) {

        //1. open the database
        db = helper.getWritableDatabase();

        //convert it into values

        String whereClause = StudentTable.COLUMN_NAME_SID + " = ?";
        String whereArgs[] = {String.valueOf(student.getStudentId())};


        return db.delete(StudentTable.TABLE_NAME, whereClause, whereArgs);

    }


    public Student getStudent(int studentId) {

        //1. open the database
        db = helper.getWritableDatabase();

        //convert it into values

        String selection = StudentTable.COLUMN_NAME_SID + " = ?";
        String selectionArgs[] = {String.valueOf(studentId)};

        String columns[] = {StudentTable.COLUMN_NAME_SID, StudentTable.COLUMN_NAME_STUDENT_NAME};


        Cursor cursor = db.query(StudentTable.TABLE_NAME, columns, selection, selectionArgs, null, null, null, null);


        //change to a student object

        Student student = new Student();

        student.setName(cursor.getString(cursor.getColumnIndex(StudentTable.COLUMN_NAME_STUDENT_NAME)));
        student.setStudentId(cursor.getInt(cursor.getColumnIndex(StudentTable.COLUMN_NAME_SID)));

        return  student;

    }


}
































