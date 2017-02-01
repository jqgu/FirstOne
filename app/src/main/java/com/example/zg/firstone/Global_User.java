package com.example.zg.firstone;

/**
 * Created by LG on 2017/1/16.
 */
public class Global_User {
    private String name = "";
    private int ID = -1;
    private int balance = -1;
    private int investment = -1;
    private int loan = -1;
    private static Global_User instance = new Global_User();
    private Global_User(){}
    public static Global_User getInstance(){
        return instance;
    }
    public void setName(String name){
        instance.name = name;
    }
    public void setID(int ID){
        instance.ID = ID;
    }
    public void setBalance(int balance){
        instance.balance = balance;
    }

    public int getID(){
        return instance.ID;
    }

    public String getName(){
        return instance.name;
    }

    public int getBalance(){
        return instance.balance;
    }

}
