package com.example.paginglibrary;

import com.example.paginglibrary.model.MyItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestApi {
    @GET("/v2/list")
    Call<ArrayList<MyItem>> STRING_CALL(@Query("page") int page,
                                        @Query("limit") int limit);
}
