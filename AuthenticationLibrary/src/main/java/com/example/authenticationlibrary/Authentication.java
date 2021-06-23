package com.example.authenticationlibrary;



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

    void Authentication(String port){
        this.port = port;
        this.baseUrl = "http://"+ port +":3005/";
    }

    public void register(String email, String password, String fullName,
                                @NonNull CallBack callBacks){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create("{\n    \"email\": \"" + email + "\",\n    \"password\": \""+ password+"\",\n    \"fullName\": \""+ fullName +"\"\n}", mediaType);
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
                if (callBacks != null)
                    callBacks.onSuccess(response);
            }
        });
    }
//    public static void register(String email, String password, String fullName,
//                                @NonNull UserCallBack callBacks){
//        mApi = ApiUtils.getApi();
////        User user = new User();
////        user.setEmail(email);
////        user.setFullName(fullName);
////        user.setPassword(password);
//        mApi.register(email, password, fullName).enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                if (!response.isSuccessful()) {
//                    Log.i("TAG", "onResponse: " + response.code());
////                    Toast.makeText(context, "Something wrong: " + response.toString(), Toast.LENGTH_SHORT).show();
//                    return;
//                } else {
//                    Log.i("TAG", "onResponse: " + response.code());
////                    Toast.makeText(context, "user register", Toast.LENGTH_SHORT).show();
//                    if (callBacks != null)
//                        callBacks.onSuccess(response.body());
////                    user[0] = response.body();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                System.out.println("error:" + mApi.toString());
////                Toast.makeText(context, "An error has occured", Toast.LENGTH_LONG).show();
//                if (callBacks != null)
//                    callBacks.onError(t);
//            }
//
//        });
//    }

//    public static void home(Context context, @NonNull UserCallBack callBacks){
//        // Instantiate the RequestQueue.
//        RequestQueue queue = Volley.newRequestQueue(context);
//        String url ="https://www.google.com";
//
//// Request a string response from the provided URL.
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                response -> {
//                    // Display the first 500 characters of the response string.
////                    textView.setText("Response is: "+ response.substring(0,500));
//                   Toast.makeText(context, "get data: " + response, Toast.LENGTH_SHORT).show();
//
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
////                textView.setText("That didn't work!");
//                Toast.makeText(context, "An error has occured", Toast.LENGTH_LONG).show();
//
//            }
//        });
//
//// Add the request to the RequestQueue.
//        queue.add(stringRequest);
//    }


//    private static User parseArray(JSONArray jsonArray) {
//        User user = null;
//        for(int i=0 ; i< jsonArray.length(); i++){
//            try {
//                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                user = new User(jsonObject.getString("email"), jsonObject.getString("fullName"));
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//        return user;
//    }

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
