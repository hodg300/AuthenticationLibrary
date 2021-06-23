package com.example.authenticationlibrary.retrofit;



import com.example.authenticationlibrary.model.User;

public interface UserCallBack {
    void onSuccess(User value);

    void onError(Throwable throwable);
}