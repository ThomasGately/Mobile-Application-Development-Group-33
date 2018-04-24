package com.example.guts.test2;

import android.util.Log;

import java.time.LocalDateTime;

/**
 * Created by Guts on 11/04/2018.
 */

public class Link {
    private int id;
    private int uId;
    private int dateD;
    private int dateM;
    private int dateY;
    private String time;
    private LocalDateTime dateTime = LocalDateTime.now();

    public Link (int id){
        this.id    = id;
        Log.e("link", dateTime.getMonthValue()+" -- "+dateTime.getYear());
        this.dateD = dateTime.getDayOfMonth();
        this.dateM = dateTime.getMonthValue();
        this.dateY = dateTime.getYear();
        this.time  = dateTime.getHour()+"/"+dateTime.getMinute();
    }

    public Link (int id, int dateD, int dateM, int dateY, String time){
        this.id    = id;
        this.dateD = dateD;
        this.dateM = dateM;
        this.dateY = dateY;
        this.time  = time;
    }

    public int getId() {
        return id;
    }

    public int getuId() {
        return uId;
    }

    public int getDateD() {
        return dateD;
    }

    public int getDateM() {
        return dateM;
    }

    public int getDateY() {
        return dateY;
    }

    public String getTime() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public void setDateD(int dateD) {
        this.dateD = dateD;
    }

    public void setDateM(int dateM) {
        this.dateM = dateM;
    }

    public void setDateY(int dateY) {
        this.dateY = dateY;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
