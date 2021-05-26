package com.example.shopping_app;

public class Item {
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
    }
}
