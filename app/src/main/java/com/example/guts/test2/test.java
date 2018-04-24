package com.example.guts.test2;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;


public class test extends AppCompatActivity{

    public void test1(){

        DBHandlerGrim dbHandlerGrim = new DBHandlerGrim(this);
        SQLiteDatabase db = dbHandlerGrim.getReadableDatabase();

        /*User user = new User("Thomas", "Gately", "kek@gmail.com",
                    "kek", 1.0, 1.0);

            dbHandlerGrim.insertUser(db, user);

            int lnikID = 0;

            double[] BS = {
                    5.65, 4.2, 2.11, 8.23, 4.25, 16, 8, 6.9, 3.31, 17,
                    5.65, 4.2, 2.11, 8.23, 4.25, 16, 8, 6.9, 3.31, 17,
                    5.65, 4.2, 2.11, 8.23, 4.25, 16, 8, 6.9, 3.31, 17};

            double[] I = {
                    4.25, 16, 8, 6.9, 3.31, 17, 5.65, 4.2, 2.11, 8.23,
                    4.25, 16, 8, 6.9, 3.31, 17, 5.65, 4.2, 2.11, 8.23,
                    4.25, 16, 8, 6.9, 3.31, 17, 5.65, 4.2, 2.11, 8.23};

            String meal = "chips";
            String mealT = "dinner";

            double[] C = {
                    4.25, 16, 8, 6.9, 3.31, 17, 5.65, 4.2, 2.11, 8.23,
                    4.25, 16, 8, 6.9, 3.31, 17, 5.65, 4.2, 2.11, 8.23,
                    4.25, 16, 8, 6.9, 3.31, 17, 5.65, 4.2, 2.11, 8.23};

            double[] S = {
                    4.25, 16, 8, 6.9, 3.31, 17, 5.65, 4.2, 2.11, 8.23,
                    4.25, 16, 8, 6.9, 3.31, 17, 5.65, 4.2, 2.11, 8.23,
                    4.25, 16, 8, 6.9, 3.31, 17, 5.65, 4.2, 2.11, 8.23};

            for (int i = 1; i < 31; i++){

                lnikID = dbHandlerGrim.getNewLink(db);
                dbHandlerGrim.insertLink(db,       new Link(lnikID, i, 1, 2018, "00-00-00"), lnikID);
                dbHandlerGrim.insertInjection(db,  new Injection(I[i-1], "normal"), lnikID);
                dbHandlerGrim.insertMeal(db,       new Meal(mealT, meal, C[i-1], S[i-1]), lnikID);
                dbHandlerGrim.insertBloodSugar(db, new BloodSugar(BS[i-1]), lnikID);
            }*/
    }
}
