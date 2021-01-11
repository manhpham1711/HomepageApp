package com.example.home_page;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.home_page.R.*;
import static com.example.home_page.R.id.image;

public class ListCoffee extends BaseAdapter {

    ArrayList<Coffee> listCoffee;
    Context context;

    public ListCoffee(ArrayList<Coffee> listCoffee, Context context) {
        this.listCoffee = listCoffee;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listCoffee.size();
    }

    @Override
    public Object getItem(int i) {
        return listCoffee.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listCoffee.get(i).ID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //convertView là View của phần tử ListView, nếu convertView != null nghĩa là
        //View này được sử dụng lại, chỉ việc cập nhật nội dung mới
        //Nếu null cần tạo mới
        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), layout.coffee_view, null);
        } else viewProduct = convertView;

        //Bind sữ liệu phần tử vào View
        Coffee product = (Coffee) getItem(position);
        ((TextView) viewProduct.findViewById(R.id.name)).setText(String.format(new String(product.Name)));
        ((TextView) viewProduct.findViewById(R.id.price)).setText(String.format("$ " + (String.valueOf(product.Price))));
        ((TextView) viewProduct.findViewById(R.id.note)).setText(String.format(new String(product.Note)));

        int id = context.getResources().getIdentifier(listCoffee.get(position).getImage(), "drawable", context.getPackageName());
        ((ImageView) viewProduct.findViewById(R.id.image)).setImageDrawable(context.getResources().getDrawable(id));
        //((ImageView) viewProduct.findViewById(id.image)).setImageResource(drawable.ic_baseline_search_24);


        return viewProduct;
    }
}
