package com.example.guts.test2;

/**
 * Created by Guts on 25/03/2018.
 */

public class injections {
    private int id;
    private double bloodsuger;
    private double carbohydrates;
    private double suger;
    private double insulinTacken;
    private String mealType;
    private String mealName;
    private String timeDate;

    public injections(int id, double bloodsuger, double carbohydrates, double suger, double insulinTacken, String mealType, String mealName, String timeDate){

        this.id = id;
        this.bloodsuger = bloodsuger;
        this.carbohydrates = carbohydrates;
        this.suger = suger;
        this.insulinTacken = insulinTacken;
        this.mealType = mealType;
        this.mealName = mealName;
        this.timeDate = timeDate;
    }

    public int getId() {
        return id;
    }

    public double getBloodsuger() {
        return bloodsuger;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getSuger() {
        return suger;
    }

    public double getInsulinTacken() {
        return insulinTacken;
    }

    public String getMealType() {
        return mealType;
    }

    public String getMealName() {
        return mealName;
    }

    public String getTimeDate() {
        return timeDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBloodsuger(double bloodsuger) {
        this.bloodsuger = bloodsuger;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public void setSuger(double suger) {
        this.suger = suger;
    }

    public void setInsulinTacken(double insulinTacken) {
        this.insulinTacken = insulinTacken;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }
}
