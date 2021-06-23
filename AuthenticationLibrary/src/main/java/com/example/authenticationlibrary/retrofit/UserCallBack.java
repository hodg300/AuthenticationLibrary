package com.example.authenticationlibrary.retrofit;



import androidx.annotation.NonNull;

import com.example.authenticationlibrary.model.User;

public interface UserCallBack {
    void onSuccess(@NonNull User value);

    void onError(@NonNull Throwable throwable);
}