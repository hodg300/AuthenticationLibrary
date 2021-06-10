package com.example.authenticationlibrary.model;

public class User {
    private String uid;
    private String email;
    private String fullName;
    private String password;
    private String token;


    public User(String uid, String email, String fullName, String password, String token) {
        this.uid = uid;
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.token = token;
    }

    public User(){}

    public String getUid() {
        return uid;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }



    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
