package com.example.guts.test2;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class mainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

   public void onClickTips (View view){
        startActivity(new Intent(mainMenu.this, Tips.class));
    }

    public void onClickCalender (View view){
        startActivity(new Intent(mainMenu.this, Calender.class));
    }

    public void onClickInjections (View view){
        startActivity(new Intent(mainMenu.this, Injections.class));
    }

    public void onClickGraphs (View view){
        startActivity(new Intent(mainMenu.this, GraphMenu.class));
    }


    public void onClickDB (View view){

        DBHandlerGrim dbHandlerGrim = new DBHandlerGrim(this);
        SQLiteDatabase db = dbHandlerGrim.getReadableDatabase();

        User user = new User("Thomas", "Gately", "Thomas@gmail.com",
                    "Gately", 1.0, 1.0);

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
            }
    }


}
