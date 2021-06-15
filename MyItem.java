package com.example.paginglibrary.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyItem {
    @Expose
    @SerializedName("id")
    private String id;
    @Expose
    @SerializedName("download_url")
    private String image;
    @Expose
    @SerializedName("author")
    private String name;

    public MyItem(String id, String image, String name) {
        this.id = id;
        this.image = image;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
