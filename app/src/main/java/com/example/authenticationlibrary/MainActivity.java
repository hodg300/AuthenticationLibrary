package com.example.authenticationlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Authentication.register(MainActivity.this, "hod@gmail.com", "12345678", "hod gohasi", new UserCallBack(){
//
//            @Override
//            public void onSuccess(User value) {
//                System.out.println(value);
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//
//            }
//        });
    }
}