package com.example.zg.firstone;

/**
 * Created by LG on 2017/1/31.
 */
public class Global_Company {
    private String name;
    private int imageId;
    public Global_Company(String name, int imageId) {
        this.name = name + " Inc.";
        this.imageId = imageId;
    }
    public String getName() {
        return name;
    }
    public int getImageId() {
        return imageId;
    }
}
