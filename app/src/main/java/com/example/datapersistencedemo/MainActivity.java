package com.example.datapersistencedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * 2022.10.9    Sunday
 * 数据持久化,sharedperference + Json
 */
public class MainActivity extends AppCompatActivity {
    private Button btnRead;
    MultipleMedia media;
    private static final String TAG = "MainActivity:wangp";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        测试shared perference
        Button btnWrite = (Button) findViewById(R.id.btn_write);
        btnRead = (Button)findViewById(R.id.btn_read);
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                保存地址data/data/com.example.datapersistencedemo/shared_prefs/data.xml
                SharedPreferences preferences = getSharedPreferences("data",MODE_PRIVATE);
                String name = preferences.getString("name","");
                String logo = preferences.getString("logo","");
                Log.i(TAG,"name:" + name + ",logo:" + logo);
            }
        });
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });
    }

    private void initData() {
        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        media = new MultipleMedia("logo",
                                    "companyname",
                                    "123",
                                    "123.com",
                                    "code",
                                    "harry up");
        editor.putString("name",media.getCompanyName());
        editor.putString("logo",media.getLogo());
        editor.apply();
    }
}