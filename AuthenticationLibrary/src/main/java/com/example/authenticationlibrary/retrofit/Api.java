package com.example.authenticationlibrary.retrofit;

import com.example.authenticationlibrary.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://localhost:3005/";

    @Headers("Content-type: application/json")
    @POST("users/register")
    Call<User> register(@Body User user);

    @Headers("Content-type: application/json")
    @POST("jwt-login")
    Call<String> jwtLogin(@Body User user);


    @GET("users/verify-token")
    Call<Boolean> verifyToken(@Query("Access-Token") String accessToken);
}
