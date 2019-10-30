package com.cmps312.dbtutorial.repos;

import android.provider.BaseColumns;

public interface StudentContract {

    class StudentTable implements BaseColumns{
        public static final String TABLE_NAME = "students";
        public static final String COLUMN_NAME_STUDENT_NAME = "student_name" ;
    }

}
