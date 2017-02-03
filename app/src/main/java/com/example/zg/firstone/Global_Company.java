package com.example.zg.firstone;

import java.util.HashMap;

/**
 * Created by LG on 2017/1/31.
 */
public class Global_Company {
    private String name;
    private int imageId;
    public static HashMap<String, Integer> compList = getList();
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
    private static HashMap<String, Integer> getList(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Adidas", R.drawable.comp_adi);
        map.put("Apple", R.drawable.comp_apple);
        map.put("Audi", R.drawable.comp_audi);
        map.put("BMW", R.drawable.comp_bmw);
        map.put("Dell",R.drawable.comp_dell);
        map.put("Dossier", R.drawable.comp_dos);
        map.put("Google", R.drawable.comp_google);
        map.put("IBM", R.drawable.comp_ibm);
        map.put("Kodak", R.drawable.comp_kodak);
        map.put("Microsoft", R.drawable.comp_micro);
        map.put("NYSE", R.drawable.comp_nyse);
        map.put("oneWord", R.drawable.comp_one);
        map.put("StarBucks", R.drawable.comp_star);
        map.put("2K", R.drawable.comp_2k);
        map.put("Cisco", R.drawable.comp_cisco);
        map.put("Kraft", R.drawable.comp_kraft);
        return map;
    }
}
