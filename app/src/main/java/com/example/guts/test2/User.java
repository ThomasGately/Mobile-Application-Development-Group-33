package com.example.guts.test2;

/**
 * Created by Guts on 25/03/2018.
 */

public class User {
    private int uId;
    private String fName;
    private String sName;
    private String email;
    private String password;
    private double multiplier;
    private double targetBS;

    public User(int uId, String fName, String sName, String email, String password, double multiplier, double targetBS) {
        this.uId = uId;
        this.fName = fName;
        this.sName = sName;
        this.email = email;
        this.password = password;
        this.multiplier = multiplier;
        this.targetBS = targetBS;
    }

    public User(String fName, String sName, String email, String password, double multiplier, double targetBS) {
        this.fName = fName;
        this.sName = sName;
        this.email = email;
        this.password = password;
        this.multiplier = multiplier;
        this.targetBS = targetBS;
    }

    public User(String fName, String sName, String email, String password) {
        this.fName = fName;
        this.sName = sName;
        this.email = email;
        this.password = password;
    }

    public User(){
        this.uId = 0;
        this.fName = "";
        this.sName = "";
        this.email = "";
        this.password = "";
    }

    public int getId() {
        return uId;
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

    public double getMultiplier() {
        return multiplier;
    }

    public double getTargetBS() {
        return targetBS;
    }

    public void setId(int id) {
        this.uId = id;
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

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public void setTargetBS(double targetBS) {
        this.targetBS = targetBS;
    }
}