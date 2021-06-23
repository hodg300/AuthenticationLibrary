package com.example.authenticationlibrary.retrofit;



import androidx.annotation.NonNull;


import okhttp3.Response;


public interface CallBack {
    void onSuccess(@NonNull Response value);

    void onError(@NonNull Throwable throwable);
}