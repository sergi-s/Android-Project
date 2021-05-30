package com.example.shopping_app;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Item implements Serializable {
    String Name, Description, Price;
    int image;

    public Item(String Name, String Description, String Price, int image) {
        this.Name = Name;
        this.Description = Description;
        this.Price = Price;
        this.image = image;
    }

    public String toString() {
        return "Name: '" + this.Name + "', Description: '" + this.Description + "', Price: '" + this.Price + "'\n";
//        return this.Name + " " + this.Description + " " + this.Price;
    }
}
