package com.cmps312.dbtutorial.repos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cmps312.dbtutorial.models.Student;

public class StudentDao implements StudentContract {

    private SQLiteDatabase db;
    private DBHelper dbHelper;


    public StudentDao(Context context) {
        this.dbHelper = new DBHelper(context);
    }

    public ContentValues changeStudentToContentValues(Student student) {
        ContentValues values = new ContentValues();
        values.put(StudentTable.COLUMN_NAME_SID, student.getStudentId());
        values.put(StudentTable.COLUMN_NAME_STUDENT_NAME, student.getName());

        return values;
    }

    public long addStudent(Student student) {

        //Step 1 : to open the database for writing
        db = dbHelper.getWritableDatabase();

        //change the student to content values that the DB understand

        ContentValues values = changeStudentToContentValues(student);
        return db.insert(StudentTable.TABLE_NAME, null, values);

    }

    public long updateStudent(Student student) {

        //Step 1 : to open the database for writing
        db = dbHelper.getWritableDatabase();
        ContentValues values = changeStudentToContentValues(student);

        String whereClause = StudentTable.COLUMN_NAME_SID + " = ?";
        String whereArgs[] = {String.valueOf(student.getStudentId())};
        return db.update(StudentTable.TABLE_NAME, values, whereClause, whereArgs);

    }


    public long deleteStudent(Student student) {

        //Step 1 : to open the database for writing
        db = dbHelper.getWritableDatabase();

        String whereClause = StudentTable.COLUMN_NAME_SID + " = ?";
        String whereArgs[] = {String.valueOf(student.getStudentId())};

        return db.delete(StudentTable.TABLE_NAME, whereClause, whereArgs);

    }

    public Student getStudent(int studentId) {

        db = dbHelper.getReadableDatabase();


        Student student = new Student();

        String selection = StudentTable.COLUMN_NAME_SID + " = ?";
        String selectionArgs[] = {String.valueOf(studentId)};
        String columns[] = {StudentTable.COLUMN_NAME_SID, StudentTable.COLUMN_NAME_STUDENT_NAME};

        Cursor cursor =db.query(StudentTable.TABLE_NAME, columns, selection, selectionArgs, null, null, null, null);

        //change the cursor to student

        if(cursor.moveToFirst()){
            cursor.getColumnIndex(StudentTable.COLUMN_NAME_SID);

            int nameIndex = cursor.getColumnIndex(StudentTable.COLUMN_NAME_STUDENT_NAME);
            int idIndex = cursor.getColumnIndex(StudentTable.COLUMN_NAME_SID);

            student.setStudentId(cursor.getInt(idIndex)); //SID
            student.setName(cursor.getString(nameIndex)); // Name
        }
        
        return student;

    }
}
