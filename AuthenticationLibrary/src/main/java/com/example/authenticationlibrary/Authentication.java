package com.example.authenticationlibrary;

import android.content.Context;
import android.widget.Toast;

import com.example.authenticationlibrary.model.User;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Authentication {
    public static User login(Context c){
        Toast.makeText(c, "Login", Toast.LENGTH_LONG).show();
        return new User("1234","hod@gmail.com", "hod gohasi", "12345678", "1111");
    }

    public static User register(Context c){
        Toast.makeText(c, "register", Toast.LENGTH_LONG).show();
        return new User("1234", "hod@gmail.com", "hod gohasi", "12345678", "1111");
    }

    public static void logout(Context c){
        Toast.makeText(c, "logout", Toast.LENGTH_LONG).show();
    }

    public static String executePost(String targetURL, String urlParameters) {
        HttpURLConnection connection = null;

        try {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }


}
