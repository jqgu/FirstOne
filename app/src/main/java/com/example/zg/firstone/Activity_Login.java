package com.example.zg.firstone;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;

public class Activity_Login extends AppCompatActivity {
    Thread thread;
    Handler handler;
    Global_User user = Global_User.getInstance();
    String name;
    int ID;
    int balance;
    int status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message m1 = handler.obtainMessage();
                        String user = ((EditText) findViewById(R.id.user_name)).getText().toString().trim();
                        String passwd = ((EditText) findViewById(R.id.passwd)).getText().toString().trim();
                        int checkCode = check(user, passwd);
                        if (checkCode != 0) {
                            m1.what = checkCode;
                        } else {
                            try {
                                URL url = new URL("http://192.168.0.115/db/gate.php?username=" + user + "&passwd=" + passwd);
                                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                                InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream());
                                BufferedReader br = new BufferedReader(isr);
                                String result = br.readLine();

                                //Log.d("chris", "ready to parse json");
                                JSONObject object = new JSONObject(result);
                                status = object.getInt("status");
                                name = object.getString("name");
                                balance = object.getInt("balance");
                                ID = object.getInt("ID");
                            } catch (JSONException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            } catch (MalformedURLException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            m1.what = status;
                        }
                        handler.sendMessage(m1);
                    }
                });
                thread.start();
            }
        });

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                // TODO Auto-generated method stub
                super.handleMessage(msg);
                AlertDialog.Builder builder=new AlertDialog.Builder(Activity_Login.this);
                builder.setTitle("Ooops");
                builder.setIcon(R.mipmap.error);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                switch (msg.what) {
                    case 1: {
                        builder.setMessage("Wrong username or password, please check again");
                        builder.create().show();
                        break;
                    }
                    case 0: {
                        user.setID(ID);
                        user.setName(name);
                        user.setBalance(balance);
                        Toast.makeText(getApplicationContext(), "name:" + user.getName() + ", ID:" + user.getID() + ",balance:" + user.getBalance(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(getApplicationContext(), Activity_Main.class);
                        startActivity(intent);
                        //finish();
                        break;
                    }
                    case Global_Error.ERROR_EMPTY_USERNAME: {
                        builder.setMessage("User name cannot be empty");
                        builder.create().show();
                        break;
                    }
                    case Global_Error.ERROR_EMPTY_PASSWD: {
                        builder.setMessage("Password cannot be empty");
                        builder.create().show();
                        break;
                    }
                }
            }
        };
    }

    private int check(String username, String passwd) {
        if (username.length() == 0) {
            return Global_Error.ERROR_EMPTY_USERNAME;
        }
        if (passwd.length() == 0) {
            return Global_Error.ERROR_EMPTY_PASSWD;
        }
        return 0;
    }
}
