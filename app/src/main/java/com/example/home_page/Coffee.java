package com.example.home_page;

public class Coffee {
    int ID;
    String Name;
    String Image;
    int Price;
    String Note;

    public Coffee(int id, String name, String image, int price, String note){
        this.ID = id;
        this.Image = image;
        this.Name = name;
        this.Price = price;
        this.Note = note;
    }

    public Coffee(String name, String image, int price, String note){
        this.Image = image;
        this.Name = name;
        this.Price = price;
        this.Note = note;
    }

    public int getID() {
        return ID;
    }

    public int getPrice() {
        return Price;
    }

    public String getImage() {
        return Image;
    }

    public String getName() {
        return Name;
    }

    public String getNote() {
        return Note;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setNote(String note) {
        Note = note;
    }

    public void setPrice(int price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Image='" + Image + '\'' +
                ", Price=" + Price +
                ", Note='" + Note + '\'' +
                '}';
    }
}
