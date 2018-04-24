package com.example.guts.test2;

import android.provider.BaseColumns;

/**
 * Created by Guts on 12/04/2018.
 */

public class MealDatabaseContract {

    private MealDatabaseContract() {}

    public static class Meal implements BaseColumns {

        public static final String TABLE_NAME = "Meals";
        public static final String COLUMN_NAME_MID           = "mId";
        public static final String COLUMN_NAME_ID            = "id";
        public static final String COLUMN_NAME_MEALTYPE      = "mealType";
        public static final String COLUMN_NAME_MEALNAME      = "mealName";
        public static final String COLUMN_NAME_CARBOHYDRATES = "carbohydrates";
        public static final String COLUMN_NAME_SUGAR         = "sugar";
    }

    protected static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Meal.TABLE_NAME + " (" +
                    Meal.COLUMN_NAME_MID           + " INTEGER PRIMARY KEY, " +
                    Meal.COLUMN_NAME_ID            + " INTEGER, " +
                    Meal.COLUMN_NAME_MEALTYPE      + " TEXT, " +
                    Meal.COLUMN_NAME_MEALNAME      + " TEXT, " +
                    Meal.COLUMN_NAME_CARBOHYDRATES + " REAL, " +
                    Meal.COLUMN_NAME_SUGAR         + " REAL, " +
                    "FOREIGN KEY("+Meal.COLUMN_NAME_ID+") REFERENCES "+UserDatabaseContract.User.TABLE_NAME+"("+UserDatabaseContract.User.COLUMN_NAME_UID+
                    "))";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Meal.TABLE_NAME;
}
