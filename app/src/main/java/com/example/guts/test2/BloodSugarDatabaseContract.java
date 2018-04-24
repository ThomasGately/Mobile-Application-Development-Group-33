package com.example.guts.test2;

import android.provider.BaseColumns;

/**
 * Created by Guts on 12/04/2018.
 */

public class BloodSugarDatabaseContract {

    private BloodSugarDatabaseContract() {}

    public static class BloodSugar implements BaseColumns {

        public static final String TABLE_NAME = "Bloods";
        public static final String COLUMN_NAME_BSID = "bsId";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_BS = "BloodSugar";

    }

    protected static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + BloodSugar.TABLE_NAME + " (" +
                    BloodSugar.COLUMN_NAME_BSID + " INTEGER PRIMARY KEY," +
                    BloodSugar.COLUMN_NAME_ID + " INTEGER," +
                    BloodSugar.COLUMN_NAME_BS  + " REAL," +
                    "FOREIGN KEY("+BloodSugar.COLUMN_NAME_ID+") REFERENCES "+UserDatabaseContract.User.TABLE_NAME+"("+UserDatabaseContract.User.COLUMN_NAME_UID+
                    "))";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + BloodSugar.TABLE_NAME;
}
