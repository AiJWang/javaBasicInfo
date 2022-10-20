package com.example.ServletFinalPractise.entity;

public class EmpManager {
    String username;
    String PASSWORD;
    public EmpManager(String usr,String pwd){
        this.username=usr;
        this.PASSWORD=pwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
}
