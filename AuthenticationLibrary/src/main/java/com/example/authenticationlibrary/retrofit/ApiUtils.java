package com.example.authenticationlibrary.retrofit;

public class ApiUtils {

    public static final String BASE_URL = "http://192.168.50.228:3005/";

    public static Api getApi() {
        return RetrofitClient.getClient(BASE_URL).create(Api.class);
    }
}