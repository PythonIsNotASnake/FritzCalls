package com.pinas.fritzcalls;

public class PasswordModel {

    private String password;

    public PasswordModel() {
        this.password = "";
    }

    public PasswordModel(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{\"password\" : \"" + this.password + "\"}";
    }
}
