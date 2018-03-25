package com.example.guts.test2;

import android.provider.BaseColumns;

/**
 * Created by Guts on 25/03/2018.
 */

public class InjectionsDatabaseContract {


    private InjectionsDatabaseContract() {}

    public static class Injections implements BaseColumns {

        public static final String TABLE_NAME = "injectionsTable";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_BS = "bloodsuger";
        public static final String COLUMN_NAME_CAR = "carbohydrates";
        public static final String COLUMN_NAME_SUG = "suger";
        public static final String COLUMN_NAME_INT = "insulinTacken";
        public static final String COLUMN_NAME_MTY = "mealType";
        public static final String COLUMN_NAME_MNA = "mealName";
        public static final String COLUMN_NAME_DATE = "timeDate";
    }

    protected static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Injections.TABLE_NAME + " (" +
                    Injections.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                    Injections.COLUMN_NAME_BS + " REAL," +
                    Injections.COLUMN_NAME_CAR + " REAL + " +
                    Injections.COLUMN_NAME_SUG + " REAL + " +
                    Injections.COLUMN_NAME_INT + " REAL + " +
                    Injections.COLUMN_NAME_MTY + " TEXT + " +
                    Injections.COLUMN_NAME_MNA + " TEXT + " +
                    Injections.COLUMN_NAME_DATE + " TEXT + " +
                    ")";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Injections.TABLE_NAME;
}