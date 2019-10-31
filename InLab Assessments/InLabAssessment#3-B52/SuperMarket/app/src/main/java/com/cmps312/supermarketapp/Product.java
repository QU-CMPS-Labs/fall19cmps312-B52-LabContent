package com.cmps312.supermarketapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    private String productName;
    private String size;
    private int price;

    public Product(String productName, String size, int price) {
        this.productName = productName;
        this.size = size;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.productName);
        dest.writeString(this.size);
        dest.writeInt(this.price);
    }

    protected Product(Parcel in) {
        this.productName = in.readString();
        this.size = in.readString();
        this.price = in.readInt();
    }

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
