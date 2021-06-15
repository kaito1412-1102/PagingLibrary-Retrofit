package com.example.paginglibrary;

import android.util.Log;

import com.example.paginglibrary.model.MyItem;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import androidx.paging.PageKeyedDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@SuppressWarnings("deprecation")
public class ItemDataSource extends PageKeyedDataSource<Integer, MyItem> {
    private static final int FIRST_PAGE = 1;
    private static final int LIMIT = 10;

    @Override
    public void loadAfter(@NotNull LoadParams<Integer> loadParams, @NotNull LoadCallback<Integer, MyItem> loadCallback) {
        Log.d("TAG", "loadAfter: key = " + loadParams.key);
        ServiceGenerator.getRequestApi().STRING_CALL(loadParams.key, LIMIT)
                .enqueue(new Callback<ArrayList<MyItem>>() {
                    @Override
                    public void onResponse(Call<ArrayList<MyItem>> call, Response<ArrayList<MyItem>> response) {
                        if (response.isSuccessful() && response != null) {
                            Integer key = loadParams.key + 1;
                            loadCallback.onResult(response.body(), key);
                        }
                    }

                    @Override
                    public void onFailure(Call<ArrayList<MyItem>> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadBefore(@NotNull LoadParams<Integer> loadParams, @NotNull LoadCallback<Integer, MyItem> loadCallback) {

    }

    @Override
    public void loadInitial(@NotNull LoadInitialParams<Integer> loadInitialParams, @NotNull LoadInitialCallback<Integer, MyItem> loadInitialCallback) {
        ServiceGenerator.getRequestApi().STRING_CALL(FIRST_PAGE, LIMIT).enqueue(new Callback<ArrayList<MyItem>>() {
            @Override
            public void onResponse(Call<ArrayList<MyItem>> call, Response<ArrayList<MyItem>> response) {
                if (response.isSuccessful() && response != null) {
                    Log.d("TAG", "loadInitial: " + response.body().size());
                    loadInitialCallback.onResult(response.body(), null, FIRST_PAGE + 1);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<MyItem>> call, Throwable t) {

            }
        });
    }
}
