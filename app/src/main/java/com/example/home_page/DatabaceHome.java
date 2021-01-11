package com.example.home_page;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaceHome extends SQLiteOpenHelper {

    public DatabaceHome(Context context)  {
        super(context, "DATAHOME", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String script = "CREATE TABLE Content (ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Image TEXT, Price INTEGER, Note TEXT)";
        db.execSQL(script);

        String script1 = "CREATE TABLE Image (ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Image TEXT)";
        db.execSQL(script1);

        String C4 = "INSERT INTO Content(Name,Image,Price,Note)" + " VALUES ('Coffe Chon', 'image1', 25 ,'Đa dạng về sản phẩm và chủng loại');";
        db.execSQL(C4);

        String C5 = "INSERT INTO Content(Name,Image,Price,Note)" + " VALUES ('Coffe F1', 'image2', 35 ,'Đúng chất đường đua f1, chất lượng nói lên tất cả');";
        db.execSQL(C5);

        String C1 = "INSERT INTO Content(Name,Image,Price,Note)" + " VALUES ('Coffe Cao Nguyên', 'image3', 15 ,'Cao nguyên xanh, sửa mát lành');";
        db.execSQL(C1);

        String C2 = "INSERT INTO Content(Name,Image,Price,Note)" + " VALUES ('Coffe Trung Du', 'image4', 10 ,'Hương vị đồng quê, bao ngon bao test');";
        db.execSQL(C2);



        String I1 = "INSERT INTO Image(Name,Image)" + " VALUES ('Coffe', 'back');";
        db.execSQL(I1);

        String I2 = "INSERT INTO Image(Name,Image)" + " VALUES ('Coffe', 'back1');";
        db.execSQL(I2);

        String I3 = "INSERT INTO Image(Name,Image)" + " VALUES ('Coffe', 'back2');";
        db.execSQL(I3);

        String I4 = "INSERT INTO Image(Name,Image)" + " VALUES ('Coffe', 'back3');";
        db.execSQL(I4);

        String I5 = "INSERT INTO Image(Name,Image)" + " VALUES ('Coffe', 'back4');";
        db.execSQL(I5);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // Drop table
        db.execSQL("DROP TABLE IF EXISTS Content");

        // Recreate
        onCreate(db);
    }

    public List<ImageQC> getAllImage(){
        List<ImageQC>  imageList = new ArrayList<>();
        String query = "SELECT * FROM Image";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) { //int id, String name, String image
            ImageQC image = new ImageQC(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            imageList.add(image);
            cursor.moveToNext();
        }
        return imageList;
    }


    public List<Coffee> getAllData() {
        List<Coffee>  studentList = new ArrayList<>();
        String query = "SELECT * FROM Content";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        while(cursor.isAfterLast() == false) {  //int id, String name, String image, int price, String note
            Coffee coffee = new Coffee(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getString(4));
            studentList.add(coffee);
            cursor.moveToNext();
        }
        return studentList;
    }

    public void addCoffee(Coffee coffee) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("Name", coffee.getName());
        values.put("Image", coffee.getImage());
        values.put("Price", coffee.getPrice());
        values.put("Note", coffee.getNote());

        db.insert("Content", null, values);
        db.close();
    }
}
