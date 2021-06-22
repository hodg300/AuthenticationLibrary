package com.example.authenticationlibrary.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;
    @SerializedName("fullName")
    private String fullName;

    public User(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public User(String email, String fullName) {
        this.email = email;
        this.fullName = fullName;
    }

    public User(){}

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }
}