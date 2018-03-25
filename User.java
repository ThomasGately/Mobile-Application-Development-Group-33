package com.example.guts.test2;

/**
 * Created by Guts on 25/03/2018.
 */

public class User {
    private int id;
    private String fName;
    private String sName;
    private String email;
    private String password;

    public User(int id, String fName, String sName, String email, String password) {
        this.id = id;
        this.fName = fName;
        this.sName = sName;
        this.email = email;
        this.password = password;
    }

    public User(){
        this.id = 0;
        this.fName = "";
        this.sName = "";
        this.email = "";
        this.password = "";
    }

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getsName() {
        return sName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}