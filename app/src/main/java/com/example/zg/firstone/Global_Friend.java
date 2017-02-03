package com.example.zg.firstone;

import java.util.HashMap;

/**
 * Created by LG on 2017/2/1.
 */
public class Global_Friend {
    public static HashMap<String, Integer>friendImageList = getImageList();
    private String name;
    private int imageID;
    public Global_Friend(String name, int imageID){
        this.name       = name;
        this.imageID    = imageID;
    }

    public String getName(){
        return this.name;
    }

    public int getImageID(){
        return this.imageID;
    }

    private static HashMap<String, Integer> getImageList(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Admin", R.drawable.user_admin);
        map.put("Chris", R.drawable.user_chris);
        map.put("Ellain", R.drawable.user_ellain);
        map.put("Jack", R.drawable.user_jack);
        map.put("Mary", R.drawable.user_marry);
        map.put("Bob", R.drawable.user_bob);
        map.put("Calvin", R.drawable.user_calvin);
        map.put("Ray", R.drawable.user_ray);
        map.put("Harry", R.drawable.user_harry);
        map.put("Carl", R.drawable.user_carl);
        return map;
    }
}
