package com.example.paginglibrary;

import android.os.Bundle;

import com.example.paginglibrary.model.MyItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
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
        ItemViewModel itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        rvItem.setAdapter(adapter);
        itemViewModel.itemPageList.observe(this, new Observer<PagedList<MyItem>>() {
            @Override
            public void onChanged(PagedList<MyItem> items) {
                adapter.submitList(items);
            }
        });
    }
}