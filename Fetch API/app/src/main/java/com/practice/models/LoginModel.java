package com.practice.models;

public class LoginModel {
    private String password;
    private String username;

    public LoginModel() {
    }

    public LoginModel(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
