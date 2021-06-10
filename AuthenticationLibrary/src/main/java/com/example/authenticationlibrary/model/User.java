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
