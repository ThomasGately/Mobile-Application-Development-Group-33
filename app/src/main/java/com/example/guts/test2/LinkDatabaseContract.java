package com.example.guts.test2;

import android.provider.BaseColumns;

/**
 * Created by Guts on 12/04/2018.
 */

public class LinkDatabaseContract {

    private LinkDatabaseContract() {}

    public static class Link implements BaseColumns {

        public static final String TABLE_NAME        = "Links";
        public static final String COLUMN_NAME_ID    = "id";
        public static final String COLUMN_NAME_UID   = "uId";
        public static final String COLUMN_NAME_DATED = "dateD";
        public static final String COLUMN_NAME_DATEM = "dateM";
        public static final String COLUMN_NAME_DATEY = "dateY";
        public static final String COLUMN_NAME_TIME  = "time";

    }

    protected static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Link.TABLE_NAME + " (" +
                    Link.COLUMN_NAME_ID    + " INTEGER PRIMARY KEY," +
                    Link.COLUMN_NAME_UID   + " INTEGER, " +
                    Link.COLUMN_NAME_DATED + " INTEGER, " +
                    Link.COLUMN_NAME_DATEM + " INTEGER, " +
                    Link.COLUMN_NAME_DATEY + " INTEGER, " +
                    Link.COLUMN_NAME_TIME  + " TEXT, " +
                    "FOREIGN KEY("+Link.COLUMN_NAME_UID+") REFERENCES "+UserDatabaseContract.User.TABLE_NAME+"("+UserDatabaseContract.User.COLUMN_NAME_UID+
                    "))";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Link.TABLE_NAME;
}
