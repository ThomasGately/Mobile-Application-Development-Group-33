package com.example.guts.test2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Guts on 30/03/2018.
 */


public class DBHandlerGrim extends SQLiteOpenHelper {

    private static final String DB_NAME = "GrimDB";
    private static final int DB_VERSION = 1;
    private static String userId = "1";

    public DBHandlerGrim(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserDatabaseContract.SQL_CREATE_ENTRIES);
        db.execSQL(LinkDatabaseContract.SQL_CREATE_ENTRIES);
        db.execSQL(MealDatabaseContract.SQL_CREATE_ENTRIES);
        db.execSQL(InjectionsDatabaseContract.SQL_CREATE_ENTRIES);
        db.execSQL(BloodSugarDatabaseContract.SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO: implement onUpgrade()
    }

    public void setUID(int id){
        userId =   Integer.toString(id);
    }

    public void insertUser(SQLiteDatabase db, User user) {
        ContentValues cvUser = new ContentValues();
        cvUser.put(UserDatabaseContract.User.COLUMN_NAME_UID,
                findNewPlace(db, UserDatabaseContract.User.COLUMN_NAME_UID, UserDatabaseContract.User.TABLE_NAME));
        cvUser.put(UserDatabaseContract.User.COLUMN_NAME_SNAME,      user.getfName());
        cvUser.put(UserDatabaseContract.User.COLUMN_NAME_FNAME,      user.getsName());
        cvUser.put(UserDatabaseContract.User.COLUMN_NAME_EMAIL,      user.getEmail());
        cvUser.put(UserDatabaseContract.User.COLUMN_NAME_PASSWORD,   user.getPassword());
        cvUser.put(UserDatabaseContract.User.COLUMN_NAME_MULTIPLIER, user.getMultiplier());
        cvUser.put(UserDatabaseContract.User.COLUMN_NAME_TARGETBS,   user.getTargetBS());
        db.insert(UserDatabaseContract.User.TABLE_NAME, null, cvUser);
    }

    public void insertLink(SQLiteDatabase db, Link link, int linkId) {
        ContentValues cv = new ContentValues();
        cv.put(LinkDatabaseContract.Link.COLUMN_NAME_ID,    linkId);
        cv.put(LinkDatabaseContract.Link.COLUMN_NAME_UID,   userId);
        cv.put(LinkDatabaseContract.Link.COLUMN_NAME_DATED, link.getDateD());
        cv.put(LinkDatabaseContract.Link.COLUMN_NAME_DATEM, link.getDateM());
        cv.put(LinkDatabaseContract.Link.COLUMN_NAME_DATEY, link.getDateY());
        cv.put(LinkDatabaseContract.Link.COLUMN_NAME_TIME,  link.getTime());
        db.insert(LinkDatabaseContract.Link.TABLE_NAME, null, cv);
    }

    public void insertInjection(SQLiteDatabase db, Injection injection,  int linkId) {
        ContentValues cv = new ContentValues();
        cv.put(InjectionsDatabaseContract.Injections.COLUMN_NAME_IID,
                findNewPlace(db, InjectionsDatabaseContract.Injections.COLUMN_NAME_IID, InjectionsDatabaseContract.Injections.TABLE_NAME));
        cv.put(InjectionsDatabaseContract.Injections.COLUMN_NAME_ID,   linkId);
        cv.put(InjectionsDatabaseContract.Injections.COLUMN_NAME_IT,   injection.getInsulinTaken());
        cv.put(InjectionsDatabaseContract.Injections.COLUMN_NAME_TYPE, injection.getType());;
        db.insert(InjectionsDatabaseContract.Injections.TABLE_NAME, null, cv);
    }

    public void insertMeal(SQLiteDatabase db, Meal Meal,  int linkId) {
        ContentValues cv = new ContentValues();
        cv.put(MealDatabaseContract.Meal.COLUMN_NAME_MID,
                findNewPlace(db, MealDatabaseContract.Meal.COLUMN_NAME_MID, MealDatabaseContract.Meal.TABLE_NAME));
        cv.put(MealDatabaseContract.Meal.COLUMN_NAME_ID,            linkId);
        cv.put(MealDatabaseContract.Meal.COLUMN_NAME_MEALTYPE,      Meal.getMealType());
        cv.put(MealDatabaseContract.Meal.COLUMN_NAME_MEALNAME,      Meal.getMealName());
        cv.put(MealDatabaseContract.Meal.COLUMN_NAME_CARBOHYDRATES, Meal.getCarbohydrates());
        cv.put(MealDatabaseContract.Meal.COLUMN_NAME_SUGAR,         Meal.getSuger());
        db.insert(MealDatabaseContract.Meal.TABLE_NAME, null, cv);
    }

