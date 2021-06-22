package com.example.authenticationlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.authenticationlibrary.model.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user = Authentication.register(MainActivity.this, "hod@gmail.com", "12345678", "hod gohasi");
        System.out.println("hi:" + user);
    }
}