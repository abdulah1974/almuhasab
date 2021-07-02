package com.example.a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

public class orders extends AppCompatActivity {
recylerview Adpater;
RecyclerView recyclerView;
ArrayList<String> Phone;
ArrayList<String> price;
ArrayList<String> Name;
ArrayList<Integer> imageList;
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        recyclerView = findViewById(R.id.order);
        Phone=new ArrayList<>();
        price=new ArrayList<>();
        Name=new ArrayList<>();
        imageList=new ArrayList<>();
        for (int i = 0 ; i <=10;i++)
        {
            Phone.add(String.valueOf(i));
            price.add(String.valueOf(i));
            Name.add(String.valueOf(i));
            imageList.add(R.drawable.s);
        }
        Adpater = new recylerview(context,imageList,Name,price,Phone);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(Adpater);








    }
}