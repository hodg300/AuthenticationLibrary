package com.example.authenticationlibrary.model;


import java.io.Serializable;

public class User implements Serializable {


    private String email;
    private String fullName;
    private String accessToken;

    public User(String email, String fullName) {
        super();
        this.email = email;
        this.fullName = fullName;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}