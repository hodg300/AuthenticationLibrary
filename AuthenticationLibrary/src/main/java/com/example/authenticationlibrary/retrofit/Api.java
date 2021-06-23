//package com.example.authenticationlibrary.retrofit;
//
//import com.example.authenticationlibrary.model.User;
//
//import retrofit2.Call;
//import retrofit2.http.Body;
//import retrofit2.http.Field;
//import retrofit2.http.FormUrlEncoded;
//import retrofit2.http.GET;
//import retrofit2.http.Headers;
//import retrofit2.http.POST;
//import retrofit2.http.Query;
//
//public interface Api {
//
//    @Headers({
//            "Content-Type: application/json; charset=utf-8",
//            "User-Agent: PostmanRuntime/7.26.8",
//            "Cache-Control: no-cache"
//    })
//    @FormUrlEncoded
//    @POST("users/register")
//    Call<User> register(@Field("email") String email,
//                                       @Field("password") String password,
//                                       @Field("fullName") String fullName);
//
//    @Headers("Content-type: application/json")
//    @POST("jwt-login")
//    Call<String> jwtLogin(@Body User user);
//
//
//    @GET("users/verify-token")
//    Call<Boolean> verifyToken(@Query("Access-Token") String accessToken);
//
//    @GET(".")
//    Call<String> home();
//}
