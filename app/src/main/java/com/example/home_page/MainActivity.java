package com.example.home_page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listViewProduct;
    RecyclerView listRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //String name, String image, int price, String note

        DatabaceHome data = new DatabaceHome(this);
//        data.addCoffee(new Coffee("Alo", "image1", 15, "hello all "));

        listViewProduct = findViewById(R.id.listCoffee);
        listViewProduct.setAdapter(new ListCoffee((ArrayList<Coffee>) data.getAllData(), this));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        Log.d("Size",String.valueOf(data.getAllImage().size()));
        listRecycler = findViewById(R.id.Re_Image);
        listRecycler.setLayoutManager(linearLayoutManager);
        listRecycler.setAdapter(new ImageAdapter((ArrayList<ImageQC>) data.getAllImage(), this));
    }
}