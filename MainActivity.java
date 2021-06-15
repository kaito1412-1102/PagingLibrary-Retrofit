package com.example.paginglibrary;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvItem = findViewById(R.id.rv_item);
        rvItem.setLayoutManager(new LinearLayoutManager(this));
        MyItemAdapter adapter = new MyItemAdapter(this);
        rvItem.setAdapter(adapter);
    }
}