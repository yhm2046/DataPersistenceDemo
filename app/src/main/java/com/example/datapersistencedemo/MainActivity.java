package com.example.datapersistencedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * 2022.10.9    Sunday
 * 数据持久化,sharedperference + Json
 */
public class MainActivity extends AppCompatActivity {
    MultipleMedia media;
    private static final String TAG = "MainActivity:wangp";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        测试shared perference
        Button btnWrite = findViewById(R.id.btn_write);
        Button btnRead =  findViewById(R.id.btn_read);
        btnRead.setOnClickListener(view -> {
//                保存地址data/data/com.example.datapersistencedemo/shared_prefs/data.xml
//                testSharedPreference();
            try {
//                    读取gson的方法
                SharedPreferences preferences = getSharedPreferences("DATA", MODE_PRIVATE);
                String s = preferences.getString("USER_DATA", "Data is not saved" );

                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<MultipleMedia>>(){} .getType();
                ArrayList<MultipleMedia> mUser = gson.fromJson(s, type);
                for (int i = 0; i < mUser.size(); i++)
                    Log.i(TAG,"name:" + mUser.get(i).getCompanyName()
                            + ",logo:" + mUser.get(i).getLogo());
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
                Log.i(TAG,"exception:" + e);
            }
        });
        btnWrite.setOnClickListener(view -> {
//                initData();
            saveData();
        });
    }

    /**
     * 简单保存到sharedpreference方法
     */
    private void testSharedPreference() {
        SharedPreferences preferences = getSharedPreferences("data",MODE_PRIVATE);
        String name = preferences.getString("name","");
        String logo = preferences.getString("logo","");
        Log.i(TAG,"name:" + name + ",logo:" + logo);
    }

    /**
     * 保存自定义类到gson的方法
     */
    private void saveData() {
        ArrayList<MultipleMedia>list = new ArrayList<>();
        media = new MultipleMedia("logo",
                "companyname",
                "123",
                "123.com",
                "code",
                "harry up");
        MultipleMedia multipleMedia =  new MultipleMedia("dongf",
                "df",
                "456",
                "456.com",
                "code2",
                "welcome!");
        list.add(media);
        list.add(multipleMedia);
        SharedPreferences preferences = getSharedPreferences("DATA" , MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        String s = gson.toJson(list);
        editor.putString("USER_DATA", s);
        editor.apply();
    }

}