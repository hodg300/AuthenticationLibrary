package com.example.authenticationlibrary;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.authenticationlibrary.model.User;
import com.example.authenticationlibrary.retrofit.RetrofitClient;
import com.example.authenticationlibrary.retrofit.UserCallBack;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Authentication {


    public static void register(Context context, String email, String password, String fullName, UserCallBack callBacks){

        Call<User> call = RetrofitClient.getInstance().getMyApi().register(new User(email, password, fullName));
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {
                    Log.i("TAG", "onResponse: " + response.code());
                    Toast.makeText(context, "Something wrong: " + response.toString(), Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Log.i("TAG", "onResponse: " + response.code());
                    Toast.makeText(context, "user register", Toast.LENGTH_SHORT).show();
                    if (callBacks != null)
                        callBacks.onSuccess(response.body());
//                    user[0] = response.body();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(context, "An error has occured", Toast.LENGTH_LONG).show();
                if (callBacks != null)
                    callBacks.onError(t);
            }

        });
    }

    private static User parseArray(JSONArray jsonArray) {
        User user = null;
        for(int i=0 ; i< jsonArray.length(); i++){
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                user = new User(jsonObject.getString("email"), jsonObject.getString("fullName"));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public static String login(Context context, String email, String password){
        final String[] accessToken = new String[1];
        Call<String> call = RetrofitClient.getInstance().getMyApi().jwtLogin(new User(email, password));
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                accessToken[0] = response.body();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(context, "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
        return accessToken[0];
    }

    public static boolean verifyToken(Context context, String accessToken){
        final boolean[] isVerified = new boolean[1];
        Call<Boolean> call = RetrofitClient.getInstance().getMyApi().verifyToken(accessToken);
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {

                if (response.isSuccessful()) {
                    try {
                        JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                        isVerified[0] = jsonObject.getBoolean("isVerified");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Toast.makeText(context, "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
        return isVerified[0];
    }

//    public static User login(Context c){
//        Toast.makeText(c, "Login", Toast.LENGTH_LONG).show();
//        return new User("1234","hod@gmail.com", "hod gohasi", "12345678", "1111");
//    }
//
//    public static User register(Context c){
//        Toast.makeText(c, "register", Toast.LENGTH_LONG).show();
//        return new User("1234", "hod@gmail.com", "hod gohasi", "12345678", "1111");
//    }
//
//    public static void logout(Context c){
//        Toast.makeText(c, "logout", Toast.LENGTH_LONG).show();
//    }
//
//    public static String executePost(String targetURL, String urlParameters) {
//        HttpURLConnection connection = null;
//
//        try {
//            //Create connection
//            URL url = new URL(targetURL);
//            connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("POST");
//            connection.setRequestProperty("Content-Type",
//                    "application/x-www-form-urlencoded");
//
//            connection.setRequestProperty("Content-Length",
//                    Integer.toString(urlParameters.getBytes().length));
//            connection.setRequestProperty("Content-Language", "en-US");
//
//            connection.setUseCaches(false);
//            connection.setDoOutput(true);
//
//            //Send request
//            DataOutputStream wr = new DataOutputStream (
//                    connection.getOutputStream());
//            wr.writeBytes(urlParameters);
//            wr.close();
//
//            //Get Response
//            InputStream is = connection.getInputStream();
//            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
//            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
//            String line;
//            while ((line = rd.readLine()) != null) {
//                response.append(line);
//                response.append('\r');
//            }
//            rd.close();
//            return response.toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//            if (connection != null) {
//                connection.disconnect();
//            }
//        }
//    }
//

}
