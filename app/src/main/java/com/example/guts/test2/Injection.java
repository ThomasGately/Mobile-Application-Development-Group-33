package com.example.guts.test2;

/**
 * Created by Guts on 25/03/2018.
 */

public class Injection {
    private int iId;
    private int id;
    private double insulinTaken;
    private String type;

    public Injection(int iId, int id, double insulinTaken, String type){
        this.iId = iId;
        this.id = id;
        this.insulinTaken = insulinTaken;
        this.type = type;
    }

    public Injection(double insulinTaken, String type){
        this.insulinTaken = insulinTaken;
        this.type = type;
    }

    public Injection(int id, double insulinTaken, String type){
        this.id = id;
        this.insulinTaken = insulinTaken;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public double getInsulinTaken() {
        return insulinTaken;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInsulinTacken(double insulinTacken) {
        this.insulinTaken = insulinTaken;
    }

    public void setType(String type) {
        this.type = type;
    }
}
