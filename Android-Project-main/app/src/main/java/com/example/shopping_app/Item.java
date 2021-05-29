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
        return "Name: '" + this.Name + "', Description: '" + this.Description + "', Price: '" + this.Price + "'";
//        return this.Name + " " + this.Description + " " + this.Price;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Name);
        dest.writeString(Description);
        dest.writeString(Price);
        dest.writeInt(image);

    }
    public Item(Parcel in) {
        Name = in.readString();
        Description = in.readString();
        Price = in.readString();
        image = in.readInt();
    }

    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
