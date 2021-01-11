package com.example.home_page;

public class ImageQC {
    int ID;
    String Name;
    String Image;

    public ImageQC(int id, String name, String image){
        this.ID = id;
        this.Name = name;
        this.Image = image;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public String getImage() {
        return Image;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "ImageQC{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Image='" + Image + '\'' +
                '}';
    }
}
