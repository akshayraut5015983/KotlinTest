package com.example.mykotlinapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    public RecyclerView recyclerView;
    private Adapter adapter;
    private LinearLayoutManager layoutManager;
    List<MOdell> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String[] fruits = getResources().getStringArray(R.array.item_fruits);
        String[] price = getResources().getStringArray(R.array.item_price);


        for (int i = 0; i < fruits.length; i++) {

            MOdell fruits1 = new MOdell(fruits[i], price[i], false);
            items.add(fruits1);
        }
        adapter = new Adapter(MainActivity2.this, items);
        recyclerView.setAdapter(adapter);


    }

    public static void listGet() {

    }

}