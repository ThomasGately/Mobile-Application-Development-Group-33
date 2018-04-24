package com.example.guts.test2;

import android.provider.BaseColumns;

/**
 * Created by Guts on 25/03/2018.
 */

public final class UserDatabaseContract {

    private UserDatabaseContract() {}

    public static class User implements BaseColumns {

        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_SNAME = "sName";
        public static final String COLUMN_NAME_FNAME = "fName";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String COLUMN_NAME_EMAIL = "email";
    }

    protected static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + User.TABLE_NAME + " (" +
                    User.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                    User.COLUMN_NAME_SNAME + " TEXT," +
                    User.COLUMN_NAME_FNAME + " TEXT + " +
                    User.COLUMN_NAME_PASSWORD + " TEXT + " +
                    User.COLUMN_NAME_EMAIL + " TEXT + " +
                    ")";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + User.TABLE_NAME;
}
