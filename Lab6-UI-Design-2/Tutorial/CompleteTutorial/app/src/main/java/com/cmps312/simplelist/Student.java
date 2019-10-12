package com.cmps312.simplelist;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Student implements Parcelable {

    private String name;
    private int image;
    private String bio;


    public Student(String name, int image, String bio) {
        this.name = name;
        this.image = image;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public static ArrayList<Student> getStudents() {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Abdulahi", R.drawable.student1, "Was born in Mars and came to earth in 1900"));
        students.add(new Student("Mohamed", R.drawable.student2, "Was born in Qatar and came to earth in 1977"));
        students.add(new Student("Ali", R.drawable.student3, "Was born in UK and came to earth in 2022"));

        return students;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.image);
        dest.writeString(this.bio);
    }

    protected Student(Parcel in) {
        this.name = in.readString();
        this.image = in.readInt();
        this.bio = in.readString();
    }

    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public String toString() {
        return name;
    }
}


