    public void insertBloodSugar(SQLiteDatabase db, BloodSugar BloodSugar, int linkId) {
        ContentValues cv = new ContentValues();
        cv.put(BloodSugarDatabaseContract.BloodSugar.COLUMN_NAME_BSID,
                findNewPlace(db, BloodSugarDatabaseContract.BloodSugar.COLUMN_NAME_BSID, BloodSugarDatabaseContract.BloodSugar.TABLE_NAME));
        cv.put(BloodSugarDatabaseContract.BloodSugar.COLUMN_NAME_ID, linkId);
        cv.put(BloodSugarDatabaseContract.BloodSugar.COLUMN_NAME_BS, BloodSugar.getBloodSugar());
        db.insert(BloodSugarDatabaseContract.BloodSugar.TABLE_NAME, null, cv);
    }

    public int getNewLink(SQLiteDatabase db){

        return findNewPlace(db, LinkDatabaseContract.Link.COLUMN_NAME_ID, LinkDatabaseContract.Link.TABLE_NAME);
    }

    private int findNewPlace(SQLiteDatabase db, String input, String tableName) {

        int count = 1;
        boolean found = false;

        String[] columns = {
                input
        };

        Cursor cursor = db.query(tableName, //Table to query
                columns,
                null,
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {
            do {
                if(Integer.parseInt(cursor.getString(cursor.getColumnIndex(input))) != count)
                    found = true;
                count++;
            } while (cursor.moveToNext() && !found);
        }
        return count;
    }

    private Cursor cursorOP(SQLiteDatabase db, String table, String[] columns, String type, String query){

        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        String selection = LinkDatabaseContract.Link.COLUMN_NAME_UID+"=?";
        String[] selectionArgs = new String[4];
        String[] temp = query.split("-");
        String groupBy = null;
        String having = null;
        String sortOrder = null;

        queryBuilder.setTables(LinkDatabaseContract.Link.TABLE_NAME + " INNER JOIN " +
                table + " ON " +
                LinkDatabaseContract.Link.TABLE_NAME + ".ID = " +
                table + ".ID");

        switch (type) {

            case "day" :

                selectionArgs[0] = userId;
                selectionArgs[1] = temp[0];
                selectionArgs[2] = temp[1];
                selectionArgs[3] = temp[2];
                selection += " AND "+LinkDatabaseContract.Link.COLUMN_NAME_DATED+"=?"+
                        " AND "+LinkDatabaseContract.Link.COLUMN_NAME_DATEM+" = ?"+
                        " AND "+LinkDatabaseContract.Link.COLUMN_NAME_DATEY+" = ?";

                break;
            case "month" :

                Log.e("grim", selectionArgs.toString());
                selectionArgs[0] = userId;
                selectionArgs[1] = temp[0];
                selectionArgs[2] = temp[1];
                selection += " AND "+LinkDatabaseContract.Link.COLUMN_NAME_DATEM+" = ?"+
                        " AND "+LinkDatabaseContract.Link.COLUMN_NAME_DATEY+" = ?";
                break;
            case "year" :

                selectionArgs[0] = userId;
                selectionArgs[1] = query;
                selection += " AND "+LinkDatabaseContract.Link.COLUMN_NAME_DATEY+" = ?";
                break;
            case "OP" :

                Log.e("grim", Arrays.toString(temp));
                selectionArgs[0] = userId;
                selectionArgs[1] = temp[0];
                selectionArgs[2] = temp[1];
                selection += " AND "+LinkDatabaseContract.Link.COLUMN_NAME_DATEM+" = ?"+
                        " AND "+LinkDatabaseContract.Link.COLUMN_NAME_DATEY+" = ?";
                groupBy = LinkDatabaseContract.Link.COLUMN_NAME_DATED;

        }

        List<String> list = new ArrayList<String>();

        for(String s : selectionArgs) {
            if(s != null && s.length() > 0) {
                list.add(s);
            }
        }

        selectionArgs = list.toArray(new String[list.size()]);

        Cursor cursor = queryBuilder.query(db,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                sortOrder);

        return cursor;
    }

    public List<User> getAllUser(SQLiteDatabase db) {

        String[] columns = {
                UserDatabaseContract.User.COLUMN_NAME_UID,
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
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(UserDatabaseContract.User.COLUMN_NAME_UID))));
                user.setsName(cursor.getString(cursor.getColumnIndex(UserDatabaseContract.User.COLUMN_NAME_SNAME)));
                user.setfName(cursor.getString(cursor.getColumnIndex(UserDatabaseContract.User.COLUMN_NAME_FNAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(UserDatabaseContract.User.COLUMN_NAME_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(UserDatabaseContract.User.COLUMN_NAME_PASSWORD)));
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return userList;
    }

    public List<Injection> getInjection(SQLiteDatabase db, String type, String query) {

        String table = InjectionsDatabaseContract.Injections.TABLE_NAME;

        String[] columns = {
                InjectionsDatabaseContract.Injections.COLUMN_NAME_IT,
                InjectionsDatabaseContract.Injections.COLUMN_NAME_TYPE
        };

        Cursor cursor = cursorOP(db, table, columns, type, query);

        List<Injection> InjectionList = new ArrayList<Injection>();

        if (cursor.moveToFirst()) {
            do {
                Injection injection = new Injection(
                Double.parseDouble(cursor.getString(cursor.getColumnIndex(InjectionsDatabaseContract.Injections.COLUMN_NAME_IT))),
                cursor.getString(cursor.getColumnIndex(InjectionsDatabaseContract.Injections.COLUMN_NAME_TYPE)));
                InjectionList.add(injection);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return InjectionList;
    }

    public List<Meal> getMeals(SQLiteDatabase db, String type, String query) {

        String table = MealDatabaseContract.Meal.TABLE_NAME;

        String[] columns = {
                MealDatabaseContract.Meal.COLUMN_NAME_MEALTYPE,
                MealDatabaseContract.Meal.COLUMN_NAME_MEALNAME,
                MealDatabaseContract.Meal.COLUMN_NAME_CARBOHYDRATES,
                MealDatabaseContract.Meal.COLUMN_NAME_SUGAR
        };

        Cursor cursor = cursorOP(db, table, columns, type, query);

        List<Meal> MealList = new ArrayList<Meal>();

        if (cursor.moveToFirst()) {
            do {
                Meal meal = new Meal(
                        cursor.getString(cursor.getColumnIndex(MealDatabaseContract.Meal.COLUMN_NAME_MEALTYPE)),
                        cursor.getString(cursor.getColumnIndex(MealDatabaseContract.Meal.COLUMN_NAME_MEALNAME)),
                        Double.parseDouble(cursor.getString(cursor.getColumnIndex(MealDatabaseContract.Meal.COLUMN_NAME_CARBOHYDRATES))),
                        Double.parseDouble(cursor.getString(cursor.getColumnIndex(MealDatabaseContract.Meal.COLUMN_NAME_SUGAR))));
                MealList.add(meal);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return MealList;
    }

    public List<BloodSugar> getBloodSugar(SQLiteDatabase db, String type, String query) {

        String table = BloodSugarDatabaseContract.BloodSugar.TABLE_NAME;

        String[] columns = {
                BloodSugarDatabaseContract.BloodSugar.COLUMN_NAME_BSID,
                BloodSugarDatabaseContract.BloodSugar.COLUMN_NAME_BS
        };

        Cursor cursor = cursorOP(db, table, columns, type, query);

        List<BloodSugar> BloodSugarList = new ArrayList<BloodSugar>();

        if (cursor.moveToFirst()) {
            do {
                BloodSugar bloodSugar = new BloodSugar(
                        Integer.parseInt(cursor.getString(cursor.getColumnIndex(BloodSugarDatabaseContract.BloodSugar.COLUMN_NAME_BSID))),
                        Double.parseDouble(cursor.getString(cursor.getColumnIndex(BloodSugarDatabaseContract.BloodSugar.COLUMN_NAME_BS))));
                BloodSugarList.add(bloodSugar);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return BloodSugarList;
    }

    private ArrayList<Double[]> getAvgOrCount(SQLiteDatabase db,  String table, String type, String query, String column) {

        String[] columns = {
                LinkDatabaseContract.Link.COLUMN_NAME_DATED,
                column
        };

        Cursor cursor = cursorOP(db, table, columns, type, query);

        ArrayList<Double[]> list = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                list.add(new Double[] {
                        Double.parseDouble(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(0)))),
                        Double.parseDouble(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(1))))});
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public ArrayList<Double[]> getAvgBloodSugar(SQLiteDatabase db, String type, String query) {

        String table = BloodSugarDatabaseContract.BloodSugar.TABLE_NAME;
        String column = "AVG("+BloodSugarDatabaseContract.BloodSugar.COLUMN_NAME_BS+")";
        return getAvgOrCount(db, table, "OP", query, column);
    }

    public ArrayList<Double[]> getCountCarbohydrates(SQLiteDatabase db, String type, String query) {

        String table = MealDatabaseContract.Meal.TABLE_NAME;
        String column = "SUM("+MealDatabaseContract.Meal.COLUMN_NAME_CARBOHYDRATES+")";
        return getAvgOrCount(db, table, "OP", query, column);
    }

    public ArrayList<Double[]> getCountSugar(SQLiteDatabase db, String type, String query) {

        String table = MealDatabaseContract.Meal.TABLE_NAME;
        String column = "SUM("+MealDatabaseContract.Meal.COLUMN_NAME_SUGAR+")";
        return getAvgOrCount(db, table, "OP", query, column);
    }
}

