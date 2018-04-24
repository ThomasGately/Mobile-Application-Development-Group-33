package com.example.guts.test2;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;



import java.util.List;

import static com.example.guts.test2.Calender.EXTRA_DATE;

public class DailyView extends AppCompatActivity {

    public final static String EXTRA_PASS = "pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_view);

        DBHandlerGrim dbHandlerGrim = new DBHandlerGrim(this);
        SQLiteDatabase db = dbHandlerGrim.getReadableDatabase();

        String output = "";

        int[] date = getIntent().getIntArrayExtra("com.mycompany.myfirstapp.Date");

        String Date = date[0]+"-"+date[1]+"-"+date[2];
        Log.e("hahhah", Date);

        List<BloodSugar> blood = dbHandlerGrim.getBloodSugar(db, "day", Date);
        List<Injection> injection = dbHandlerGrim.getInjection(db, "day", Date);
        List<Meal> meal = dbHandlerGrim.getMeals(db, "day", Date);

        output = "BloodSugar \n";

        if(blood.size() != 0) {
            for (int i = 0; i < blood.size(); i++) {
                output += blood.get(i).getBloodSugar()+"\n";
            }
        } else {
            output += "No Results\n";
        }

        output += "Injections\n";

        if(injection.size() != 0) {
            for (int i = 0; i < injection.size(); i++) {
                output += injection.get(i).getInsulinTaken() + " -- " + injection.get(i).getType() + "\n";
            }
        } else {
            output += "No Results\n";
        }

        output += "Meals\n";

        if(meal.size() != 0) {
            for (int i = 0; i < meal.size(); i++) {
                output += meal.get(i).getMealType() + " " + meal.get(i).getMealName() + " -Sugar- " + meal.get(i).getSuger() + " -Carbohydrates- " + meal.get(i).getCarbohydrates() + "\n";
            }
        } else {
            output += "No Results\n";
        }

        TextView output2 = (TextView) findViewById(R.id.outputOP);
        output2.setText(output);

    }

        public void onClickNew (View view){
            Intent intent;
            intent = new Intent(DailyView.this, Date.class);
            intent.putExtra(EXTRA_PASS, getIntent().getIntArrayExtra("com.mycompany.myfirstapp.Date"));
            startActivity(intent);
        }
    }