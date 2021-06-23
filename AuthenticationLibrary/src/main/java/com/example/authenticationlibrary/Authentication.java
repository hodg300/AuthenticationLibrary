package com.example.authenticationlibrary;



import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.authenticationlibrary.retrofit.CallBack;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Authentication {

    private String port;
    private String baseUrl;

    public Authentication(String port){
        this.port = port;
        this.baseUrl = "http://"+ port +":3005/";
    }

    public Authentication(){}

    public void register(Context context, String email, String password, String fullName,
                                @NonNull CallBack callBacks){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create("{\n    \"email\": \"" + email + "\",\n    \"password\": \""+ password+"\",\n    \"fullName\": \""+ fullName +"\"\n   }", mediaType);
        Request request = new Request.Builder()
                .url(this.baseUrl + "users/register")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println(e);
                if (callBacks != null)
                    callBacks.onError(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                System.out.println(response);
                if(response.isSuccessful() && response.body() != null) {
                    if (callBacks != null)
                        callBacks.onSuccess(response);
                }else{
                    Toast.makeText(context, "Email already exists", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void login(Context  context, String email, String password,
                         @NonNull CallBack callBacks){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create("{\n    \"email\": \"" + email + "\",\n    \"password\": \"" + password + "\"\n    }", mediaType);
        Request request = new Request.Builder()
                .url(this.baseUrl + "users/jwt-login")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println(e);
                Toast.makeText(context, "An error has occured", Toast.LENGTH_LONG).show();
                if (callBacks != null)
                    callBacks.onError(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                System.out.println(response);
                if(response.isSuccessful() && response.body() != null){
                    if (callBacks != null)
                        callBacks.onSuccess(response);
                }else{
                    Toast.makeText(context, "Invalid email or password", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void verifyToken(Context context, String accessToken,
                      @NonNull CallBack callBacks){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create("{}", mediaType);
        Request request = new Request.Builder()
                .url(this.baseUrl + "users/verify-token")
                .method("GET", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Access-Token", accessToken)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println(e);
                if (callBacks != null)
                    callBacks.onError(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                System.out.println(response);
                if(response.isSuccessful() && response.body() != null) {
                    if (callBacks != null)
                        callBacks.onSuccess(response);
                }else{
                    Toast.makeText(context, "An error has occured", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void signOut(Context context){
        SharedPreferences pref = context.getSharedPreferences("MyPref", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove("access_token");
        editor.commit();
    }

    public boolean checkLoggedIn(Context context){
        SharedPreferences pref = context.getSharedPreferences("MyPref", 0);
        if(pref.contains("access_token")){
            return true;
        }
        return false;
    }





//    public static String login(Context context, String email, String password){
//        final String[] accessToken = new String[1];
//        Call<String> call = RetrofitClient.getInstance().getMyApi().jwtLogin(new User(email, password));
//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                accessToken[0] = response.body();
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                Toast.makeText(context, "An error has occured", Toast.LENGTH_LONG).show();
//            }
//
//        });
//        return accessToken[0];
//    }

//    public static boolean verifyToken(Context context, String accessToken){
//        final boolean[] isVerified = new boolean[1];
//        Call<Boolean> call = mApi.verifyToken(accessToken);
//        call.enqueue(new Callback<Boolean>() {
//            @Override
//            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
//
//                if (response.isSuccessful()) {
//                    try {
//                        JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
//                        isVerified[0] = jsonObject.getBoolean("isVerified");
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Boolean> call, Throwable t) {
//                Toast.makeText(context, "An error has occured", Toast.LENGTH_LONG).show();
//            }
//
//        });
//        return isVerified[0];
//    }

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
