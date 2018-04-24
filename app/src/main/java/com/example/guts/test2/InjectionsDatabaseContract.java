package com.example.guts.test2;

import android.provider.BaseColumns;

/**
 * Created by Guts on 25/03/2018.
 */

public final class InjectionsDatabaseContract {

    private InjectionsDatabaseContract() {}

    public static class Injections implements BaseColumns {

        public static final String TABLE_NAME = "Injections";
        public static final String COLUMN_NAME_IID  = "iId";
        public static final String COLUMN_NAME_ID   = "id";
        public static final String COLUMN_NAME_IT   = "insulinTaken";
        public static final String COLUMN_NAME_TYPE = "type";
    }

    protected static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Injections.TABLE_NAME + " (" +
                    Injections.COLUMN_NAME_IID   + " INTEGER PRIMARY KEY, " +
                    Injections.COLUMN_NAME_ID   + " INTEGER, " +
                    Injections.COLUMN_NAME_IT   + " REAL, " +
                    Injections.COLUMN_NAME_TYPE + " TEXT, " +
                    "FOREIGN KEY("+Injections.COLUMN_NAME_ID+") REFERENCES "+UserDatabaseContract.User.TABLE_NAME+"("+UserDatabaseContract.User.COLUMN_NAME_UID+
                    "))";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Injections.TABLE_NAME;
}