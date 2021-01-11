package com.example.home_page;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder> {

    List<ImageQC> ImageList;
    Context context;
    public ImageAdapter(List<ImageQC> ImageList, Context context) {
        this.ImageList = ImageList;
        this.context = context;
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image,parent, false);

        return new ImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder holder,final int position) {
//        Log.d("iteam",String.valueOf(position));
        int id = context.getResources().getIdentifier(ImageList.get(position).getImage(), "drawable", context.getPackageName());
        holder.image.setImageDrawable(context.getResources().getDrawable(id));
    }

    @Override
    public int getItemCount() {
        return ImageList.size();
    }

    public static class ImageHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageRecy);
        }
    }

}
