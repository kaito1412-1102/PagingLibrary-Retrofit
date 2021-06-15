package com.example.paginglibrary;

import com.example.paginglibrary.model.MyItem;

import org.jetbrains.annotations.NotNull;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

class ItemDataSourceFactory extends DataSource.Factory {
    private MutableLiveData<PageKeyedDataSource<Integer, MyItem>> itemLiveDataSource = new MutableLiveData<>();

    @NotNull
    @Override
    public DataSource create() {
        ItemDataSource itemDataSource = new ItemDataSource();
        itemLiveDataSource.postValue(itemDataSource);
        return itemDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, MyItem>> getMyItemLiveDataSource() {
        return itemLiveDataSource;
    }
}
