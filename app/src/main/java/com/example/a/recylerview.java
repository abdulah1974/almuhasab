package com.example.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recylerview extends RecyclerView.Adapter<recylerview.ViewHolder> {
    Context context;
    private  ArrayList size;
    ArrayList<Integer> imgList;;
    LayoutInflater mInflater;
  recylerview(Context context,ArrayList arrayList ,ArrayList<Integer> imgList)
  {
        this.context = context;
        this.size=arrayList;
        this.imgList=imgList;
    }

    @NonNull
    @Override
    public recylerview.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recorders, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull recylerview.ViewHolder holder, int position) {
        size.get(position);
        holder.item.setImageResource(Integer.valueOf(imgList.get(position)));
        holder.ItemName.setText(String.valueOf(size.get(position)));
        holder.ItemPrice.setText(String.valueOf(size.get(position)));
        holder.photo.setText(String.valueOf(size.get(position)));
    }


    @Override
    public int getItemCount(){
        return size.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView item;
        TextView ItemName;
        TextView ItemPrice;
        TextView photo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ItemName = itemView.findViewById(R.id.item_name_);
            item = itemView.findViewById(R.id.item_);
            ItemPrice = itemView.findViewById(R.id.item_price);
            photo=itemView.findViewById(R.id.phone);

        }
    }
}