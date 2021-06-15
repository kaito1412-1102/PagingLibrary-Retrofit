package com.example.paginglibrary;

import com.example.paginglibrary.model.MyItem;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

public class ItemViewModel extends ViewModel {
    LiveData<PagedList<MyItem>> itemPageList;
//    LiveData<PageKeyedDataSource<Integer, MyItem>> liveDataSource;

    public ItemViewModel() {
        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();
//        liveDataSource = itemDataSourceFactory.getMyItemLiveDataSource();
        PagedList.Config config = (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(20)    // Ví dụ 1 lần request 10 phần từ thì khi ta setPageSize = 20 nó sẽ request cho ta 2 lần mà không cần phải vuốt nữa
                .build();
        itemPageList = (new LivePagedListBuilder(itemDataSourceFactory, config)).build();
    }
}
