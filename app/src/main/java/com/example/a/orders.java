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
ArrayList  arrayList;
ArrayList<Integer> imageList;
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        recyclerView = findViewById(R.id.order);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adpater = new recylerview(context,arrayList,imageList);
        recyclerView.setAdapter(Adpater);
        arrayList = new ArrayList<>();
        arrayList.add("jjjk");







    }
}