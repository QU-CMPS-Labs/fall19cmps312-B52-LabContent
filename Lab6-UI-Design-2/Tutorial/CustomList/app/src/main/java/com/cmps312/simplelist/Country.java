package com.cmps312.simplelist;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Country implements Parcelable {

    private String name;
    private String capitalCity;
    private int flag;

    public Country(String name, String capitalCity, int flag) {
        this.name = name;
        this.capitalCity = capitalCity;
        this.flag = flag;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public static ArrayList<Country> getCountries(){

        ArrayList<Country> countries = new ArrayList<>();

        countries.add(new Country("Russia", "Tokyo", R.drawable.russia_flag));
        countries.add(new Country("Qatar", "Doha", R.drawable.qatar_flag));
        countries.add(new Country("German", "Berlin", R.drawable.qatar_flag));

        return countries;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.capitalCity);
        dest.writeInt(this.flag);
    }

    protected Country(Parcel in) {
        this.name = in.readString();
        this.capitalCity = in.readString();
        this.flag = in.readInt();
    }

    public static final Parcelable.Creator<Country> CREATOR = new Parcelable.Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel source) {
            return new Country(source);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };
}






























