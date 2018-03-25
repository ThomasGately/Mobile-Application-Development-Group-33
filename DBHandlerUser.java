package com.example.guts.test2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guts on 25/03/2018.
 */

public class DBHandlerUser extends SQLiteOpenHelper {

    private static final String DB_NAME = "tempName";
    private static final int DB_VERSION = 1;

    public DBHandlerUser(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserDatabaseContract.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO: implement onUpgrade()
    }

    private void insertDrink(SQLiteDatabase db, User user) {
        ContentValues cvUser = new ContentValues();
        cvUser.put(UserDatabaseContract.User.COLUMN_NAME_ID, user.getId());
        cvUser.put(UserDatabaseContract.User.COLUMN_NAME_SNAME, user.getfName());
        cvUser.put(UserDatabaseContract.User.COLUMN_NAME_FNAME, user.getsName());
        cvUser.put(UserDatabaseContract.User.COLUMN_NAME_PASSWORD, user.getPassword());
        cvUser.put(UserDatabaseContract.User.COLUMN_NAME_EMAIL, user.getEmail());
        db.insert(UserDatabaseContract.User.TABLE_NAME, null, cvUser);
    }

    public List<User> getAllUser(SQLiteDatabase db) {

        String[] columns = {
                UserDatabaseContract.User.COLUMN_NAME_ID,
                UserDatabaseContract.User.COLUMN_NAME_SNAME,
                UserDatabaseContract.User.COLUMN_NAME_FNAME,
                UserDatabaseContract.User.COLUMN_NAME_PASSWORD,
                UserDatabaseContract.User.COLUMN_NAME_EMAIL
        };

        List<User> userList = new ArrayList<User>();

        Cursor cursor = db.query(UserDatabaseContract.User.TABLE_NAME, //Table to query
                columns,
                null,
                null,
                null,
                null,
                null);


        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(UserDatabaseContract.User.COLUMN_NAME_ID))));
                user.setsName(cursor.getString(cursor.getColumnIndex(UserDatabaseContract.User.COLUMN_NAME_SNAME)));
                user.setfName(cursor.getString(cursor.getColumnIndex(UserDatabaseContract.User.COLUMN_NAME_FNAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(UserDatabaseContract.User.COLUMN_NAME_PASSWORD)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(UserDatabaseContract.User.COLUMN_NAME_EMAIL)));
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return userList;
    }

    public boolean checkUser(SQLiteDatabase db, String email, String password) {

        String[] columns = {UserDatabaseContract.User.COLUMN_NAME_ID};
        String selection = UserDatabaseContract.User.COLUMN_NAME_EMAIL + " = ?" + " AND " + UserDatabaseContract.User.COLUMN_NAME_PASSWORD + " = ?";
        String[] selectionArgs = {email, password};

        Cursor cursor = db.query(UserDatabaseContract.User.TABLE_NAME,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        int cursorCount = cursor.getCount();

        cursor.close();

        if (cursorCount > 0) {
            return true;
        }
        return false;
    }

}