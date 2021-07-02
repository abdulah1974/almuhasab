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
    ArrayList<String> Phone;
    ArrayList<String> price;
    ArrayList<String> Name;
    ArrayList<Integer> Image;
    LayoutInflater mInflater;
  recylerview(Context context ,ArrayList<Integer> imgList,ArrayList<String> Name,ArrayList<String> price,ArrayList<String> Phone)
  {
    this.context = context;
    this.Image=imgList;
    this.Name=Name;
    this.price=price;
    this.Phone=Phone;

  }

    @NonNull
    @Override
    public recylerview.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recorders,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull recylerview.ViewHolder holder, int position) {
        holder.item.setImageResource(Integer.valueOf(Image.get(position)));
        holder.ItemName.setText(String.valueOf(Name.get(position)));
        holder.ItemPrice.setText(String.valueOf(price.get(position)));
        holder.phone.setText(String.valueOf(Phone.get(position)));
    }


    @Override
    public int getItemCount(){
        return Phone.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView item;
        TextView ItemName;
        TextView ItemPrice;
        TextView phone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ItemName = itemView.findViewById(R.id.item_name_);
            item = itemView.findViewById(R.id.item_);
            ItemPrice = itemView.findViewById(R.id.item_price);
            phone=itemView.findViewById(R.id.phone);

        }
    }
}