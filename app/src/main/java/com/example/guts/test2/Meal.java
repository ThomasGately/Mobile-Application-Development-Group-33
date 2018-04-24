package com.example.guts.test2;

/**
 * Created by Guts on 11/04/2018.
 */

public class Meal {
    private int mId;
    private int id;
    private String mealType;
    private String mealName;
    private double carbohydrates;
    private double sugar;

    public Meal (int mId, int id, String mealType, String mealName, double carbohydrates, double sugar){
        this.mId = mId;
        this.id = id;
        this.mealType = mealType;
        this.mealName = mealName;
        this.carbohydrates = carbohydrates;
        this.sugar = sugar;
    }

    public Meal (String mealType, String mealName, double carbohydrates, double sugar){
        this.mealType = mealType;
        this.mealName = mealName;
        this.carbohydrates = carbohydrates;
        this.sugar = sugar;
    }

    public Meal (int id, String mealType, String mealName, double carbohydrates, double sugar){
        this.id = id;
        this.mealType = mealType;
        this.mealName = mealName;
        this.carbohydrates = carbohydrates;
        this.sugar = sugar;
    }

    public int getId() {
        return id;
    }

    public String getMealType() {
        return mealType;
    }

    public String getMealName() {
        return mealName;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getSuger() {
        return sugar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public void setSuger(double suger) {
        this.sugar = suger;
    }
}
