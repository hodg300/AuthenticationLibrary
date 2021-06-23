package com.example.authenticationlibrary.model;


import java.io.Serializable;

public class User implements Serializable {


    private String email;
    private String fullName;

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

}